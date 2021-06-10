package com.example.practice_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reserve_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve2);

        Button region, prebtn1;
        region = (Button) findViewById(R.id.region1);
        prebtn1 = (Button) findViewById(R.id.prebtn1);

        region.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reserve_3.class);
                startActivity(intent);
            }
        });

        prebtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reserve_1.class);
                startActivity(intent);
            }
        });
    }
}