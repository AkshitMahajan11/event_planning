package com.example.eventplanning;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ceremony_Look4 extends Fragment {

    ViewPager viewPager;
    CircleIndicator circleIndicator ;
    DatabaseReference reference ;
    int currentPage = 0;

    ArrayList<Details> picArray =new ArrayList<Details>();

    Spinner spinner1,spinner2,spinner3,spinner4,spinner5;
    TextView textView,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,number;
    String Lights[],Seats[],flower[],Type[];
    Button minus, add;

    CheckBox chBox,chBox1,chBox2,chBox3,chBox4,chBox5,chBox6 ;

    int number_of_guest = 50;


    public Ceremony_Look4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_ceremony__look4, container, false);

        textView = v.findViewById(R.id.textview);
        textView1 = v.findViewById(R.id.textview1);
        textView2 = v.findViewById(R.id.textView2);
        textView3 = v.findViewById(R.id.textview3);
        textView4 = v.findViewById(R.id.textview4);
        textView5 = v.findViewById(R.id.textview5);
        textView6 = v.findViewById(R.id.textview6);
        textView7 = v.findViewById(R.id.textview7);
        textView8 = v.findViewById(R.id.textview8);
        number = v.findViewById(R.id.no_);

        add = v.findViewById(R.id.add);
        minus= v.findViewById(R.id.sub);

        spinner1 =v.findViewById(R.id.spinner1);
        spinner2 = v.findViewById(R.id.spinner2);
        spinner3 = v.findViewById(R.id.spinner3);
        spinner4 = v.findViewById(R.id.spinner4);
        spinner5 = v.findViewById(R.id.spinner5);

        chBox = v.findViewById(R.id.checkbox);
        chBox1 = v.findViewById(R.id.checkbox1);
        chBox2 = v.findViewById(R.id.checkbox2);
        chBox3 = v.findViewById(R.id.checkbox3);
        chBox4 = v.findViewById(R.id.checkbox4);
        chBox5 = v.findViewById(R.id.checkbox5);
        chBox6 = v.findViewById(R.id.checkbox6);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                number_of_guest+=10;
                String no= String.valueOf(number_of_guest);
                number.setText(no);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(number_of_guest==50)
                {
                    Toast.makeText(getActivity(), "Minimum No. of guest 50", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (number_of_guest>=60)
                    {
                        number_of_guest-=10;
                        String no= String.valueOf(number_of_guest);
                        number.setText(no);
                    }
                }
            }
        });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(adapterView.getContext(), "Item Selected : "+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item =adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Lights =getResources().getStringArray(R.array.Lights);
        Seats = getResources().getStringArray(R.array.Seats);
        flower = getResources().getStringArray(R.array.Flower);
        Type= getResources().getStringArray(R.array.Type);



        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,Seats);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,flower);
        spinner2.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,Lights);
        spinner3.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,Type);
        spinner4.setAdapter(adapter4);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,Type);
        spinner5.setAdapter(adapter5);

        reference = FirebaseDatabase.getInstance().getReference("Info");
        images();

        return  v;
    }

    public  void images() {

        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Details obj = snapshot.getValue(Details.class);
                    picArray.add(obj);
                }

                viewPager = getView().findViewById(R.id.pager);
                circleIndicator = getView().findViewById(R.id.indicator);

                MyAdapter adapter = new MyAdapter(getActivity(), picArray);

                viewPager.setAdapter(adapter);

                adapter.notifyDataSetChanged();

                circleIndicator.setViewPager(viewPager);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == picArray.size()) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();

        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);
    }



}
