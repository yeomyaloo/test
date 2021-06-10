package com.example.practice_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Board_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board1);

        Button home02, write01, detail01;
        home02 = (Button) findViewById(R.id.home02);
        write01 = (Button) findViewById(R.id.write01);
        detail01 = (Button) findViewById(R.id.detail01);

        home02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainhomeActivity.class);
                startActivity(intent);
            }
        });

        write01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Board_2.class);
                startActivity(intent);
            }
        });

        detail01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Detail_1.class);
                startActivity(intent);
            }
        });
    }
}