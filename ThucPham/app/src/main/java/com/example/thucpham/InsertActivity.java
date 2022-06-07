package com.example.thucpham;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {

    private EditText edtdvt,edtdongia,edtname;
    private Button btnInsert, btnExit;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        database = new Database(this);
        edtdvt = findViewById(R.id.edtdvt);
        edtname = findViewById(R.id.edtname);
        edtdongia = findViewById(R.id.edtdongia);
        btnExit = findViewById(R.id.btnexit);
        btnInsert = findViewById(R.id.btnadd);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThucPham thucPham = new ThucPham(edtname.getText().toString(),edtdvt.getText().toString(),
                        edtdongia.getText().toString());
                if(thucPham!=null) database.insert(thucPham);
                Intent intent = new Intent(InsertActivity.this,MainActivity.class);
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