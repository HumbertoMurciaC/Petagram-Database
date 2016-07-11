package com.example.humbertomariom.petagram.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.humbertomariom.petagram.Fragment.vista.Perfil_fragment;
import com.example.humbertomariom.petagram.R;
import com.example.humbertomariom.petagram.Fragment.vista.RecyclerViewFragment;
import com.example.humbertomariom.petagram.adapter.PageAdaptador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView estrella;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.MiActionBar);
        setSupportActionBar(miActionBar);

        estrella = (ImageView) findViewById(R.id.favorites);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();


        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Activity2.class);
                startActivity(intent);

            }
        });


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

    public ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments1 = new ArrayList<>();


        fragments1.add(new RecyclerViewFragment());
        fragments1.add(new Perfil_fragment());

        return fragments1;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdaptador(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.corgi_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_house_48);
    }

}
