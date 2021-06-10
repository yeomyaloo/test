package com.example.practice_1;

/**
 * 사용자 계정 정보 모델 클래스
 *
 * 다른 것을 더 넣기 위해서는 프로필사진, 닉네임 등등등을
 * 관리하기 위해서는 여기서 해주면 됨
 */
public class UserAccount {

    private String idToken; //파이어베이스 Uid 고유토큰 정보 가져오기.
    private String emailId; //이메일 아이디
    private String password; //비밀번호호

   public UserAccount() { }

    public String getIdToken() {return idToken;}

    public void setIdToken(String idToken){
       this.idToken = idToken;
    }

    //설정하고 가져오기 위해서
    public String getEmailId() {return emailId;}
    public void setEmailId(String emailId) {this.emailId = emailId;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
