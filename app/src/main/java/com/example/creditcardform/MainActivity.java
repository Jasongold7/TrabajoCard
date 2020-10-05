package com.example.creditcardform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button bActividad;
    private EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bActividad = (Button) findViewById(R.id.botonG);

        bActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                texto = (EditText) findViewById(R.id.Nombre);
                intent.putExtra("Nombre",texto.getText().toString());
                texto = (EditText) findViewById(R.id.Apellido);
                intent.putExtra("Apellido",texto.getText().toString());
                texto = (EditText) findViewById(R.id.TarjetaN);
                intent.putExtra("Tarjeta",texto.getText().toString());
                texto = (EditText) findViewById(R.id.Mes);
                intent.putExtra("Mes",texto.getText().toString());
                texto = (EditText) findViewById(R.id.Anho);
                intent.putExtra("Anho",texto.getText().toString());
                startActivity(intent);
            }
        });
    }
}