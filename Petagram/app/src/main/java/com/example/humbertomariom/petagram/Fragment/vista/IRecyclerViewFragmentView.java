package com.example.humbertomariom.petagram.Fragment.vista;

import com.example.humbertomariom.petagram.Pojo.Mascota;
import com.example.humbertomariom.petagram.adapter.Mascota_Adaptador;

import java.util.ArrayList;

/**
 * Created by Humberto Mario M on 11/07/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public Mascota_Adaptador crearAdaptador(ArrayList<Mascota> listaMascotas);

    public void inicializarMascotaAdatador(Mascota_Adaptador adaptador);
}
