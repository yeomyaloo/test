package com.example.practice_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reserve_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve3);

        Button prebtn2, reserve01;
        reserve01 = (Button) findViewById(R.id.reserve01);
        prebtn2 = (Button) findViewById(R.id.prebtn2);

        reserve01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reserve_4.class);
                startActivity(intent);
            }
        });

        prebtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reserve_2.class);
                startActivity(intent);
            }
        });
    }
}