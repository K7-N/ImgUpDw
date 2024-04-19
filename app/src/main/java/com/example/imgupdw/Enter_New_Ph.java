package com.example.imgupdw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Enter_New_Ph extends AppCompatActivity {
    private EditText edt_text;
    private Button subBtn;
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference("Contact");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_new_ph);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        toolbar.setTitle("Update Emergency number");
        setActionBar(toolbar);
        edt_text = findViewById(R.id.editTextPhone);
        subBtn = findViewById(R.id.button5);

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2 = edt_text.getText().toString();
                System.out.println(s2);
                try {
                    double i = Double.parseDouble(s2);
                } catch (Exception e){
                    makeToast("Enter a Valid Phone");
                    return;
                }
                if(s2.length() != 10){
                    makeToast("Enter a Valid Phone No");
                    return;
                }
                System.out.println(s2);
                db.child("Default").setValue(s2).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        makeToast("Phone Number Updated");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        makeToast("Failed");
                    }
                });

                Intent intent = new Intent(Enter_New_Ph.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void makeToast(String txt){
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }

}