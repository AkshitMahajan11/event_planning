package com.example.eventplanning;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ring_Ceremony extends Fragment {

    CardView c13,c14,c15,c16;


    public Ring_Ceremony() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

                View view = inflater.inflate(R.layout.fragment_ring__ceremony, container, false);

        c13 = view.findViewById(R.id.CardView12);
        c14 = view.findViewById(R.id.CardView13);
        c15 = view.findViewById(R.id.CardView14);
        c16 = view.findViewById(R.id.CardView15);

        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Ceremony_Look1 ceremony_look1 = new Ceremony_Look1();
                Bundle bundle = new Bundle();
                ceremony_look1.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Ceremony_Look1());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });


        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Ceremony_Look2 ceremony_look2 = new Ceremony_Look2();
                Bundle bundle = new Bundle();
                ceremony_look2.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Ceremony_Look2());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });


        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Ceremony_Look3 ceremony_look3 = new Ceremony_Look3();
                Bundle bundle = new Bundle();
                ceremony_look3.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Ceremony_Look3());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });


        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Ceremony_Look4 ceremony_look4 =new Ceremony_Look4();
                Bundle bundle = new Bundle();
                ceremony_look4.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Ceremony_Look4());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });



        return view;
    }

}
