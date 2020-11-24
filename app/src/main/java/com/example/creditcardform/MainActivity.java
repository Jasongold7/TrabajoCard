package com.example.creditcardform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bActividad;
    private Button bRegistrar;
    private EditText texto;
    private Button bBuscar;

    private EditText etRegistroNombre;
    private EditText etRegistroApellido;
    private EditText etRegistronTarjeta;
    private EditText etRegistroMes;
    private EditText etRegistroAnho;
    private EditText etRegistroCodigo;
    private EditText etRegistroCalle;
    private EditText etRegistroCiudad;
    private EditText etRegistroEstado;
    private EditText etRegistrocPostal;

    private Tarjeta tarjeta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bRegistrar =  (Button) findViewById(R.id.botonR);
        bActividad = (Button) findViewById(R.id.botonG);
        bBuscar = (Button) findViewById(R.id.botonB);

        this.etRegistroNombre = findViewById(R.id.Nombre);
        this.etRegistroApellido = findViewById(R.id.Apellido);
        this.etRegistronTarjeta = findViewById(R.id.TarjetaN);
        this.etRegistroMes = findViewById(R.id.Mes);
        this.etRegistroAnho = findViewById(R.id.Anho);
        this.etRegistroCodigo = findViewById(R.id.Codigo);
        this.etRegistroCalle = findViewById(R.id.Calle);
        this.etRegistroCiudad = findViewById(R.id.Ciudad);
        this.etRegistroEstado = findViewById(R.id.Estado);
        this.etRegistrocPostal = findViewById(R.id.CodiP);


        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.botonR:
                        Intent registroIntent = new Intent(MainActivity.this, Registro.class);
                        startActivity(registroIntent);
                        // Toast.makeText(this, "Se oprimio", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonR:
                Intent registroIntent = new Intent(MainActivity.this, Registro.class);
                startActivity(registroIntent);
                // Toast.makeText(this, "Se oprimio", Toast.LENGTH_LONG).show();
                break;
        }
    }
}