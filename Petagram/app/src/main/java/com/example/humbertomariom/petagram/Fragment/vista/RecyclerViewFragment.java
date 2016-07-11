package com.example.humbertomariom.petagram.Fragment.vista;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.humbertomariom.petagram.Pojo.Mascota;
import com.example.humbertomariom.petagram.Presentador.IRecyclerViewFragmentPresenter;
import com.example.humbertomariom.petagram.Presentador.RecyclerViewFragmentPresenter;
import com.example.humbertomariom.petagram.R;
import com.example.humbertomariom.petagram.adapter.Mascota_Adaptador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {


    private ArrayList<Mascota> mascotas;
    private RecyclerView Lista_mascotas;
    IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        Lista_mascotas = (RecyclerView) v.findViewById(R.id.rv_Mascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        Lista_mascotas.setLayoutManager(llm);

    }

    @Override
    public Mascota_Adaptador crearAdaptador(ArrayList<Mascota> listaMascotas) {
        Mascota_Adaptador adaptador = new Mascota_Adaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarMascotaAdatador(Mascota_Adaptador adaptador) {

        Lista_mascotas.setAdapter(adaptador);
    }
}
