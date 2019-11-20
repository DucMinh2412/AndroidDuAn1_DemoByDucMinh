package com.example.androidduan1_demobyducminh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void Dangkireal(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }

    public void Cancelres(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }
}
