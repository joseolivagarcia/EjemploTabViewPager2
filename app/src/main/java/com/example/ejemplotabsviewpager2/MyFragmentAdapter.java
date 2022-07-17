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
        switch (position){ //recuerda que la position empieza en 0
            case 0:
                return  new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return new Fragment4();
        }
        return new Fragment1(); //retorno el fragment 1 por si fallaran los tabs

    }

    @Override
    public int getItemCount() {
        return 4; //indicamos el numero de fragments que tenemos
    }
}
