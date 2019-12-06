package com.example.eventplanning;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity
{
    EditText number;
    Button sendOTP;
    String codeSent;
    Context context;
    FirebaseAuth mAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        number=findViewById(R.id.editText);
        sendOTP=findViewById(R.id.button);
        //hide action bar
        getSupportActionBar().hide();

        context = getApplicationContext();
        mAuth= FirebaseAuth.getInstance();


        sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                String phone= number.getText().toString();
                if(phone.isEmpty())
                {
                    number.setError("Enter Phone Number");
                }

                sendVerificationCode(phone);
                final Dialog dialog= new Dialog(LoginActivity.this);
                dialog.setContentView(R.layout.dialog_layout);
                dialog.setCancelable(false);
                final EditText otp= dialog.findViewById(R.id.editText2);
                Button verifyOTP= dialog.findViewById(R.id.button2);
                verifyOTP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        String otpNumber= otp.getText().toString();
                        verifySignCode(otpNumber);
                        dialog.dismiss();

                    }
                });
                dialog.show();

            }
        });
    }

    public String sendVerificationCode(String mobile)
    {
        String phoneNumber= "91"+mobile;
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber,60, TimeUnit.SECONDS,this,mCallBack);
        return codeSent;
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken)
        {
            super.onCodeSent(s, forceResendingToken);
            codeSent=s;
        }
    };
    public void verify(PhoneAuthCredential credential)
    {
        mAuth.signInWithCredential(credential).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "Verify Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }
                        else
                        {
                            if(task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                            {
                                Toast.makeText(context, "Enter Valid OTP", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });


    }
    public void verifySignCode(String otp)
    {
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(codeSent,otp);
        verify(credential);
    }



}
