package com.example.eventplanning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity
{
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        user= FirebaseAuth.getInstance().getCurrentUser();
        // hide  status bar
        View v= getWindow().getDecorView();
        int ui=v.SYSTEM_UI_FLAG_FULLSCREEN;
        v.setSystemUiVisibility(ui);




        //hide action bar
        getSupportActionBar().hide();
        if(user!= null)
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
            },3000);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    finish();
                }
            },3000);
        }

    }
}
