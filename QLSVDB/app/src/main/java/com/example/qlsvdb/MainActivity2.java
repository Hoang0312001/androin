package com.example.qlsvdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private EditText edtid,edtclass,edtaddress,edtphone,edthoten;
    private Button btnadd,btnupdate,btndel,btnexit;
    private ListView lvsv;

    //csdl
    private Database database;
    private List<sinhvien> listsv;
    private SVAdapter SVAdapter;

    public MainActivity2() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // anh xa
        anhxa();
        database = new Database(this);
        listsv = database.getAll();
        setAdapter();
      btnexit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              finish();
          }
      });
      btnadd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              sinhvien sv = createSV();
              if (sv!=null){
                  database.addSV(sv);
              }
              listsv.clear();
              listsv.addAll(database.getAll());
              setAdapter();
          }
      });
      lvsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              sinhvien sv = listsv.get(position);
              edtid.setText(String.valueOf(sv.getId()));
              edthoten.setText(sv.getHoten());
              edtclass.setText(sv.getLop());
              edtaddress.setText(sv.getDiachi());
              edtphone.setText(sv.getSdt());
              btnadd.setEnabled(false);
              btnupdate.setEnabled(true);
          }
      });
      btnupdate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              sinhvien sv = new sinhvien();
              sv.setId(Integer.parseInt(String.valueOf(edtid.getText())));
              sv.setHoten(edthoten.getText().toString());
              sv.setSdt(edtphone.getText().toString());
              sv.setLop(edtclass.getText().toString());
              sv.setDiachi(edtaddress.getText().toString());
              int kq = database.updateSV(sv);
              if (kq > 0) {
                  listsv.clear();
                  listsv.addAll(database.getAll());
              }if (SVAdapter != null){
                  SVAdapter.notifyDataSetChanged();
              }
              btnadd.setEnabled(true);
              btnupdate.setEnabled(false);
          }


      });
      btndel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              sinhvien sv = new sinhvien();
              int kqxoa = database.deleteSV(Integer.parseInt(edtid.getText().toString()));
              if (kqxoa > 0){
                  Toast.makeText(MainActivity2.this,"xoa thanh cong",Toast.LENGTH_LONG).show();
                  listsv.clear();
                  listsv.addAll(database.getAll());
                  if (SVAdapter != null){
                      SVAdapter.notifyDataSetChanged();;
                  }
              }else{
                  Toast.makeText(MainActivity2.this,"Khong xoa dc",Toast.LENGTH_LONG).show();
              }
          }
      });
      // gắn view cho content menu // you can assign mulpti
        registerForContextMenu(lvsv);
        registerForContextMenu(btnupdate);
    }
    private sinhvien createSV(){
        String hoten = edthoten.getText().toString();
        String lop = edtclass.getText().toString();
        String sdt = edtphone.getText().toString();
        String diachi = edtaddress.getText().toString();
        sinhvien sinhvien = new sinhvien(hoten,lop,diachi,sdt);
        return sinhvien;


    }

    private void setAdapter() {
        if (SVAdapter == null){
            SVAdapter = new SVAdapter(this,R.layout.activity_main2,listsv);
            lvsv.setAdapter(SVAdapter);
        }else{
            SVAdapter.notifyDataSetChanged();
        }
    }

    private void anhxa() {
        edtid = findViewById(R.id.edtId);
        edthoten = findViewById(R.id.edtFullName);
        edtclass = findViewById(R.id.edtClass);
        edtphone = findViewById(R.id.edtPhone);
        edtaddress = findViewById(R.id.edtAddress);
        btnadd = findViewById(R.id.btnInsert);
        btndel = findViewById(R.id.btnDelete);
        btnupdate = findViewById(R.id.btnUpdate);
        btnexit = findViewById(R.id.btnExit);
        lvsv = findViewById(R.id.lvStudent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }
    // xu ly su kien

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_add:{
                // code xu ly
                sinhvien sv = createSV();
                if (sv!=null){
                    database.addSV(sv);
                }
                listsv.clear();
                listsv.addAll(database.getAll());
                setAdapter();
                break;
            }
            case R.id.mnu_update:{

            }
            case R.id.mnu_del:{
                break;
            }
            default:
                System.out.println();
        }
        return super.onOptionsItemSelected(item);
    }
    // context menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == lvsv){
            getMenuInflater().inflate(R.menu.menu_context,menu);
        }
        if (v == btnupdate){
            getMenuInflater().inflate(R.menu.menu_context,menu);

        }
    }
    // xu ly event in context menu


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // xu ly giong menu above
        switch (item.getItemId()){
            case R.id.mnu_upd:{
                // code here
                break;
            }
            case R.id.mnu_del:{
                // code here
                sinhvien sv = new sinhvien();
                int kqxoa = database.deleteSV(Integer.parseInt(edtid.getText().toString()));
                if (kqxoa > 0){
                    Toast.makeText(MainActivity2.this,"xoa thanh cong",Toast.LENGTH_LONG).show();
                    listsv.clear();
                    listsv.addAll(database.getAll());
                    if (SVAdapter != null){
                        SVAdapter.notifyDataSetChanged();;
                    }
                }else{
                    Toast.makeText(MainActivity2.this,"Khong xoa dc",Toast.LENGTH_LONG).show();
                }
                break;
            }
            default:
                System.out.println(); break;
        }
        return super.onContextItemSelected(item);
    }
}