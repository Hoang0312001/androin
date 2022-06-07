package com.example.nguyensyhoang_08d4800079;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editbks,edttenchuxe,edthangxe,edttrongtai,edthtkd;
    private Button btnadd,btndel,btnupdate,btnexit;
    private ListView listView;
    String bks = "";
    private Database database;
    private List<cvantai> listvt;
    private VTAdapter vanTaiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        database =new Database(this);
        listvt = database.getAll();
        setAdapter();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cvantai vanTai = createVanTai();

                if (vanTai != null){
                    database.addCar(vanTai);
                }
                    listvt.clear();
                    listvt.addAll(database.getAll());
                    setAdapter();

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cvantai vt = listvt.get(i);
                bks = vt.getBienks();
                editbks.setText(vt.getBienks());
                edttrongtai.setText(String.valueOf(vt.getTrongtai()));
                edttenchuxe.setText(vt.getTenchuxe());
                edthtkd.setText(vt.getHdkd());
                edthangxe.setText(vt.getHangxe());
                btnadd.setEnabled(false);
                btnupdate.setEnabled(true);


            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kqxoa = database.deleteCAR(bks);

                if (kqxoa > 0){
                    Toast.makeText(MainActivity.this,"xoa thanh cong",Toast.LENGTH_LONG).show();
                    listvt.clear();
                    listvt.addAll(database.getAll());
                    if (vanTaiAdapter != null){
                        vanTaiAdapter.notifyDataSetChanged();;
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Khong xoa dc",Toast.LENGTH_LONG).show();
                }
                editbks.setEnabled(false);

            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cvantai vt = new cvantai();
                 vt.setBienks(bks);
                vt.setTenchuxe(edttenchuxe.getText().toString());
                vt.setHangxe(edthangxe.getText().toString());
                vt.setTrongtai(Integer.parseInt(String.valueOf(edttrongtai.getText())));
                vt.setHdkd(edthtkd.getText().toString());
                int kq = database.updateCAR(vt);
                if (kq > 0) {
                    listvt.clear();
                    listvt.addAll(database.getAll());
                }if (vanTaiAdapter != null){
                    vanTaiAdapter.notifyDataSetChanged();
                }

                btnadd.setEnabled(true);
                btnupdate.setEnabled(false);
                editbks.setEnabled(true);

            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void anhxa(){
        editbks = findViewById(R.id.edtbks);
        edttenchuxe = findViewById(R.id.edttenchuxe);
        edthangxe = findViewById(R.id.edthangxe);
        edttrongtai = findViewById(R.id.edttrongtai);
        edthtkd = findViewById(R.id.edthinhthuckd);

        btnadd = findViewById(R.id.btnInsert);
        btndel = findViewById(R.id.btnDelete);
        btnupdate = findViewById(R.id.btnUpdate);
        btnexit = findViewById(R.id.btnExit);
        listView = findViewById(R.id.lvvantai);
    }
    private void setAdapter() {
        if (vanTaiAdapter == null){
            vanTaiAdapter = new VTAdapter(this,R.layout.activity_main,listvt);
            listView.setAdapter(vanTaiAdapter);
        }else{
            vanTaiAdapter.notifyDataSetChanged();
        }
    }
   private cvantai createVanTai(){
        String bks = editbks.getText().toString();
        String tenChuXe = edttenchuxe.getText().toString();
        String hangXe = edthangxe.getText().toString();
        int trongTai = Integer.parseInt(edttrongtai.getText().toString());
        String htkd = edthtkd.getText().toString();
        cvantai vanTai = new cvantai(bks,tenChuXe,hangXe,trongTai,htkd);
        return vanTai;
    }

}