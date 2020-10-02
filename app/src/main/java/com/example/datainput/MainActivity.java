package com.example.datainput;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    EditText edtNama,edtNim,edtTanggalLahir;
    RadioGroup rg_jeniskelamin;
    Spinner spinnerJurusan;
    Button Simpan,SimpanParcel;
    DatePickerDialog picker;
    RadioButton rdBtn;
    MyParcelable myParcelable;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNama = (EditText)findViewById(R.id.edtNama);
        edtNim = (EditText)findViewById(R.id.edtNim);
        edtTanggalLahir = (EditText)findViewById(R.id.edtTanggalLahir);
        rg_jeniskelamin = (RadioGroup)findViewById(R.id.rg_jeniskelamin);
        spinnerJurusan = (Spinner)findViewById(R.id.spinnerJurusan);
        Simpan = (Button) findViewById(R.id.Simpan);
        SimpanParcel = (Button) findViewById(R.id.SimpanParcel);

        List<String> ListJurusan = new ArrayList<String>();
        ListJurusan.add("AKUNTANSI");
        ListJurusan.add("TEKNIK INFORMATIKA");
        ListJurusan.add("TEKNIK KIMIA");
        ListJurusan.add("TEKNIK ELEKTRO");
        ListJurusan.add("ADMINISTRASI NIAGA");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ListJurusan);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJurusan.setAdapter(adapter);

        edtTanggalLahir=(EditText) findViewById(R.id.edtTanggalLahir);
        edtTanggalLahir.setInputType(InputType.TYPE_NULL);
        edtTanggalLahir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edtTanggalLahir.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data
                String nama = edtNama.getText().toString();
                String nim = edtNim.getText().toString();
                String dateBirth = edtTanggalLahir.getText().toString();
                String jurusan = spinnerJurusan.getSelectedItem().toString();
                int radiogrp = rg_jeniskelamin.getCheckedRadioButtonId();
                rdBtn = (RadioButton)findViewById(radiogrp);
                String gender = rdBtn.getText().toString();

                Intent intent = new Intent(MainActivity.this, ShowData.class);
                Bundle paket = new Bundle();

                intent.putExtra("Nama", nama);
                intent.putExtra("Nim", nim);
                intent.putExtra("Tanggal_Lahir", dateBirth);
                intent.putExtra("jenis_kelamin", gender);
                intent.putExtra("jurusan", jurusan);
                intent.putExtras(paket);
                startActivity(intent);
            }
        });

        SimpanParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radiogrp = rg_jeniskelamin.getCheckedRadioButtonId();
                rdBtn = (RadioButton)findViewById(radiogrp);

                MyParcelable myParcelable = new MyParcelable(edtNama.getText().toString(),edtNim.getText().toString(),edtTanggalLahir.getText().toString(),rdBtn.getText().toString(),spinnerJurusan.getSelectedItem().toString());

                Intent intent = new Intent(MainActivity.this, Detail_Parcelable.class);
                intent.putExtra("MyParcelable", myParcelable);
                startActivity(intent);
            }
        });
    }
}