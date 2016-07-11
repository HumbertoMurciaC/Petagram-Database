package com.example.humbertomariom.petagram.Fragment.vista;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.humbertomariom.petagram.Pojo.Mascota;
import com.example.humbertomariom.petagram.R;
import com.example.humbertomariom.petagram.adapter.PerfilAdaptador;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class Perfil_fragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView Lista_mascotas;

    public Perfil_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_fragment, container, false);

        Lista_mascotas = (RecyclerView) v.findViewById(R.id.rv_Perfil);

        CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.Img_PerfilCircle);
// Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorPrimaryDark));
        circularImageView.setBorderWidth(10);
// Add Shadow with default param
        circularImageView.addShadow();
// or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(R.color.colorPrimary);

        TextView TvNombre = (TextView) v.findViewById(R.id.nombPerfil);

        TvNombre.setText("Tonny");


        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        glm.setOrientation(GridLayoutManager.VERTICAL);

        Lista_mascotas.setLayoutManager(glm);

        InicializarListaMacotas();
        InicializarContactoAdaptador();


        return v;
    }

    public void InicializarContactoAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador (mascotas);
        Lista_mascotas.setAdapter(adaptador);
    }

    public void InicializarListaMacotas(){

        mascotas = new ArrayList<Mascota>();

        for(int i=0;i<12;i++){
            mascotas.add(new Mascota("Tonny",R.drawable.perro1,0));
        }


    }

}
