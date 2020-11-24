package com.example.creditcardform;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import	android.database.sqlite.SQLiteOpenHelper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.creditcardform.R;
import com.example.creditcardform.Tarjeta;


public class Registro extends AppCompatActivity implements View.OnClickListener {
    public static final String creartabla ="CREATE TABLE tarjeta(nombre text, apellido text, nTarjeta text, mes text, anho text, codigo text, calle text, ciudad text, estado text, cPostal text);";
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

        this.tarjeta = new Tarjeta();

        Button btRegistroConfirmar = findViewById(R.id.botonR);
        btRegistroConfirmar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonR:

                this.tarjeta.setNombre(this.etRegistroNombre.getText().toString());
                this.tarjeta.setApellido(this.etRegistroApellido.getText().toString());
                this.tarjeta.setnTarjeta(this.etRegistronTarjeta.getText().toString());
                this.tarjeta.setMes(this.etRegistroMes.getText().toString());
                this.tarjeta.setAnho(this.etRegistroAnho.getText().toString());
                this.tarjeta.setCodigo(this.etRegistroCodigo.getText().toString());
                this.tarjeta.setCalle(this.etRegistroCalle.getText().toString());
                this.tarjeta.setCiudad(this.etRegistroCiudad.getText().toString());
                this.tarjeta.setEstado(this.etRegistroEstado.getText().toString());
                this.tarjeta.setCodiP(this.etRegistrocPostal.getText().toString());



                if( !this.tarjeta.esVacio() ){
                } else {
                    if( this.etRegistronTarjeta.getText().toString().length() >= 10){
                            if( !buscar_usuario() ) {
                                if( registrar_usuario() > 0 ) {

                                    /* LIMPIAR CAMPOS  */
                                    this.etRegistroNombre.setText("");
                                    this.etRegistroApellido.setText("");
                                    this.etRegistronTarjeta.setText("");
                                    this.etRegistroMes.setText("");
                                    this.etRegistroAnho.setText("");
                                    this.etRegistroCodigo.setText("");
                                    this.etRegistroCalle.setText("");
                                    this.etRegistroCiudad.setText("");
                                    this.etRegistroEstado.setText("");
                                    this.etRegistrocPostal.setText("");

                                    Toast.makeText(this, "Registro de la tarjeta exitoso", Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(this, "Error al guardar en la Base de Datos", Toast.LENGTH_LONG).show();
                                }
                            } else{
                                Toast.makeText(this, "La tarjeta ya se encuentra registrada", Toast.LENGTH_LONG).show();
                            }
                    } else {
                        Toast.makeText(this, "La cantidad minima de caracteres son 10.", Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_LONG).show();
                }

                //Toast.makeText(this, "Boton Registro se oprimio", Toast.LENGTH_LONG).show();
                break;
        }

    }

    private long registrar_usuario(){
        Conexion base = new Conexion(this,"administracion1", null, 1);
        SQLiteDatabase baseDatos = base.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nombre", this.tarjeta.getNombre());
        registro.put("apellido", this.tarjeta.getApellido());
        registro.put("nTarjeta", this.tarjeta.getnTarjeta());
        registro.put("mes", this.tarjeta.getMes());
        registro.put("anho", this.tarjeta.getAnho());
        registro.put("codigo", this.tarjeta.getCodigo());
        registro.put("calle", this.tarjeta.getCalle());
        registro.put("ciudad", this.tarjeta.getCiudad());
        registro.put("estado", this.tarjeta.getEstado());
        registro.put("cPostal", this.tarjeta.getCodiP());

        long resultado = baseDatos.insert("tarjeta", null, registro);
        baseDatos.close();

        Log.i("PruebaRegistro", String.valueOf(resultado) );
        return resultado;
    }

    // Funcion Validar Correo ya ingresado
    private boolean buscar_usuario(){
        Conexion base = new Conexion(this,"administracion1", null, 1);
        SQLiteDatabase baseDatos = base.getWritableDatabase();

        Cursor filas = baseDatos.rawQuery(
                "SELECT COUNT(*) FROM Tarjeta WHERE nTarjeta ='"+ this.tarjeta.getnTarjeta()+"';",null
        );

        filas.moveToFirst();
        int cantidad = filas.getInt(0);
        if( cantidad > 0 ){
            return true;
        } else {
            return false;
        }
    }
}