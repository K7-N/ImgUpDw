package com.example.imgupdw;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    private Button button;
    public static String phone_no;
    private ImageView button2;
    private ImageView emer, abtus;
    private ImageView iv;
    private TextView t1, t2,t3;
    Uri img;
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference("Image");
    private DatabaseReference db1 = FirebaseDatabase.getInstance().getReference("Contact");
    private StorageReference sr = FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        button2 = findViewById(R.id.images_button);
        emer = findViewById(R.id.Cred_button);
        abtus = findViewById(R.id.AboutUs_Button);
        t1 = findViewById(R.id.textView11);
        t3 = findViewById(R.id.textView4);
        t2 = findViewById(R.id.textView7);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Show_All.class);
                startActivity(intent);
            }
        });
        emer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Emer_cmds.class);
                startActivity(intent);
            }
        });
        abtus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About_us_act.class);
                startActivity(intent);
            }
        });
        loadPh();
    }

    private String getFileExtension(Uri uri2){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri2));
    }
    public void makeToast(String txt){
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }
    public void loadPh(){
        db1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot snapshot1 = snapshot.child("Default");
                DataSnapshot snapshot2 = snapshot.child("CNum");
                DataSnapshot snapshot3 = snapshot.child("Time");
                String s1 = String.valueOf(snapshot1.getValue());
                String s2 = String.valueOf(snapshot2.getValue());
                String s3 = String.valueOf(snapshot3.getValue());
                System.out.println(snapshot);
//                System.out.println(s1);
                phone_no = s1;
                t1.setText(s1);
                t3.setText(s3);
                if(s1.equals(s2)){
                    t2.setText("Synced");
                } else{
                    t2.setText("Connect Stick to Internet to Sync");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}