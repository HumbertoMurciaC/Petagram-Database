package com.example.humbertomariom.petagram.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.humbertomariom.petagram.adapter.Mascota_Adaptador;
import com.example.humbertomariom.petagram.Pojo.Mascota;
import com.example.humbertomariom.petagram.R;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView Lista_mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.action_bar2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Lista_mascotas = (RecyclerView) findViewById(R.id.rv_Mascotas2);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        Lista_mascotas.setLayoutManager(llm);

        InicializarListaMacotas();
        InicializarMascotaAdaptador();


    }


    public void InicializarMascotaAdaptador(){
        Mascota_Adaptador adaptador = new Mascota_Adaptador(mascotas, this);
        Lista_mascotas.setAdapter(adaptador);
    }

    public void InicializarListaMacotas(){

        mascotas = new ArrayList<Mascota>();


        mascotas.add(new Mascota("Simon",R.drawable.perro2,0));
        mascotas.add(new Mascota("Lucas",R.drawable.perro4,0));
        mascotas.add(new Mascota("Ronny",R.drawable.perro5,0));
        mascotas.add(new Mascota("Tonny",R.drawable.perro1,0));
        mascotas.add(new Mascota("Matty",R.drawable.perro3,0));



    }

    // Menu Opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.MContacto:

                Intent intent = new Intent(this,ActivityContacto.class);
                startActivity(intent);

                break;

            case R.id.MAcerca:

                Intent intent2 = new Intent(this,ActivityDesarrollador.class);
                startActivity(intent2);

                break;

        }

        return super.onOptionsItemSelected(item);

    }

}
