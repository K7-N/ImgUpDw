package com.example.imgupdw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Emer_cmds extends AppCompatActivity {

    private Button editbtn;
    private Button recBtn;
    String s1 = MainActivity.phone_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emer_cmds);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle("Credentials");
        setActionBar(toolbar);
        TextView phNo = findViewById(R.id.textView2);
        editbtn = findViewById(R.id.button3);
//        recBtn = findViewById(R.id.button4);
        System.out.println("PHONE" + s1);
        phNo.setText(s1);

    }
    public void edt_Onclick(View view){
        Intent intent = new Intent(Emer_cmds.this, Enter_New_Ph.class);
        startActivity(intent);
    }



}