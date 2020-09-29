package android.example.datainput;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datainput.R;

public class ResultActivity extends AppCompatActivity {
    TextView OutputNama, OutputJenisKelamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        OutputNama = (TextView) findViewById(R.id.outputNama);
        OutputJenisKelamin = (TextView) findViewById(R.id.outputJenisKelamin);

        /* Mengambil paket Intent */
        Intent tampilkanIntent = getIntent();
        Bundle bukaPaket = tampilkanIntent.getExtras();

        /* Membuka dan Mengambil data dari Intent untuk memasukannya
kedalam variabel */
        String nama = bukaPaket.getString("nama");
        String jk = bukaPaket.getString("jenkel");

        /* Mengisi TextView dengan data yang telah di ambil dari intent */
        OutputNama.setText(nama);
        OutputJenisKelamin.setText(jk);
    }
}
