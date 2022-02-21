package com.example.btlt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Info extends AppCompatActivity implements View.OnClickListener{
    Button button4;
    TextView tx1, tx2, tx3, tx4, tx5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        String user = getIntent().getStringExtra("user");
        String pw = getIntent().getStringExtra("pw");
        String birth = getIntent().getStringExtra("birth");
        String gen = getIntent().getStringExtra("gen");
        String hob = getIntent().getStringExtra("hob");
        tx1 = findViewById(R.id.textView14);
        tx2 = findViewById(R.id.textView16);
        tx3 = findViewById(R.id.textView18);
        tx4 = findViewById(R.id.textView21);
        tx5 = findViewById(R.id.textView23);
        tx1.setText(user);
        tx2.setText(pw);
        tx3.setText(birth);
        tx4.setText(gen);
        tx5.setText(hob);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == button4.getId())
            this.finishAffinity();
    }
}
