package com.example.practice_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reserve_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve4);

        Button prebtn01, reserve;
        reserve = (Button) findViewById(R.id.reserve);
        prebtn01 = (Button) findViewById(R.id.prebtn01);

        reserve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reserve_5.class);
                startActivity(intent);
            }
        });

        prebtn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reserve_3.class);
                startActivity(intent);
            }
        });
    }
}