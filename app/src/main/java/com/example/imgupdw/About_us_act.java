package com.example.imgupdw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toolbar;
import android.os.Bundle;

public class About_us_act extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = findViewById(R.id.toolbar5);
        toolbar.setTitle("About Us");
        setActionBar(toolbar);
        String[] names = {"Kunwar Singh Bhatia", "Harsh Verma", "Farhan Ahmed", "Chirag Ajay Jain", "Smit Parmar", "Ritwik Srivastava"};
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter_abt_us ad = new adapter_abt_us(names);
        recyclerView.setAdapter(ad);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}