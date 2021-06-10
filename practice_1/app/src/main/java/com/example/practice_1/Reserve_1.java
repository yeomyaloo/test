package com.example.practice_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Reserve_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve1);

        Button prebtn, solid_button2;
        prebtn = (Button) findViewById(R.id.prebtn);
        solid_button2 = (Button) findViewById(R.id.solid_button2);

        prebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainhomeActivity.class);
                startActivity(intent);
            }
        });

        solid_button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reserve_2.class);
                startActivity(intent);
            }
        });

    }
}