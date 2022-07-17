package com.example.ejemplotabsviewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout; //referencio los componentes graficos
    ViewPager2 viewPager2;
    MyFragmentAdapter adapter; //referencio la clase que va a hacer de adaptador.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablayout = findViewById(R.id.tablayout); //inicializo los componentes graficos
        viewPager2 = findViewById(R.id.viewpager2);

        //creo un FragmentManager para gestionar los fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new MyFragmentAdapter(fragmentManager,getLifecycle()); //inicializo el adapter pasandole los dos parametros requeridos
        viewPager2.setAdapter(adapter); //le paso el adaptador al viewpager2

        //añado las pestañas que necesite
        tablayout.addTab(tablayout.newTab().setText("Fragmento 1"));
        tablayout.addTab(tablayout.newTab().setText("Fragmento 2"));

        //hago que los tabs sean clicables
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition()); //obtengo la posicion del tab que he clicado
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
               tablayout.selectTab(tablayout.getTabAt(position));
            }
        });
    }
}