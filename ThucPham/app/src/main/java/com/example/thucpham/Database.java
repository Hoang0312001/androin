package com.example.thucpham;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String  DATABASE_NAME =  "QLTP.db";
    private static final String TABLE_NAME = "ThucPham";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DONVITINH = "donvt";
    private static final String DONGIA = "dongia";


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
                +DONVITINH+" Text,"
                +DONGIA+" Text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+DATABASE_NAME);

        onCreate(sqLiteDatabase);
    }
    public void insert(ThucPham thucPham){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,thucPham.getName());
        values.put(DONVITINH,thucPham.getDvt());
        values.put(DONGIA,thucPham.getDongia());
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();

    }
    public int update (ThucPham thucPham){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,thucPham.getName());
        values.put(DONVITINH,thucPham.getDvt());
        values.put(DONGIA,thucPham.getDongia());
        int result = sqLiteDatabase.update(TABLE_NAME,values,ID +"=?",new String[]{String.valueOf(thucPham.getId())});
        sqLiteDatabase.close();
        return result;
    }
    public int delete (int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int result = sqLiteDatabase.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return result;
    }
    public List<ThucPham> getAll(){
        List<ThucPham> thucPhamList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String sql = "select * from "+TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do {
                ThucPham thucPham = new ThucPham();
                thucPham.setId(cursor.getInt(0));
                thucPham.setName(cursor.getString(1));
                thucPham.setDvt(cursor.getString(2));
                thucPham.setDongia(cursor.getString(3));
                thucPhamList.add(thucPham);
            } while (cursor.moveToNext());
        }

        return thucPhamList;
    }
    public ThucPham findById(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,new String[]{ID,NAME,DONVITINH,DONGIA}, ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);

        if(cursor!=null){
            try {
                cursor.moveToFirst();
                ThucPham thucPham = new ThucPham();
                thucPham.setId(cursor.getInt(0));
                thucPham.setName(cursor.getString(1));
                thucPham.setDvt(cursor.getString(2));
                thucPham.setDongia(cursor.getString(3));
                cursor.close();
                sqLiteDatabase.close();
                return thucPham;
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
