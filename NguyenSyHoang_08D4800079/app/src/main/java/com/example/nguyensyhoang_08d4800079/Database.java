package com.example.nguyensyhoang_08d4800079;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    // khai bao ten co so du lieu
    public static final String DATABASE_NAME = "QL_vantai2.db";
    // ten bang
    public static final String TABLE_NAME = "a_xe";

    public static final String BKS = "bienkiemsoat";
    public static final String NAME = "tenchuxe";
    public static final String HANGXE = "hangxe";
    public static final String TRONGTAI = "trongtai";
    public static final String HTKD = "hinhthuckinhdoanh";
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
                + BKS + " Text  PRIMARY KEY ,"
                + NAME + " Text,"
                + HANGXE + " Text,"
                + TRONGTAI + " int,"
                + HTKD + " Text)";
        db.execSQL(sqlQuery);
    }

    // quan ly version
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_NAME);
        onCreate(db);
    }

    public void addCar(VanTai vt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Log.e("a",vt.toString());
        values.put(BKS, vt.getBienks());
        values.put(NAME, vt.getTenchuxe());
        values.put(HANGXE, vt.getHangxe());
        values.put(TRONGTAI, vt.getTrongtai());
        values.put(HTKD, vt.getHdkd());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int updateCAR(VanTai vt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BKS, vt.getBienks());
        values.put(NAME, vt.getTenchuxe());
        values.put(HANGXE, vt.getHangxe());
        values.put(TRONGTAI, vt.getTrongtai());
        values.put(HTKD, vt.getHdkd());
        int a = db.update(TABLE_NAME, values, BKS + "=?", new String[]{String.valueOf(vt.getBienks())});
        db.close();
        return a;
    }

    public int deleteCAR(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int del = db.delete(TABLE_NAME, BKS + "=?", new String[]{String.valueOf(id)});
        db.close();
        return del;
    }

    public List<VanTai> getAll() {
        List<VanTai> list = new ArrayList<VanTai>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                VanTai vt = new VanTai();
                vt.setBienks(cursor.getString(0));
                vt.setTenchuxe(cursor.getString(1));
                vt.setHangxe(cursor.getString(2));
                vt.setTrongtai(cursor.getInt(3));
                vt.setHdkd(cursor.getString(4));
                list.add(vt);
            } while (cursor.moveToNext());
        }
        db.close();
        return list;
    }

    public VanTai searchById(String bks) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + BKS + " = " + bks + "";
        Cursor cursor = db.query(TABLE_NAME, new String[]{ NAME, HANGXE, TRONGTAI,HTKD}, BKS + "=?", new String[]{String.valueOf(bks)}
                , null, null, null, null);
        if (cursor != null)
        cursor.moveToFirst();
        VanTai vt = new VanTai();

        vt.setBienks(cursor.getString(0));
        vt.setTenchuxe(cursor.getString(1));
        vt.setHangxe(cursor.getString(2));
        vt.setTrongtai(cursor.getInt(3));
        vt.setHdkd(cursor.getString(4));
        db.close();
        return vt;
    }
}
