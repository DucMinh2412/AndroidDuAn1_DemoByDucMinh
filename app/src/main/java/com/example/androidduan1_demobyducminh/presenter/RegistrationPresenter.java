package com.example.androidduan1_demobyducminh.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.androidduan1_demobyducminh.dao.UserDAO;
import com.example.androidduan1_demobyducminh.model.User;
import com.example.androidduan1_demobyducminh.view.RegistrationView;

import java.util.List;

public class RegistrationPresenter {
    public RegistrationView registrationView;
    public List<User> userList;
    public Context context;
    UserDAO userDAO;

    public RegistrationPresenter(RegistrationView registrationView, List<User> userList, Context context) {
        this.registrationView = registrationView;
        this.userList = userList;
        this.context = context;
    }

    public void Registration(String username, String pass, String typePass, String phone) {
        if (username.equals("")) {
            registrationView.setUsername();
        } else if (pass.equals("") || pass.length() < 6) {
            registrationView.setPass();
        } else if (typePass.equals("") || !typePass.equals(pass)) {
            registrationView.setRetypePass();
        } else if (phone.equals("") || phone.length() < 10 || phone.length() > 10) {
            registrationView.setPhone();
        } else {
            userDAO = new UserDAO(context);
            User user = new User(username, pass, phone);
            userList.add(user);
            if (userDAO.InsertUser(user) < 0) {
                Toast.makeText(context, "Đăng kí thất bại", Toast.LENGTH_LONG).show();
            } else {
                registrationView.Registration();

            }
        }
    }

    public void Cancel() {
        registrationView.Cancel();
    }
}
