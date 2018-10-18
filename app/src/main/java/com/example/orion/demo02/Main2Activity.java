package com.example.orion.demo02;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;
public class Main2Activity extends AppCompatActivity {
    RecyclerView rv;
    private SQLiteDatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db=new SQLiteDatabaseHandler(this);
        List<Contacto> lista=db.listarContactos();
        ContactoAdapter adaptador=new ContactoAdapter(lista);
        rv= findViewById(R.id.rvContactos);
        rv.setAdapter(adaptador);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Toast.makeText(getApplicationContext(),"Nuevo registro",Toast.LENGTH_LONG).show();
    }
}
