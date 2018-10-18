package com.example.orion.demo02;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();

    }
    Button btnGuardar;
    private SQLiteDatabaseHandler db;
    EditText etNombre;
    EditText etAlias;
    EditText etTelefono;
    TextView tvLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new SQLiteDatabaseHandler(this);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        etNombre=(EditText) findViewById(R.id.etNombre);
        etAlias =(EditText) findViewById(R.id.etAlias);
        etTelefono=(EditText) findViewById(R.id.etTelefono);


        btnGuardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nombre= etNombre.getText().toString();
                String alias=etAlias.getText().toString();
                String telefono=etTelefono.getText().toString();
                db.insertarContacto(new Contacto(nombre,alias,telefono));

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
