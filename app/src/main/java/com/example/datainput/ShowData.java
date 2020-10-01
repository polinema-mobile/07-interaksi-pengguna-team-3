package com.example.datainput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {
    public static final String EXTRA_DATA = "extra_data";
    TextView OutputNama, OutputJenisKelamin, OutputNim, OutputTglLahir, OutputJurusan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        OutputNama = (TextView) findViewById(R.id.outputNama);
        OutputNim = (TextView) findViewById(R.id.outputNim);
        OutputTglLahir = (TextView) findViewById(R.id.outputTglLahir);
        OutputJenisKelamin = (TextView) findViewById(R.id.outputJenisKelamin);
        OutputJurusan = (TextView) findViewById(R.id.outputJurusan);

        Intent intent = getIntent();
        Bundle bukaPaket = intent.getExtras();
        String nama = bukaPaket.getString("Nama");
        String nim = bukaPaket.getString("Nim");
        String dateBirth = bukaPaket.getString("Tanggal_Lahir");
        String jk = bukaPaket.getString("jenis_kelamin");
        String jurusan = bukaPaket.getString("jurusan");

        OutputNama.setText(nama);
        OutputNim.setText(nim);
        OutputTglLahir.setText(dateBirth);
        OutputJenisKelamin.setText(jk);
        OutputJurusan.setText(jurusan);

    }
}