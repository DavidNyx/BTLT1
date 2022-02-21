package com.example.btlt1;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3;
    EditText ed1, ed2, ed3, ed4;
    RadioButton r1, r2;
    CheckBox c1, c2, c3;
    DatePickerDialog datePickerDialog;
    Calendar cal = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById((R.id.button3));
        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPassword);
        ed3 = findViewById(R.id.editTextTextPassword2);
        ed4 = findViewById(R.id.editTextDate);
        r1 = findViewById(R.id.radioButton12);
        r2 = findViewById(R.id.radioButton13);
        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        DatePickerDialog.OnDateSetListener dateSetListener  = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                ed4.setText(date);
            }
        };
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == b1.getId())
            datePickerDialog.show();
        if(v.getId() == b2.getId())
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        if(v.getId() == b3.getId()) {
            if(ed2.getText().toString().equals(ed3.getText().toString())) {
                Intent intentMainInfo = new Intent(MainActivity.this, Info.class);
                intentMainInfo.putExtra("user", ed1.getText().toString());
                intentMainInfo.putExtra("pw", ed2.getText().toString());
                intentMainInfo.putExtra("birth", ed4.getText().toString());
                if(r1.isChecked())
                    intentMainInfo.putExtra("gen", "Male");
                if(r2.isChecked())
                    intentMainInfo.putExtra("gen", "Female");
                String hob = "";
                if(c1.isChecked())
                    hob += "Tennis";
                if(c2.isChecked()){
                    if(hob.equals(""))
                        hob += "Futbal";
                    else
                        hob += ", Futbal";
                }
                if(c3.isChecked()){
                    if(hob.equals(""))
                        hob += "Others";
                    else
                        hob += ", Others";
                }
                intentMainInfo.putExtra("hob", hob);
                startActivity((intentMainInfo));
            }
        }
    }

    private String makeDateString(int day, int month, int year){
        return day + "/" + month + "/" + year;
    }
}