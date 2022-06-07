package com.example.thucpham;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    private EditText edtname, edtdvt, edtdongia;
    private Button btnUpdate, btnExit;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new Database(this);
        edtname = findViewById(R.id.edtname);
        edtdvt = findViewById(R.id.edtdvt);
        edtdongia = findViewById(R.id.edtdongia);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnExit = findViewById(R.id.btnExit);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");

         ThucPham thucPham = database.findById(id);
        if(thucPham!=null){
            Log.e("id ne ",String.valueOf(thucPham.getId()));
            edtname.setText(thucPham.getName());
            edtdvt.setText(thucPham.getDvt());
            edtdongia.setText(thucPham.getDongia());

        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThucPham thucpham = new ThucPham(id,edtname.getText().toString(),
                        edtdvt.getText().toString(), edtdongia.getText().toString());
                if (thucpham != null) database.update(thucpham);
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
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