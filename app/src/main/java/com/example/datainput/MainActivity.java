package com.example.datainput;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    EditText edtNama,edtNim,edtTanggalLahir;
    RadioGroup rg_jeniskelamin;
    RadioButton selectedRb;
    Spinner spinnerJurusan;
    Button Simpan;
    DatePickerDialog picker;
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
        //selectedRb = (RadioButton) findViewById(R.id.rb_laki);
        //rb_perempuan = (RadioButton) findViewById(R.id.rb_perempuan);
        spinnerJurusan = (Spinner)findViewById(R.id.spinnerJurusan);
        Simpan = (Button) findViewById(R.id.Simpan);

        myParcelable = createNewMyParcelable();

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
        //Parcelable
        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowData.class);
                intent.putExtra(ShowData.EXTRA_DATA, myParcelable);
                startActivity(intent);
            }
        });
        /*
        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data
                String nama = edtNama.getText().toString();
                String nim = edtNim.getText().toString();
                String dateBirth = edtTanggalLahir.getText().toString();
                String jk;
                if (rb_laki.isSelected()) {
                    jk = "Pria";
                } else {
                    jk = "Wanita";
                }
                String jurusan = spinnerJurusan.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, ShowData.class);
                Bundle paket = new Bundle();
                intent.putExtra("Nama", nama);
                intent.putExtra("Nim", nim);
                intent.putExtra("Tanggal_Lahir", dateBirth);
                intent.putExtra("jenis_kelamin", jk);
                intent.putExtra("jurusan", jurusan);
                intent.putExtras(paket);
                startActivity(intent);
            }
        });*/

    }
    private MyParcelable createNewMyParcelable() {
        int selectedRbId = rg_jeniskelamin.getCheckedRadioButtonId();
        selectedRb = (RadioButton) findViewById(selectedRbId);
        MyParcelable myParcelableBaru = new MyParcelable();
        myParcelableBaru.setNama(edtNama.getText().toString());
        myParcelableBaru.setNim(edtNim.getText().toString());
        myParcelableBaru.setTgllahir(edtTanggalLahir.getText().toString());
        myParcelableBaru.setJenisKelamin(selectedRb.getText().toString());
        myParcelableBaru.setJurusan(spinnerJurusan.getSelectedItem().toString());
        return myParcelableBaru;
    }
}