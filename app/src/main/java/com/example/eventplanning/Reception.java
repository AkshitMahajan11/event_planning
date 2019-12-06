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
public class Reception extends Fragment {

    CardView c17,c18,c19,c20;


    public Reception() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_reception, container, false);

        c17 = view.findViewById(R.id.CardView16);
        c18 = view.findViewById(R.id.CardView17);
        c19 = view.findViewById(R.id.CardView18);
        c20 = view.findViewById(R.id.CardView19);

        c17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Reception_Look1 reception_look1 = new Reception_Look1();
                Bundle b = new Bundle();
                reception_look1.setArguments(b);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Reception_Look1());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });

        c18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Reception_Look2 reception_look2 = new Reception_Look2();
              Bundle b = new Bundle();
              reception_look2.setArguments(b);

              FragmentManager fragmentManager = getFragmentManager();
              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
              fragmentTransaction.replace(R.id.home, new Reception_Look2());
              fragmentTransaction.addToBackStack("");
              fragmentTransaction.commit();
            }
        });

        c19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Reception_Look3 reception_look3 = new Reception_Look3();
                Bundle b = new Bundle();
                reception_look3.setArguments(b);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Reception_Look3());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });

        c20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Reception_Look4 reception_look4 = new Reception_Look4();
                Bundle b = new Bundle();
                reception_look4.setArguments(b);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home , new Reception_Look4());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
