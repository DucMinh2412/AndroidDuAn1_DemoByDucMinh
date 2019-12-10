package com.example.androidduan1_demobyducminh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.model.User;
import com.example.androidduan1_demobyducminh.presenter.RegistrationPresenter;
import com.example.androidduan1_demobyducminh.view.RegistrationView;

import java.util.ArrayList;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity implements RegistrationView {
    EditText edtDKuserName, edtDKpass, edtDKretypepass, edtDKphone;
    List<User> userList = new ArrayList<>();
    RegistrationPresenter registrationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edtDKuserName = findViewById(R.id.edtDKusername);
        edtDKpass = findViewById(R.id.edtDKPasswpord);
        edtDKretypepass = findViewById(R.id.edtDKretypePasswpord);
        edtDKphone = findViewById(R.id.edtDKphone);
        registrationPresenter = new RegistrationPresenter(this, userList, this);
    }

    public void Dangkireal(View view) {
        String DKusername = edtDKuserName.getText().toString();
        String DKpass = edtDKpass.getText().toString();
        String DKretypepass = edtDKretypepass.getText().toString();
        String DKphone = edtDKphone.getText().toString();
        registrationPresenter.Registration(DKusername, DKpass, DKretypepass, DKphone);
    }

    public void Cancelres(View view) {
        registrationPresenter.Cancel();
    }

    @Override
    public void setUsername() {
        edtDKuserName.setError("Mời nhập username");
    }

    @Override
    public void setPass() {
        edtDKpass.setError("Chưa nhập pass hoặc pass phải >6 số ");
    }

    @Override
    public void setRetypePass() {
        edtDKretypepass.setError("Chưa nhập lại pass hoặc pass nhập lại không đúng");
    }

    @Override
    public void setPhone() {
        edtDKphone.setError("Chưa nhập phone hoặc phone = 10 số ");
    }

    @Override
    public void Registration() {
        Toast.makeText(getApplicationContext(), "Đăng kí thành công", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }

    @Override
    public void Cancel() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }
}
