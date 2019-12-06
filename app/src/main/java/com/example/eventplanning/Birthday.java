package com.example.eventplanning;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Birthday extends Fragment {

    CardView c5,c6,c7,c8;

    public Birthday()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_birthday,container,false);

        c5= view.findViewById(R.id.CardView4);
        c6= view.findViewById(R.id.CardView5);
        c7 = view.findViewById(R.id.CardView6);
        c8 = view.findViewById(R.id.CardView7);


        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Birthday_Look1 birthday_look1 = new Birthday_Look1();

            Bundle bundle =new Bundle();
            birthday_look1.setArguments(bundle);

                FragmentManager fragmentManager =getFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                 fragmentTransaction.replace(R.id.home,new Birthday_Look1());
                 fragmentTransaction.addToBackStack("");
                 fragmentTransaction.commit();


            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Birthday_Look2 birthday_look2 = new Birthday_Look2();
                Bundle bundle = new Bundle();
                birthday_look2.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Birthday_Look2());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();


            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Birthday_Look3 birthday_look3 = new Birthday_Look3();
                Bundle bundle = new Bundle();
                birthday_look3.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Birthday_Look3());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();


            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Birthday_Look4 birthday_look4 = new Birthday_Look4();
                Bundle bundle = new Bundle();
                birthday_look4.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Birthday_Look4());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
