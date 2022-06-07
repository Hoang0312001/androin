package com.example.hoaqua;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String  DATABASE_NAME =  "QLHQ.db";
    private static final String TABLE_NAME = "t_hoaqua";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String LOAI = "loai";
    private static final String DONVITINH = "donvt";
    private static final String DONGIA = "dongia";
    private static final String NOISX = "noisx";


    private static int VERSION = 1;
    private Context context;

    public Database(Context context) {
        super(context, DATABASE_NAME, null , VERSION);
        this.context = context;
//        context.deleteDatabase("QLSV.db");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table "+TABLE_NAME+"("
                +ID+" integer primary key autoincrement,"
                +NAME+" Text,"
                +LOAI+" Text,"
                +DONVITINH+" Text,"
                +DONGIA+" Text,"
                +NOISX+" Text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+DATABASE_NAME);

        onCreate(sqLiteDatabase);
    }
    public void insert(HoaQua hoaQua){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,hoaQua.getTen());
        values.put(LOAI,hoaQua.getLoai());
        values.put(DONVITINH,hoaQua.getDvt());
        values.put(DONGIA,hoaQua.getDongia());
        values.put(NOISX,hoaQua.getNoisx());
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();

    }
    public int update (HoaQua hoaQua){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,hoaQua.getTen());
        values.put(LOAI,hoaQua.getLoai());
        values.put(DONVITINH,hoaQua.getDvt());
        values.put(DONGIA,hoaQua.getDongia());
        values.put(NOISX,hoaQua.getNoisx());
        int result = sqLiteDatabase.update(TABLE_NAME,values,ID +"=?",new String[]{String.valueOf(hoaQua.getId())});
        sqLiteDatabase.close();
        return result;
    }
    public int delete (int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int result = sqLiteDatabase.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return result;
    }
    public List<HoaQua> getAll(){
        List<HoaQua> hoaQuaList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String sql = "select * from "+TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do {
                HoaQua hoaQua = new HoaQua();
                hoaQua.setId(cursor.getInt(0));
                hoaQua.setTen(cursor.getString(1));
                hoaQua.setLoai(cursor.getString(2));
                hoaQua.setDvt(cursor.getString(3));
                hoaQua.setDongia(cursor.getString(4));
                hoaQua.setNoisx(cursor.getString(5));
                hoaQuaList.add(hoaQua);
            } while (cursor.moveToNext());
        }

        return hoaQuaList;
    }
    public HoaQua findById(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,new String[]{ID,NAME,LOAI,DONVITINH,DONGIA,NOISX}, ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);

        if(cursor!=null){
            try {
                cursor.moveToFirst();
                HoaQua hoaQua = new HoaQua();
                hoaQua.setId(cursor.getInt(0));
                hoaQua.setTen(cursor.getString(1));
                hoaQua.setLoai(cursor.getString(2));
                hoaQua.setDvt(cursor.getString(3));
                hoaQua.setDongia(cursor.getString(4));
                hoaQua.setNoisx(cursor.getString(5));
                cursor.close();
                sqLiteDatabase.close();
                return hoaQua;
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
