package com.example.datainput;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtNama,edtNim,edtTanggalLahir;
    RadioGroup rg_jeniskelamin;
    RadioButton rb_laki, rb_perempuan;
    Spinner spinnerJurusan;
    Button Simpan;
    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvw=(TextView)findViewById(R.id.textView1);
        eText=(EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ eText.getText());
            }
        });

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