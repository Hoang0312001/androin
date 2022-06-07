package com.example.qlvattu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    // khai bao ten co so du lieu
    public static final String DATABASE_NAME = "QLVT.db";
    // ten bang
    public static final String TABLE_NAME = "VatTu";
    //cac truong
    public static final String ID = "id";
    public static final String NAME = "tenvt";
    public static final String DONVI = "donvi";
    public static final String DONGIA = "dongia";
    public static final String HANGSX = "hangsx";
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
                + DONVI + " Text,"
                + DONGIA + " Text,"
                + HANGSX + " Text)";
        db.execSQL(sqlQuery);
    }

    // quan ly version
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_NAME);
        onCreate(db);
    }

    public void addSV(VatTu vt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, vt.getTenvt());
        values.put(DONVI, vt.getDonvi());
        values.put(DONGIA, vt.getDongia());
        values.put(HANGSX, vt.getHangvt());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int updateSV(VatTu vt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, vt.getTenvt());
        values.put(DONVI, vt.getDonvi());
        values.put(DONGIA, vt.getDongia());
        values.put(HANGSX, vt.getHangvt());
        int a = db.update(TABLE_NAME, values, ID + "=?", new String[]{String.valueOf(vt.getId())});
        db.close();
        return a;
    }

    public int deleteSV(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int del = db.delete(TABLE_NAME, ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return del;
    }

    public List<VatTu> getAll() {
        List<VatTu> list = new ArrayList<VatTu>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                VatTu vt = new VatTu();
                vt.setId(cursor.getInt(0));
                vt.setTenvt(cursor.getString(1));
                vt.setDonvi(cursor.getString(2));
                vt.setDongia(cursor.getInt(3));
                vt.setHangvt(cursor.getString(4));
                list.add(vt);
            } while (cursor.moveToNext());
        }
        db.close();
        return list;
    }

    public VatTu searchById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + ID + " = " + id + "";
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID, NAME, DONVI, DONGIA, HANGSX}, ID + "=?", new String[]{String.valueOf(id)}
                , null, null, null, null);
        if (cursor != null)
        cursor.moveToFirst();
        VatTu vt = new VatTu();
        vt.setId(cursor.getInt(0));
        vt.setTenvt(cursor.getString(1));
        vt.setDonvi(cursor.getString(2));
        vt.setDongia(cursor.getInt(3));
        vt.setHangvt(cursor.getString(4));
        db.close();
        return vt;
    }
}
