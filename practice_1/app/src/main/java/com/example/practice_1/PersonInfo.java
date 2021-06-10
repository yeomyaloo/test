package com.example.practice_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class PersonInfo extends AppCompatActivity {

    private Button logout;
    private TextView tv_coupon;
    private TextView tv_mileage;
    private FirebaseAuth mfirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);

        mfirebaseAuth = FirebaseAuth.getInstance();

        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그아웃하기
                mfirebaseAuth.signOut();
                Toast.makeText(PersonInfo.this,"로그아웃 되었습니다. 감사합니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PersonInfo.this,MainActivity.class);
                startActivity(intent); //액티비티 이동.
            }
        });

        tv_coupon = findViewById(R.id.tv_coupon);
        tv_coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonInfo.this,coupon.class);

                startActivity(intent); //액티비티 이동.
            }
        });

        tv_mileage = findViewById(R.id.tv_mileage);
        tv_mileage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonInfo.this,Mileage.class);

                startActivity(intent); //액티비티 이동.
            }
        });
    }
}