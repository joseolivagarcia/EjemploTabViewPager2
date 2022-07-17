package com.example.ejemplotabsviewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdapter extends FragmentStateAdapter {

    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //aqui cargamos los fragment dependiendo de en que posicion se encuentre (posicion del tab)
        if(position == 1){
            return new Fragment2(); //si la posicion es la 1(seria el 2 al empezar a contar desde 0) carga el frgment 2
        }
        return new Fragment1(); //si no, carga el 1 ya que no hay otra opción
    }

    @Override
    public int getItemCount() {
        return 2; //indicamos el numero de fragments que tenemos
    }
}
