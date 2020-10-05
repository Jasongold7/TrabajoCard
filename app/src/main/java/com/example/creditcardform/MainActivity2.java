package com.example.creditcardform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        TextView txt;

        recibirDatos();
    }
    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("Nombre");
        String apellido = extras.getString("Apellido");
        String ntarjeta = extras.getString("Tarjeta");
        String mes = extras.getString("Mes");
        String anho = extras.getString("Anho");
        dato = (TextView) findViewById(R.id.Nombre2);
        dato.setText(nombre+" "+apellido);


        dato = (TextView) findViewById(R.id.Tarjeta2);
        dato.setText(ntarjeta);

        dato = (TextView) findViewById(R.id.fecha);
        dato.setText(mes+"/"+anho);

    }
}