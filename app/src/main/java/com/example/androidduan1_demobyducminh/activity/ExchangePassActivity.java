package com.example.androidduan1_demobyducminh.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidduan1_demobyducminh.R;

public class ExchangePassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_pass);
    }

    public void RetypePass(View view) {
        finish();
    }

    public void Cancel(View view) {
        finish();
    }
}
