package com.example.androidduan1_demobyducminh.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.presenter.LoginPresenter;
import com.example.androidduan1_demobyducminh.view.LoginView;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity implements LoginView {
    public EditText edtuser;
    public EditText edtpass;
    public CheckBox chkcheckbox;
    public LoginButton LoginFB;
    public CallbackManager callbackManager;
    LoginPresenter userPresenter;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtuser = findViewById(R.id.edtUsername);
        edtpass = findViewById(R.id.edtPasswpord);
        chkcheckbox = findViewById(R.id.chksavepass);
        LoginFB = findViewById(R.id.login_button);
        userPresenter = new LoginPresenter(this, this);
        showChecked();
    }


    public void DangKi(View view) {
        userPresenter.Registration();
    }

    public void DangNhap(View view) {
        username = edtuser.getText().toString().trim();
        password = edtpass.getText().toString().trim();
        userPresenter.isChecked(username, password, chkcheckbox, this);
        userPresenter.Login(username, password);
    }

    public void LoginFB(View view) {
        callbackManager = CallbackManager.Factory.create();
        userPresenter.LoginFB(LoginFB, callbackManager);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void setUsername() {
        edtuser.setError("Nhập sai username");
    }

    @Override
    public void setPass() {
        edtpass.setError("Nhập sai password");
    }


    @Override
    public void login() {
        Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void Registration() {
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFB() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

    public void showChecked() {
        SharedPreferences sharedPreferences = getSharedPreferences("MY_SHARE.f", Context.MODE_PRIVATE);
        boolean result = sharedPreferences.getBoolean("save", false);
        if (result) {
            String username = sharedPreferences.getString("user", null);
            String pass = sharedPreferences.getString("pass", null);
            edtuser.setText(username);
            edtpass.setText(pass);

        } else {
            String user = sharedPreferences.getString("user", null);
            edtuser.setText(user);

        }
        chkcheckbox.setChecked(result);
    }


}
