package com.example.nguyensyhoang_08dcntt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    private EditText edtmamt,edtname, edtloai, edtnamsx,edthangsx,edtdongia,edtsl;
    private Button btnInsert, btnExit;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        database = new Database(this);
        edtmamt = findViewById(R.id.edtmamt);
        edtname = findViewById(R.id.edttenmt);
        edtloai = findViewById(R.id.edtloaimt);
        edtnamsx = findViewById(R.id.edtnamsx);
        edthangsx = findViewById(R.id.edthangsx);
        edtdongia = findViewById(R.id.edtdongia);
        edtsl = findViewById(R.id.edtsl);
        btnInsert = findViewById(R.id.btninsert);
        btnExit = findViewById(R.id.btnExit);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MayTinh mayTinh = new MayTinh(edtmamt.getText().toString(),edtname.getText().toString(),
                        edtloai.getText().toString(),edtnamsx.getText().toString(), edthangsx.getText().toString(),edtdongia.getText().toString(),edtsl.getText().toString());
                if(mayTinh!=null) database.insert(mayTinh);
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