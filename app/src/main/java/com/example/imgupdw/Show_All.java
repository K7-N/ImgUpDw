package com.example.imgupdw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Show_All extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<String> lis;
    private  My_Adapyer adapter;
    private DatabaseReference mdb = FirebaseDatabase.getInstance().getReference("Image/images/userid");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("Images");
        setActionBar(toolbar);

        rv = findViewById(R.id.img_list_view);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        lis = new ArrayList<>();
        adapter = new My_Adapyer(lis,this);
        rv.setAdapter(adapter);
        mdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    lis.add(String.valueOf(snapshot1.getValue()));
                }
                Collections.sort(lis);
                Collections.reverse(lis);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}