package com.example.practice_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




public class PersonInfo extends AppCompatActivity {

    private TextView logout;
    private TextView tv_coupon;
    private TextView tv_mileage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);




        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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