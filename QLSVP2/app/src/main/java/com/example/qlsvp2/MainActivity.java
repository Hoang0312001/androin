package com.example.qlsvp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private EditText edtsearch;
private Button btnsearch;
private ListView listview;

    private Database database;
    private List<sinhvien> listsv;
    private SVAdapter svAdapter;
    private int saveidsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtsearch = findViewById(R.id.edtsearch);
        btnsearch = findViewById(R.id.btnsearch);
        listview = findViewById(R.id.lvStudent);

        database = new Database(this);
        listsv = database.getAll();
        Log.e("list",String.valueOf(listsv.get(0).getId()));
        setAdapter();

     btnsearch.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(edtsearch.getText().toString().equals("")){
                 listsv.clear();
                 listsv.addAll(database.getAll());
                 setAdapter();
             }
             else{
                 sinhvien sv = database.searchById(Integer.parseInt(edtsearch.getText().toString()));
                 if(sv!=null){
                     listsv.clear();
                     listsv.addAll(Arrays.asList(sv));
                     setAdapter();
                 }
                 else
                     Toast.makeText(MainActivity.this, "Không tìm thấy", Toast.LENGTH_LONG).show();
             }

         }
     });
    }
    private void setAdapter(){
        if(svAdapter==null){
            svAdapter = new SVAdapter(this,R.layout.activity_listsv,listsv);
            listview.setAdapter(svAdapter);
        }
        else{
            svAdapter.notifyDataSetChanged();
        }
    }

//    private sinhvien createSinhVien(){
//        String name = editbks.getText().toString();
//        String tenChuXe = edttenchuxe.getText().toString();
//        String hangXe = edthangxe.getText().toString();
//        int trongTai = Integer.parseInt(edttrongtai.getText().toString());
//        String htkd = edthtkd.getText().toString();
//        VanTai vanTai = new VanTai(bks,tenChuXe,hangXe,trongTai,htkd);
//        return vanTai;
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }
    // xu ly su kien cho menu option


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_add:
                Intent intent= new Intent(MainActivity.this, MainActivity_ADD.class);
                startActivity(intent);
                break;
            case R.id.mnu_exit:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    //menu context


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==listview){
            getMenuInflater().inflate(R.menu.menu_context,menu);
        }
    }
    // xu ly su kien trong context menu

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_del:
                database.deleteSV(saveidsv);
                listsv.clear();
                listsv.addAll(database.getAll());
                setAdapter();
                Toast.makeText(MainActivity.this,"Xoá thành công",Toast.LENGTH_LONG).show();
                break;
            case R.id.mnu_upd:
                Intent intent= new Intent(MainActivity.this, updatesvActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",saveidsv);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

}