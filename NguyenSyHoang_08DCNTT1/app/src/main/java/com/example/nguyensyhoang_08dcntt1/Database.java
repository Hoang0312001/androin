package com.example.nguyensyhoang_08dcntt1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String  DATABASE_NAME =  "QLMT6.db";
    private static final String TABLE_NAME = "t_maytinh";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String LOAI = "loaimt";
    private static final String NAMSX = "namsx";
    private static final String HANGSX = "hangsx";
    private static final String DONGIA = "dongia";
    private static final String SOLUONG = "soluong";

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
                +ID+" Text primary key ,"
                +NAME+" Text,"
                +LOAI+" Text,"
                +NAMSX+" Text,"
                +HANGSX+" Text,"
                +DONGIA+" Text,"
                +SOLUONG+" Text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+DATABASE_NAME);

        onCreate(sqLiteDatabase);
    }
    public void insert(MayTinh mayTinh){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID,mayTinh.getMamt());
        values.put(NAME,mayTinh.getTenmt());
        values.put(LOAI,mayTinh.getLoaimt());
        values.put(NAMSX,mayTinh.getNamsx());
        values.put(HANGSX,mayTinh.getHangsx());
        values.put(DONGIA,mayTinh.getDongia());
        values.put(SOLUONG,mayTinh.getSoluong());

        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();

    }
    public int update (MayTinh mayTinh){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID,mayTinh.getMamt());
        values.put(NAME,mayTinh.getTenmt());
        values.put(LOAI,mayTinh.getLoaimt());
        values.put(NAMSX,mayTinh.getNamsx());
        values.put(HANGSX,mayTinh.getHangsx());
        values.put(DONGIA,mayTinh.getDongia());
        values.put(SOLUONG,mayTinh.getSoluong());
        int result = sqLiteDatabase.update(TABLE_NAME,values,ID +"=?",new String[]{String.valueOf(mayTinh.getMamt())});
        sqLiteDatabase.close();
        return result;
    }
    public int delete (String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int result = sqLiteDatabase.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return result;
    }
    public List<MayTinh> getAll(){
        List<MayTinh> mayTinhList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String sql = "select * from "+TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do {
                MayTinh mayTinh = new MayTinh();
                mayTinh.setMamt(cursor.getString(0));
                mayTinh.setTenmt(cursor.getString(1));
                mayTinh.setLoaimt(cursor.getString(2));
                mayTinh.setNamsx(cursor.getString(3));
                mayTinh.setHangsx(cursor.getString(4));
                mayTinh.setDongia(cursor.getString(5));
                mayTinh.setSoluong(cursor.getString(6));
                mayTinhList.add(mayTinh);
            } while (cursor.moveToNext());
        }

        return mayTinhList;
    }
    public MayTinh findById(String id){
        id = "1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,new String[]{ID,NAME,LOAI,NAMSX,HANGSX,DONGIA,SOLUONG}, ID+"=?",new String[]{id},null,null,null,null);

        if(cursor!=null){

            //try {
                MayTinh mayTinh = new MayTinh();
//                mayTinh.setMamt(cursor.getString(0));
                mayTinh.setTenmt(cursor.getString(1));
                mayTinh.setLoaimt(cursor.getString(2));
                mayTinh.setNamsx(cursor.getString(3));
                mayTinh.setHangsx(cursor.getString(4));
                mayTinh.setDongia(cursor.getString(5));
                mayTinh.setSoluong(cursor.getString(6));
                cursor.close();
                sqLiteDatabase.close();
                return mayTinh;
            //}
           // catch (Exception e){
//                return null;
            //}
        }
        return null;
    }
}
