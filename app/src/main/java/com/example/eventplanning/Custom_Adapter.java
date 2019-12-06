package com.example.eventplanning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Custom_Adapter extends AppCompatActivity {

    ListView ls;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    FirebaseDatabase database;
    DatabaseReference reference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__adapter);

        ls= (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        ls.setAdapter(arrayAdapter);

        database =FirebaseDatabase.getInstance();
        reference1 =database.getReference("Details");

        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                arrayList.add("");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
