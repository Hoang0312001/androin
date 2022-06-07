package com.example.hoaqua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insert_activity extends AppCompatActivity {
    private EditText edtdvt,edtdongia,edtname,edtloai,edtnoisx;
    private Button btnInsert, btnExit;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        database = new Database(this);
        edtdvt = findViewById(R.id.edtdvt);
        edtname = findViewById(R.id.edtname);
        edtdongia = findViewById(R.id.edtgia);
        edtloai = findViewById(R.id.edtloai);
        edtnoisx = findViewById(R.id.edthangsx);
        btnExit = findViewById(R.id.btnExit);
        btnInsert = findViewById(R.id.btninsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtname.getText().toString().isEmpty() || edtloai.getText().toString().isEmpty() || edtnoisx.getText().toString().isEmpty() || edtdongia.getText().toString().isEmpty() || edtnoisx.getText().toString().isEmpty()) {
                    Toast.makeText(insert_activity.this,"Khong de trong",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    HoaQua hoaQua = new HoaQua(edtname.getText().toString(),edtloai.getText().toString(),edtdvt.getText().toString(),edtdongia.getText().toString(),edtnoisx.getText().toString());
                    if(hoaQua!=null) database.insert(hoaQua);
                    Intent intent = new Intent(insert_activity.this,MainActivity.class);
                    startActivity(intent);
                }

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