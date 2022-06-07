package com.example.qlsvp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    // khai bao ten co so du lieu
    public static final String DATABASE_NAME = "qlsvp3.db";
    // ten bang
    public static final String TABLE_NAME = "sinhvien";
    //cac truong
    public static final String ID = "id";
    public static final String NAME = "hoten";
    public static final String img = "img";
    public static final String PHONE = "phone";
    public static final String email = "email";
    // khai bao version
    public static final int VERSION = 1;
    private Context context;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    // tao bang csdl
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " integer  PRIMARY KEY AUTOINCREMENT ,"
                + NAME + " Text,"
                + img + " Text,"
                + PHONE + " Text,"
                + email + " Text)";
        db.execSQL(sqlQuery);
    }

    // quan ly version
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_NAME);
        onCreate(db);
    }

    public void addSV(sinhvien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, sv.getHoten());
        values.put(img, sv.getImg());
        values.put(PHONE, sv.getPhone());
        values.put(email, sv.getEmail());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int updateSV(sinhvien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, sv.getHoten());
        values.put(img, sv.getImg());
        values.put(PHONE, sv.getPhone());
        values.put(email, sv.getEmail());
        int a = db.update(TABLE_NAME, values, ID + "=?", new String[]{String.valueOf(sv.getId())});
        db.close();
        return a;
    }

    public int deleteSV(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int del = db.delete(TABLE_NAME, ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return del;
    }

    public List<sinhvien> getAll() {
        List<sinhvien> list = new ArrayList<sinhvien>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                sinhvien sv = new sinhvien();
                sv.setId(cursor.getInt(0));
                sv.setHoten(cursor.getString(1));
                sv.setImg(cursor.getString(2));
                sv.setPhone(cursor.getString(3));
                sv.setEmail(cursor.getString(4));
                list.add(sv);
            } while (cursor.moveToNext());
        }
        db.close();
        return list;
    }

    public sinhvien searchById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + ID + " = " + id + "";
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID, NAME, img, PHONE, email}, ID + "=?", new String[]{String.valueOf(id)}
                , null, null, null, null);
        if (cursor != null)
        cursor.moveToFirst();
        sinhvien sv = new sinhvien();
        sv.setId(cursor.getInt(0));
        sv.setHoten(cursor.getString(1));
        sv.setImg(cursor.getString(2));
        sv.setPhone(cursor.getString(3));
        sv.setEmail(cursor.getString(4));
        db.close();
        return sv;
    }
}
