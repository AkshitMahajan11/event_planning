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
public class Wedding extends Fragment {

    CardView c9,c10,c11,c12;


    public Wedding() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wedding, container, false);

        c9 = view.findViewById(R.id.CardView8);
        c10 = view.findViewById(R.id.CardView9);
        c11 = view.findViewById(R.id.CardView10);
        c12 = view.findViewById(R.id.CardView11);

       /* toolbar = view.findViewById(R.id.customtool);

       toolbar.setTitle("Wedding");
        setSupportActionBar(toolbar);*/


        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Wedding_look1 wedding_look1 = new Wedding_look1();
                Bundle bundle = new Bundle();
                wedding_look1.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Wedding_look1());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });


        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Wedding_Look2 wedding_look2 = new Wedding_Look2();
                Bundle bundle = new Bundle();
                wedding_look2.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Wedding_Look2());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });


        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Wedding_Look3 wedding_look3 = new Wedding_Look3();
                Bundle bundle = new Bundle();
                wedding_look3.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Wedding_Look3());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });


        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Wedding_Look4 wedding_look4 = new Wedding_Look4();
                Bundle bundle = new Bundle();
                wedding_look4.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home, new Wedding_Look4());
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
