package com.example.eventplanning;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.provider.ContactsContract;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class Birthday_Look1 extends Fragment {

  ViewPager viewPager;
  Bundle bundle;
    CircleIndicator circleIndicator ;
    DatabaseReference reference ;
    int currentPage = 0;

    ArrayList<Details> picArray =new ArrayList<Details>();

    Spinner spinner1,spinner2,spinner3,spinner4,spinner5;
    TextView textView,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,number;
     String Lights[],Seats[],flower[],Type[];
     Button minus, add, submit;
     RadioButton RadioBtn,RadioBtn1;
     DetailsPricingFragment detailsPricingFragment;

     CheckBox chBox,chBox1,chBox2,chBox3,chBox4,chBox5,chBox6 ;

     int number_of_guest = 50;

    FirebaseDatabase database;
    DatabaseReference reference1;
    FirebaseAuth mAuth;

   String no;
   String chbx,chbx1,chbx2,chbx3,chbx4,chbx5,chbx6 ;
   String Food="";

    public Birthday_Look1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.fragment_birthday__look1, container, false);
        bundle=new Bundle();
        detailsPricingFragment=new DetailsPricingFragment();

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

        RadioBtn = v.findViewById(R.id.radio1);
        RadioBtn1 =v.findViewById(R.id.radio2);


        submit = v.findViewById(R.id.Submit);

         database =FirebaseDatabase.getInstance();
         reference1 =database.getReference("Details");

         submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {


                 if (chBox.isChecked())
                 {
                     chbx = chBox.getText().toString();
                 }
                 if (chBox1.isChecked())
                 {
                     chbx1 = chBox1.getText().toString();
                 }
                 if (chBox2.isChecked())
                 {
                     chbx2 = chBox2.getText().toString();
                 }
                 if (chBox3.isChecked())
                 {
                     chbx3 = chBox3.getText().toString();
                 }
                 if (chBox4.isChecked())
                 {
                     chbx4 = chBox4.getText().toString();
                 }
                 if (chBox5.isChecked())
                 {
                     chbx5 = chBox5.getText().toString();
                 }
                 if (chBox6.isChecked())
                 {
                     chbx6 = chBox6.getText().toString();
                 }

                 if (RadioBtn.isChecked())
                 {
                   Food =RadioBtn.getText().toString();
                 }
                 else
                 if (RadioBtn1.isChecked())
                 {
                     Food = RadioBtn1.getText().toString();
                 }

                 //sending data to nesxt fragment
                 bundle.putString("chbx",chbx);
                 bundle.putString("chbx1",chbx1);
                 bundle.putString("chbx2",chbx2);
                 bundle.putString("chbx3",chbx3);
                 bundle.putString("chbx4",chbx4);
                 bundle.putString("chbx5",chbx5);
                 bundle.putString("chbx6",chbx6);
                 bundle.putString("Food",Food);
                 //bundle.putString("food",Food);
                 detailsPricingFragment.setArguments(bundle);


                 //moving to next fragment
                 FragmentManager fragmentManager=getFragmentManager();
                 FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                 fragmentTransaction.replace(R.id.home,new DetailsPricingFragment());
                 fragmentTransaction.addToBackStack("");
                 fragmentTransaction.commit();

                /* Intent i = new Intent(Birthday_Look1.this,Custom_Adapter.class);
                 startActivity(i);*/


             }
         });




        add.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
             number_of_guest+=10;
              no= String.valueOf(number_of_guest);
              bundle.putString("add",no);
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

                    no= String.valueOf(number_of_guest);
                    bundle.putString("minus",no);
                    number.setText(no);
                }
            }
         }
     });


      spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            final   String item = adapterView.getItemAtPosition(i).toString();
              //Toast.makeText(adapterView.getContext(), "Item Selected : "+item, Toast.LENGTH_SHORT).show();
              bundle.putString("itemSitting",item);
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

      spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            final   String item = adapterView.getItemAtPosition(i).toString();
            bundle.putString("itemFlowers",item);

          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

      spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            final   String item = adapterView.getItemAtPosition(i).toString();
              bundle.putString("itemLightning",item);

          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

      spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             final String item = adapterView.getItemAtPosition(i).toString();
              bundle.putString("itemLunchType",item);
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

      spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            final   String item =adapterView.getItemAtPosition(i).toString();
              bundle.putString("itemDinnerType",item);
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
        // Inflate the layout for this fragment

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
    detailsPricingFragment.setArguments(bundle);
}

}
