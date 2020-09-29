package com.example.datainput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("Nama");
        String nim = intent.getStringExtra("Nim");


        TextView resultNama = findViewById(R.id.resultData);
        resultNama.setText("Nama:"+nama+"\nNim: "+nim);
    }
}