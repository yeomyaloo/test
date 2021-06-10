package com.example.practice_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/* 알트 엔터쳐주면 다나옴 */

public class MainActivity extends AppCompatActivity {


//    Button button,button3,button2;;
//    TextView textView3,textView4,textView2,textView;
//    EditText editTextTextEmailAddress,editTextNumberPassword;
//    View raw;

    private TextView sign_up;
    private TextView un_sign_in;
    private TextView logbtn;
    private TextView tv_sign_up;
    private FirebaseAuth mFirebaseAuth; //파이어베이스 인증처리
    private DatabaseReference mDatabaseRef; // 실시간 데이터베이스로 서버에 연동시킬 수 있는 객체
    private EditText mEtEmail, mEtPsw, mEtPswcheck; //회원가입 입력필드
    private Button mBtnReguster; //회원가입 버튼


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // xml파일과 연동시키는 것가지의 화면

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Stranger");
        mEtEmail =findViewById(R.id.et_email);
        mEtPsw=findViewById(R.id.et_psw);
        mEtPswcheck = findViewById(R.id.et_psw_check);

        // 회원가입을 위한 화면 전환 intent
        tv_sign_up = findViewById(R.id.tv_sign_up);
        tv_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Signup.class);

                startActivity(intent); //액티비티 이동.
            }
        });

        //비회원으로 입장할 때 사용되는 intent
        un_sign_in = findViewById(R.id.un_sign_in);
        un_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainhomeActivity.class);
//                Toast.makeText(MainActivity.this,"비회원으로 입장하였습니다.");
                startActivity(intent); //액티비티 이동.
            }
        });

        Button btn_login = findViewById(R.id.logbtn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //로그인 요청
                String strEmail = mEtEmail.getText().toString();//문자열로 변환해서 입력받은 이메일값을 가져오는 것
                String strPsw = mEtPsw.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPsw).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"로그인 되었습니다. 즐거운 시간 보내세요.",Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(MainActivity.this, MainhomeActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,"아이디/비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

//
//        logbtn = findViewById(R.id.logbtn);
//        logbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,MainhomeActivity.class);
//
//                startActivity(intent); //액티비티 이동.
//            }
//        });


    }
}