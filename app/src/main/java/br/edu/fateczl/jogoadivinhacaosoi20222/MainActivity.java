package br.edu.fateczl.jogoadivinhacaosoi20222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDica;
    private EditText etNumero;
    private Button btnJogar;
    private int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDica = findViewById(R.id.tvDica);
        tvDica.setGravity(Gravity.CENTER);

        etNumero = findViewById(R.id.etNumero);
        etNumero.setGravity(Gravity.CENTER);

        btnJogar = findViewById(R.id.btnJogar);

        random = (int)((Math.random() * 100) + 1);

        btnJogar.setOnClickListener(click -> jogar());
    }

    private void jogar() {
        int numero = Integer.parseInt(etNumero.getText().toString());
        if (numero > random) {
            tvDica.setText(R.string.menor);
        } else if (numero < random) {
            tvDica.setText(R.string.maior);
        } else {
            acertou();
        }
    }

    private void acertou() {
        Bundle bundle = new Bundle();
        bundle.putInt("random", random);

        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtras(bundle);
        this.startActivity(intent);
        this.finish();
    }
}