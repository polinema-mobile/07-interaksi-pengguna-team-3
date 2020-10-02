package com.example.datainput;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Detail_Parcelable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("GET DATA WITH PARCELABLE");

        setContentView(R.layout.activity_detail__parcelable);
        TextView nama = (TextView) findViewById(R.id.outputNama);
        TextView nim = (TextView) findViewById(R.id.outputNim);
        TextView tglLahir = (TextView) findViewById(R.id.outputTglLahir);
        TextView jenisKelamin = (TextView) findViewById(R.id.outputJenisKelamin);
        TextView jurusan = (TextView) findViewById(R.id.outputJurusan);

        MyParcelable myParcelable = getIntent().getParcelableExtra("MyParcelable");

        nama.setText(myParcelable.getNama());
        nim.setText(myParcelable.getNim());
        tglLahir.setText(myParcelable.getTgllahir());
        jenisKelamin.setText(myParcelable.getJeniskelamin());
        jurusan.setText(myParcelable.getJurusan());
    }
}
