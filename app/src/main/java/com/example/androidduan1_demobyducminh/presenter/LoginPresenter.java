package com.example.androidduan1_demobyducminh.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.androidduan1_demobyducminh.dao.UserDAO;
import com.example.androidduan1_demobyducminh.model.User;
import com.example.androidduan1_demobyducminh.view.LoginView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

// xu ly tuong tac giua view va nguoi dung
public class LoginPresenter {

    public LoginView loginView;
    public Context context;
    public UserDAO userDAO;

    // goi ham tao
    public LoginPresenter(LoginView loginView, Context context) {
        this.loginView = loginView;
        this.context = context;
    }

    public void Login(String username, String pass) {
        if (username.equals("")) {
            loginView.setUsername();
        } else if (pass.equals("")) {
            loginView.setPass();
        } else {
            userDAO = new UserDAO(context);
            User user = new User(username, pass);
            boolean result = userDAO.CheckLogin(user);
            if (result) {
                loginView.login();
            }
        }
    }

    public void LoginFB(LoginButton loginButton, CallbackManager callbackManager) {
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(context, "Chào mừng " + loginResult.getAccessToken().getUserId(), Toast.LENGTH_LONG).show();
                loginView.loginFB();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
            }
        });
    }

    public void RememberPass() {
        loginView.setRememberPass();
    }

    public void Registration() {
        loginView.Registration();
    }


}
