package com.example.nguyensyhoang_08dcntt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class UpdateActivity extends AppCompatActivity {
    private EditText edtmamt,edtname, edtloai, edtnamsx,edthangsx,edtdongia,edtsl;
    private Button btnUpdate, btnExit;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new Database(this);
        edtmamt = findViewById(R.id.edtmamt);
        edtname = findViewById(R.id.edttenmt);
        edtloai = findViewById(R.id.edtloaimt);
        edtnamsx = findViewById(R.id.edtnamsx);
        edthangsx = findViewById(R.id.edthangsx);
        edtdongia = findViewById(R.id.edtdongia);
        edtsl = findViewById(R.id.edtsl);
        btnUpdate = findViewById(R.id.btnupdate);
        btnExit = findViewById(R.id.btnExit);
        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("id");

        MayTinh mayTinh = database.findById(id);
        Log.e("id",mayTinh.getMamt());
        if(mayTinh!=null){
            edtname.setText(mayTinh.getTenmt());
            edtloai.setText(mayTinh.getLoaimt());
            edtnamsx.setText(mayTinh.getNamsx());
            edthangsx.setText(mayTinh.getHangsx());
            edtdongia.setText(mayTinh.getDongia());
            edtsl.setText(mayTinh.getSoluong());
        }
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        MayTinh mayTinh = new MayTinh(id,edtname.getText().toString(),
                                edtloai.getText().toString(),edtnamsx.getText().toString(), edthangsx.getText().toString(),edtdongia.getText().toString(),edtsl.getText().toString());
                    if (mayTinh != null) database.update(mayTinh);
                    Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

    }
}