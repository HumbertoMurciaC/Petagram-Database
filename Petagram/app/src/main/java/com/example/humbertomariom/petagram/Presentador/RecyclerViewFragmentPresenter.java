package com.example.humbertomariom.petagram.Presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.humbertomariom.petagram.Fragment.vista.IRecyclerViewFragmentView;
import com.example.humbertomariom.petagram.Pojo.Mascota;
import com.example.humbertomariom.petagram.adapter.Mascota_Adaptador;
import com.example.humbertomariom.petagram.dp.ConstructorMascotas;


import java.util.ArrayList;

/**
 * Created by Humberto Mario M on 11/07/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {

        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        //ObtenerContactosDB();


    }


    @Override
    public void ObtenerContactosDB() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        MostrarContactosRV();

    }

    @Override
    public void MostrarContactosRV(){

        iRecyclerViewFragmentView.inicializarMascotaAdatador(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
