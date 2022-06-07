package com.example.hoaqua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class update_activity extends AppCompatActivity {
    private EditText edtdvt,edtdongia,edtname,edtloai,edtnoisx;
    private Button btnupdate, btnExit;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new Database(this);
        edtdvt = findViewById(R.id.edtdvtu);
        edtname = findViewById(R.id.edtnameu);
        edtdongia = findViewById(R.id.edtgiau);
        edtloai = findViewById(R.id.edtloaiu);
        edtnoisx = findViewById(R.id.edthangsxu);
        btnExit = findViewById(R.id.btnExitu);
        btnupdate = findViewById(R.id.btnupdateu);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        HoaQua hoaQua = database.findById(id);
        if(hoaQua!=null){
//            Log.e("id ne ",String.valueOf(thucPham.getId()));
            edtname.setText(hoaQua.getTen());
            edtdvt.setText(hoaQua.getDvt());
            edtdongia.setText(hoaQua.getDongia());
            edtloai.setText(hoaQua.getLoai());
            edtnoisx.setText(hoaQua.getNoisx());

        }
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int id, String ten, String loai, String dvt, String dongia, String noisx
                 HoaQua hoaQua1 = new HoaQua(id,edtname.getText().toString(),edtloai.getText().toString(),edtdvt.getText().toString(),edtdongia.getText().toString(),edtnoisx.getText().toString());
                if (hoaQua1 != null) database.update(hoaQua1);
                Intent intent = new Intent(update_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}