package com.example.hoaqua;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtSearch;
    private Button btnSearch;
    private ListView listView;


    private Database database;
    private List<HoaQua> hoaQuaList;
    private HoaQuaAdapter hoaQuaAdapter;
    private int saveid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSearch= findViewById(R.id.edtSearch);
        btnSearch = findViewById(R.id.btnSearch);
        listView = findViewById(R.id.lvhoaqua);

        database = new Database(this);

        hoaQuaList = database.getAll();
        setAdapter();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSearch.getText().toString().equals("")){
                    hoaQuaList.clear();
                    hoaQuaList.addAll(database.getAll());
                    setAdapter();
                }
                else{
                    HoaQua hoaQua = database.findById(Integer.parseInt(edtSearch.getText().toString()));
                    if(hoaQua!=null){
                        hoaQuaList.clear();
                        hoaQuaList.addAll(Arrays.asList(hoaQua));
                        setAdapter();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Không tìm thấy", Toast.LENGTH_LONG).show();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HoaQua hoaQua = hoaQuaList.get(i);
                saveid = hoaQua.getId();
            }
        });
        registerForContextMenu(listView);
    }
    private void setAdapter(){
        if(hoaQuaAdapter==null){
            hoaQuaAdapter = new HoaQuaAdapter(this,R.layout.activity_list,hoaQuaList);
            listView.setAdapter(hoaQuaAdapter);
        }
        else{
            hoaQuaAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuInsert:
                Intent intent= new Intent(MainActivity.this, insert_activity.class);
                startActivity(intent);
                break;
            case R.id.menuExit:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==listView){
            getMenuInflater().inflate(R.menu.menu_context,menu);
        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuContextDelete:
                database.delete(saveid);
                hoaQuaList.clear();
                hoaQuaList.addAll(database.getAll());
                setAdapter();
                Toast.makeText(MainActivity.this,"Xoá thành công",Toast.LENGTH_LONG).show();
                break;
            case R.id.menuContextUpdate:
                Intent intent= new Intent(MainActivity.this, update_activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",saveid);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}