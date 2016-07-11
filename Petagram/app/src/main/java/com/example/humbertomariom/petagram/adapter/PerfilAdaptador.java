package com.example.humbertomariom.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.humbertomariom.petagram.Pojo.Mascota;
import com.example.humbertomariom.petagram.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Humberto Mario M on 3/07/2016.
 */
public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Mascota mascota;

    public PerfilAdaptador(ArrayList<Mascota> mascotas){

        this.mascotas = mascotas;

    }

    //Inflar el layout y lo pasara al viewholder para el obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {
        mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());

        Random rand=new Random();
        int randomNum = rand.nextInt((15 - 0) + 1) + 0;

        mascotaViewHolder.tvLikes.setText(Integer.toString(randomNum));

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista

        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvLikes;


        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.Img_Perfil);
            tvLikes = (TextView) itemView.findViewById(R.id.tv_LikesPerfil);


        }

    }

}
