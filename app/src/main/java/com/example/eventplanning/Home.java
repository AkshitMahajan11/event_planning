package com.example.eventplanning;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class Home extends AppCompatActivity {

    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



       Bundle bundle=getIntent().getExtras();
       int card1=bundle.getInt("card");
       int card2=bundle.getInt("card2");
       int card3= bundle.getInt("card3");
       int card4 = bundle.getInt("card4");


       if (card1==1)
       {
           /*toolbar.setTitle("Birthday");
           setSupportActionBar(toolbar);*/

           FragmentManager fragmentManager= getSupportFragmentManager();
           FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
           fragmentTransaction.replace(R.id.home,new Birthday());
           fragmentTransaction.commit();
       }
        if (card2==2)
        {
           /* toolbar.setTitle("Wedding");
            setSupportActionBar(toolbar);*/
            FragmentManager fragmentManager= getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home,new Wedding());
            fragmentTransaction.commit();
        }

         if (card3==3)
         {
             /*toolbar.setTitle("Ring Ceremony");
             setSupportActionBar(toolbar);*/
             FragmentManager fragmentManager = getSupportFragmentManager();
             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             fragmentTransaction.replace(R.id.home,new Ring_Ceremony());
             fragmentTransaction.commit();
         }

         if (card4==4)
         {
            /* toolbar.setTitle("Reception");
             setSupportActionBar(toolbar);*/
             FragmentManager fragmentManager = getSupportFragmentManager();
             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             fragmentTransaction.replace(R.id.home,new Reception());
             fragmentTransaction.commit();

         }

    }
}
