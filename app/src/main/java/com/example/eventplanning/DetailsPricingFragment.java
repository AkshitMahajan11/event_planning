package com.example.eventplanning;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsPricingFragment extends Fragment
{
    public DetailsPricingFragment()
    {
        // Required empty public constructor
    }


    TextView NumberOfguests,seating,equipments,decoration,food,lunchType,dinnerType;
    String chbx,chbx1,chbx2,chbx3,chbx4,chbx5,chbx6,FoodStrng,itemSitting,itemFlowers,itemLightning,itemLunchType,itemDinnerType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_details_pricing, container, false);
        Bundle b=getArguments();


     if(b!=null)
     {
         if(!b.getString("chbx").isEmpty()||!b.getString("chbx").equalsIgnoreCase(""))
         {

             chbx=b.getString("chbx");
         }
         if(!b.getString("chbx1").isEmpty()||!b.getString("chbx1").equalsIgnoreCase(""))
         {
             chbx1=b.getString("chbx1");
         }
         if(!b.getString("chbx2").isEmpty()||!b.getString("chbx2").equalsIgnoreCase(""))
         {
             chbx2=b.getString("chbx2");
         }
         if(!b.getString("chbx3").isEmpty()||!b.getString("chbx3").equalsIgnoreCase(""))
         {
             chbx3=b.getString("chbx3");
         }
         if(!b.getString("chbx4").isEmpty()||!b.getString("chbx4").equalsIgnoreCase(""))
         {
             chbx4=b.getString("chbx4");
         }
         if(!b.getString("chbx5").isEmpty()||!b.getString("chbx5").equalsIgnoreCase(""))
         {
             chbx5=b.getString("chbx5");
         }
         if(!b.getString("chbx6").isEmpty()||!b.getString("chbx6").equalsIgnoreCase(""))
         {
             chbx6=b.getString("chbx6");
         }
         if(!b.getString("Food").isEmpty()||!b.getString("Food").equalsIgnoreCase(""))
         {
             FoodStrng=b.getString("Food");
         }
         if(!b.getString("itemSitting").isEmpty()||!b.getString("itemSitting").equalsIgnoreCase(""))
         {
             itemSitting=b.getString("itemSitting");
         }
         if(!b.getString("itemFlowers").isEmpty()||!b.getString("itemFlowers").equalsIgnoreCase(""))
         {
             itemFlowers=b.getString("itemFlowers");

         }
         if(!b.getString("itemLightning").isEmpty()||!b.getString("itemLightning").equalsIgnoreCase(""))
         {
             itemLightning=b.getString("itemLightning");
         }
         if(!b.getString("itemLunchType").isEmpty()||!b.getString("itemLunchType").equalsIgnoreCase(""))
         {
             itemLunchType=b.getString("itemLunchType");
         }
         if(!b.getString("itemDinnerType").isEmpty()||!b.getString("itemDinnerType").equalsIgnoreCase(""))
         {
             itemDinnerType=b.getString("itemDinnerType");
         }
     }
        NumberOfguests=v.findViewById(R.id.guests1);
        seating=v.findViewById(R.id.seats);
        equipments=v.findViewById(R.id.equip);
        decoration=v.findViewById(R.id.decor);
        food=v.findViewById(R.id.food);
        lunchType=v.findViewById(R.id.lunch);
        dinnerType=v.findViewById(R.id.dinner);

        //NumberOfguests.setText(b.getString("add"));
        seating.setText(" "+itemSitting);
        equipments.setText(" "+chbx+" "+chbx1+" "+chbx2);
        decoration.setText(" "+itemLightning+" "+itemFlowers);
        food.setText(" "+chbx3+" "+chbx4+" "+chbx5+" "+chbx6);
        lunchType.setText(" "+itemLunchType);
        dinnerType.setText(" "+itemDinnerType);


        return v;
    }

}
