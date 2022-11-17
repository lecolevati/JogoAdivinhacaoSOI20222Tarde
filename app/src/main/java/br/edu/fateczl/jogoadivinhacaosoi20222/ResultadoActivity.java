package br.edu.fateczl.jogoadivinhacaosoi20222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setGravity(Gravity.CENTER);

        btnVoltar = findViewById(R.id.btnVoltar);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int random = bundle.getInt("random");

        tvResultado.setText(getString(R.string.resultado)+" "+random);

        btnVoltar.setOnClickListener(click -> voltar());

        Toast.makeText(this, R.string.parabens, Toast.LENGTH_LONG).show();
    }

    private void voltar() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}