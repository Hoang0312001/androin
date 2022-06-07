package com.example.qlsvp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity_ADD extends AppCompatActivity {
    private EditText edtfullname,edtemail,edtsdt;
    private Button btnadd,btnexit;
    private RadioGroup radioGroup;
    private RadioButton rdnam,rdnu;
    private String gender="Nam";
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add);
        database = new Database(this);
        edtfullname = findViewById(R.id.edtname);
        edtsdt = findViewById(R.id.edtphone);
        edtemail = findViewById(R.id.edtemail);
        btnadd = findViewById(R.id.btnadd);
        radioGroup = findViewById(R.id.radioGroup);
        rdnam = findViewById(R.id.rdnam);
        rdnu = findViewById(R.id.rdnu);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                checkGender(radioGroup,i);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhvien sv = new sinhvien(edtfullname.getText().toString(),
                        edtemail.getText().toString(),edtsdt.getText().toString(),gender);
                if(sv!=null)
                    database.addSV(sv);
                Intent intent = new Intent(MainActivity_ADD.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void checkGender(RadioGroup group, int checkedId){
        int checkedRadioId = group.getCheckedRadioButtonId();
        if(checkedRadioId == R.id.rdnam)
            gender = "Nam";
        if(checkedRadioId == R.id.rdnu)
            gender = "Nu";
    }
}