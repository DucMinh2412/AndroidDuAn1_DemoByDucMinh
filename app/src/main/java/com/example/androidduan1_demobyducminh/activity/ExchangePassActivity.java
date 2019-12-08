package com.example.androidduan1_demobyducminh.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.dao.UserDAO;
import com.example.androidduan1_demobyducminh.model.User;

public class ExchangePassActivity extends AppCompatActivity {
    EditText NewPass, NewTypePass;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_pass);
        NewPass = findViewById(R.id.edtNewPass);
        NewTypePass = findViewById(R.id.edtNewtypePass);
        userDAO = new UserDAO(this);
    }

    public void RetypePass(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MY_SHARE.f", Context.MODE_PRIVATE);

        String UserName = sharedPreferences.getString("user", "");
        String Pass = NewPass.getText().toString();
        String TypePass = NewTypePass.getText().toString();
        User user = new User(UserName, Pass, "");
        if (Pass.equals("") || TypePass.equals("")) {
            Toast.makeText(getApplicationContext(), "Chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
        }

        if (!TypePass.equals(Pass)) {
            Toast.makeText(getApplicationContext(), "Không trùng mật khẩu", Toast.LENGTH_SHORT).show();
        } else {

            if (userDAO.changePasswordUser(user) > 0) {
                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Lưu thất bại", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void Cancel(View view) {
        finish();
    }
}
