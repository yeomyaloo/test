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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private TextView sign_up;
    private FirebaseAuth mFirebaseAuth; //파이어베이스 인증처리
    private DatabaseReference mDatabaseRef; // 실시간 데이터베이스로 서버에 연동시킬 수 있는 객체
    private EditText mEtEmail, mEtPsw, mEtPswcheck; //회원가입 입력필드
    private Button mBtnReguster; //회원가입 버튼


    private EditText et_email, et_psw, et_psw_check;

    public Signup() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);




        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Stranger");

        mEtEmail =findViewById(R.id.et_email);
        mEtPsw=findViewById(R.id.et_psw);
        mBtnReguster = findViewById(R.id.tv_sign_up);
        mEtPswcheck = findViewById(R.id.et_psw_check);

//        //비밀번호 일치 검사
//        et_psw_check.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String password = et_psw.getText().toString();
//                String confirm = et_psw_check.getText().toString();
//
//                if (password.equals(confirm)) {
//                    et_psw.setBackgroundColor(Color.GREEN);
//                    et_psw_check.setBackgroundColor(Color.GREEN);
//                }else {
//                    et_psw.setBackgroundColor(Color.RED);
//                    et_psw_check.setBackgroundColor(Color.RED);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


        mBtnReguster.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

        //회원가입 처리 시작
                String strEmail = mEtEmail.getText().toString();//문자열로 변환해서 입력받은 이메일값을 가져오는 것
                String strPsw = mEtPsw.getText().toString();


                //firebase auth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPsw).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //회원가입이 성공했을 때
                        if(task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid()); //고유값.
                            account.setEmailId(firebaseUser.getEmail()); //유저이메일을 정확하게 가져 오는 것이 중요하기 때문에 파이어베이스 유저라는 객처로 가져옴
                            account.setPassword(strPsw);


                            //setValue : database에 insert(삽입) 행위
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(Signup.this, "회원가입이 되었습니다.", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Signup.this,MainhomeActivity.class);
                            startActivity(intent); //액티비티 이동.

                        }

                        else {

                            Toast.makeText(Signup.this, "회원가입에 실패하였습니다..", Toast.LENGTH_SHORT).show();
                        }
                    }

                });


            }
        });
    }
}

//       sign_up = findViewById(R.id.sign_up);
//        sign_up.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Signup.this,MainhomeActivity.class);
//
//                    startActivity(intent); //액티비티 이동.
//                }
//            });


//        sign_up.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//        if(mEtEmail.getText().toString().length()==0) {
//            Toast.makeText(Signup.this,"Email을 입력해주세요.",Toast.LENGTH_SHORT).show();
//            mEtEmail.requestFocus();
//            return;
//        }
//        if(mEtPsw.getText().toString().length()==0) {
//            Toast.makeText(Signup.this,"Password를 입력해주세요.",Toast.LENGTH_SHORT).show();
//            mEtPsw.requestFocus();
//            return;
//        }
//        if(mEtPswcheck.getText().toString().length()==0) {
//            Toast.makeText(Signup.this,"Email을 입핵해주세요.",Toast.LENGTH_SHORT).show();
//            mEtPswcheck.requestFocus();
//            return;
//        }
//        if(mEtPsw.getText().toString().equals(mEtPswcheck.getText().toString())){
//            Toast.makeText(Signup.this,"비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
//            mEtPsw.setText("");
//            mEtPswcheck.setText("");
//            mEtPsw.requestFocus();
//            return;
//        }
//    }
//});


// 이거임
//mBtnReguster.setOnClickListener(new View.OnClickListener(){
//@Override
//public void onClick(View v) {

//                if(mEtEmail.getText().toString().length()==0) {
//                    Toast.makeText(Signup.this,"Email을 입력해주세요.",Toast.LENGTH_SHORT).show();
//                    mEtEmail.requestFocus();
//                    return;
//                }
//                if(mEtPsw.getText().toString().length()==0) {
//                    Toast.makeText(Signup.this,"Password를 입력해주세요.",Toast.LENGTH_SHORT).show();
//                    mEtPsw.requestFocus();
//                    return;
//                }
//                if(mEtPswcheck.getText().toString().length()==0) {
//                    Toast.makeText(Signup.this,"Email을 입핵해주세요.",Toast.LENGTH_SHORT).show();
//                    mEtPswcheck.requestFocus();
//                    return;
//                }
//                if(mEtPsw.getText().toString().equals(mEtPswcheck.getText().toString())){
//                    Toast.makeText(Signup.this,"비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
//                    mEtPsw.setText("");
//                    mEtPswcheck.setText("");
//                    mEtPsw.requestFocus();
//                    return;
//                }

//        //회원가입 처리 시작
//        String strEmail = mEtEmail.getText().toString();//문자열로 변환해서 입력받은 이메일값을 가져오는 것
//        String strPsw = mEtPsw.getText().toString();
//
//
//        //firebase auth 진행
//        mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPsw).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
//@Override
//public void onComplete(@NonNull Task<AuthResult> task) {
//        //회원가입이 성공했을 때
//        if(task.isSuccessful()) {
//        FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
//        UserAccount account = new UserAccount();
//        account.setIdToken(firebaseUser.getUid()); //고유값.
//        account.setEmailId(firebaseUser.getEmail()); //유저이메일을 정확하게 가져 오는 것이 중요하기 때문에 파이어베이스 유저라는 객처로 가져옴
//        account.setPassword(strPsw);
//
//
//        //setValue : database에 insert(삽입) 행위
//        mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
//
//        Toast.makeText(Signup.this, "회원가입이 되었습니다.", Toast.LENGTH_SHORT).show();
//
//        Intent intent = new Intent(Signup.this,MainhomeActivity.class);
//        startActivity(intent); //액티비티 이동.
//
//        } else {
//        Toast.makeText(Signup.this, "회원가입에 실패하였습니다..", Toast.LENGTH_SHORT).show();
//        }
//        }
//
//        });
//
//
//        }
//        });
//        }
//        }

