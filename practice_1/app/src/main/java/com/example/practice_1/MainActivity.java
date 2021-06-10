package com.example.practice_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/* 알트 엔터쳐주면 다나옴 */

public class MainActivity extends AppCompatActivity {


//    Button button,button3,button2;;
//    TextView textView3,textView4,textView2,textView;
//    EditText editTextTextEmailAddress,editTextNumberPassword;
//    View raw;

    private TextView sign_up;
    private TextView un_sign_in;
    private TextView logbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // xml파일과 연동시키는 것가지의 화면


        sign_up = findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Signup.class);

                startActivity(intent); //액티비티 이동.
            }
        });

        un_sign_in = findViewById(R.id.un_sign_in);
        un_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainhomeActivity.class);

                startActivity(intent); //액티비티 이동.
            }
        });
        logbtn = findViewById(R.id.logbtn);
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainhomeActivity.class);

                startActivity(intent); //액티비티 이동.
            }
        });
    }
}