package app.mumandroidassignment.lesson6.byjava.question2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import app.mumandroidassignment.R;

/**
 * Created by CodingHome on 4/5/18.
 */

public class LoginActivity extends Activity {

    private EditText edUsername, edPassword;

    private static final int REQUEST_CODE = 1;

    private List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walmart_login);
        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
        edUsername.setText(sp.getString("username", ""));
        edPassword.setText(sp.getString("password", ""));
        init();
    }


    @Override
    protected void onResume() {
        super.onResume();
        updateAccount();
    }

    private void updateAccount() {
        SharedPreferences sp = getSharedPreferences("new_account", MODE_PRIVATE);
        String gsonUser = sp.getString("user", "");
        Log.d("zhq.debug","new account "+gsonUser);
        if (!TextUtils.isEmpty(gsonUser)) {
            User user = new Gson().fromJson(gsonUser, User.class);
            users.add(user);
        }
    }

    private void init() {
        users.add(new User("", "", "ZMM1@gmail.com", "123"));
        users.add(new User("", "", "ZMM2@gmail.com", "123"));
        users.add(new User("", "", "ZMM3@gmail.com", "123"));
        users.add(new User("", "", "ZMM4@gmail.com", "123"));
        users.add(new User("", "", "ZMM5@gmail.com", "123"));
        users.add(new User("", "", "ZMM6@gmail.com", "123"));
        users.add(new User("", "", "ZMM7@gmail.com", "123"));
        users.add(new User("", "", "ZMM8@gmail.com", "123"));

    }

    public void goToCreateAccount(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void storeLoginInfo(String username, String password) {
        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public void login(View view) {
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        for (int i = 0; i < users.size(); i++) {
            Log.d("zhq.debug", users.get(i).getEmail() + " " + users.get(i).getPassword());
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(username) && users.get(i).getPassword().equals(password)) {
                storeLoginInfo(username, password);
                Intent intent = new Intent(this, ShoppingActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        }
        Toast.makeText(this, "username or password illegal", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String firstname = data.getStringExtra("firstname");
                String lastname = data.getStringExtra("lastname");
                String username = data.getStringExtra("username");
                String password = data.getStringExtra("password");

                User user = new User(firstname, lastname, username, password);
                users.add(user);

                edUsername.setText(username);
                edPassword.setText(password);

                Gson gson = new Gson();
                SharedPreferences sp = getSharedPreferences("new_account", MODE_PRIVATE);
                sp.edit().putString("user", gson.toJson(new User(firstname, lastname, username, password))).apply();
            }
        }
    }
}
