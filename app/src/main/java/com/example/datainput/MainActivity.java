package com.example.datainput;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtNama,edtNim,edtTanggalLahir;
    RadioGroup rg_jeniskelamin;
    RadioButton rb_laki, rb_perempuan;
    Spinner spinnerJurusan;
    Button Simpan;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNama = (EditText)findViewById(R.id.edtNama);
        edtNim = (EditText)findViewById(R.id.edtNim);
        edtTanggalLahir = (EditText)findViewById(R.id.edtTanggalLahir);
        rg_jeniskelamin = (RadioGroup)findViewById(R.id.rg_jeniskelamin);
        rb_laki = (RadioButton) findViewById(R.id.rb_laki);
        rb_perempuan = (RadioButton) findViewById(R.id.rb_perempuan);
        spinnerJurusan = (Spinner)findViewById(R.id.spinnerJurusan);
        Simpan = (Button) findViewById(R.id.Simpan);

        List<String> ListJurusan = new ArrayList<String>();
        ListJurusan.add("AKUNTANSI");
        ListJurusan.add("TEKNIK INFORMATIKA");
        ListJurusan.add("TEKNIK KIMIA");
        ListJurusan.add("TEKNIK ELEKTRO");
        ListJurusan.add("ADMINISTRASI NIAGA");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ListJurusan);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJurusan.setAdapter(adapter);
    }
}