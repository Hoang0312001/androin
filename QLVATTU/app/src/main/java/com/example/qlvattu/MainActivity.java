package com.example.qlvattu;

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
    private EditText edtten,edtdongia,edtdonvi,edthang;
    private Button btnadd,btndel,btnupdate,btnexit;
    private ListView listView;
    int id =0;
    //csdl
    private Database database;
    private List<VatTu> listvt;
    private VatTuAdapter vatTuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        database = new Database(this);
        listvt = database.getAll();
        setAdapter();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VatTu vt = createVatTu();
            
                if (vt!=null){
                    database.addSV(vt);
                }
                listvt.clear();
                listvt.addAll(database.getAll());
                setAdapter();
            }
        });
  btnexit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          finish();
      }
  });
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            VatTu vt = listvt.get(i);
            id = vt.getId();
            edtten.setText(vt.getTenvt());
            edtdongia.setText(String.valueOf(vt.getDongia()));
            edtdonvi.setText(vt.getDonvi());
            edthang.setText(vt.getHangvt());
            btnadd.setEnabled(false);
            btnupdate.setEnabled(true);

        }
    });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int kqxoa = database.deleteSV(Integer.parseInt(String.valueOf(id)));

                if (kqxoa > 0){
                    Toast.makeText(MainActivity.this,"xoa thanh cong",Toast.LENGTH_LONG).show();
                    listvt.clear();
                    listvt.addAll(database.getAll());
                    if (vatTuAdapter != null){
                        vatTuAdapter.notifyDataSetChanged();;
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Khong xoa dc",Toast.LENGTH_LONG).show();
                }
            }

        });
    btnupdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            VatTu vt = new VatTu();
            vt.setId(Integer.parseInt(String.valueOf(id)));
            vt.setDonvi(edtdonvi.getText().toString());
            vt.setTenvt(edtten.getText().toString());
            vt.setDongia(Integer.parseInt(String.valueOf(edtdongia.getText())));
            vt.setHangvt(edthang.getText().toString());
            int kq = database.updateSV(vt);
            if (kq > 0) {
                listvt.clear();
                listvt.addAll(database.getAll());
            }if (vatTuAdapter != null){
                vatTuAdapter.notifyDataSetChanged();
            }
            btnadd.setEnabled(true);
            btnupdate.setEnabled(false);

   }

    });

    }

    private void anhxa(){
        edtten = findViewById(R.id.edttenvattu);
        edtdongia = findViewById(R.id.edtdongia);
        edtdonvi = findViewById(R.id.edtdonvi);
        edthang = findViewById(R.id.edthangsx);

        btnadd = findViewById(R.id.btnInsert);
        btndel = findViewById(R.id.btnDelete);
        btnupdate = findViewById(R.id.btnUpdate);
        btnexit = findViewById(R.id.btnExit);
        listView = findViewById(R.id.lvVatTu);

    }
    private void setAdapter() {
        if (vatTuAdapter == null){
            vatTuAdapter = new VatTuAdapter(this,R.layout.activity_main,listvt);
            listView.setAdapter(vatTuAdapter);
        }else{
            vatTuAdapter.notifyDataSetChanged();
        }
    }
    private VatTu createVatTu(){
        String name = edtten.getText().toString();
        int dongia = Integer.parseInt(edtdongia.getText().toString());
        String  donvi = edtdonvi.getText().toString();
        String  hangsx = edthang.getText().toString();
        VatTu vatTu = new VatTu(dongia,name,hangsx,donvi);
         return vatTu;
    }

    }

