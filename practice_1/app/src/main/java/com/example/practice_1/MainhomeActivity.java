package com.example.practice_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainhomeActivity extends AppCompatActivity {

    private ImageButton ib_4;
    private ImageButton ib_2;
    private ImageButton ib_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainhome);


        //이미지 버튼 클릭시 액티비티 전환(화면전환)
        ImageButton ib_1 = (ImageButton) findViewById(R.id.ib_1);
        ib_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reserve_1.class);
                startActivity(intent);
            }
        });

        // 개인정보 이미지 버튼 개인정보로 액티비티 전환 여기서 그냥 버튼인 경우Img만 지우면 됩니다.
        ImageButton ib_5 = (ImageButton) findViewById(R.id.ib_5);
        ib_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PersonInfo.class);
                startActivity(intent);
            }
        });
        //URL 긁어와서 이미지버튼에 넣어주기
        ib_4 =(ImageButton)findViewById(R.id.ib_4);

        ib_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/d/u/0/viewer?ie=UTF8&t=h&hl=ko&msa=0&z=6&mid=1wwtrugmKQMZ6sR8yH66F2EYjn88&ll=35.768800381892866%2C128.671875"));
                startActivity(intent);
            }
        });
        ib_2 =(ImageButton)findViewById(R.id.ib_2);

        ib_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.weather.go.kr/w/index.do"));
                startActivity(intent);
            }
        });
        ib_3 =(ImageButton)findViewById(R.id.ib_3);

        ib_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.roadplus.co.kr/main/main.do"));
                startActivity(intent);
            }
        });







    }


}