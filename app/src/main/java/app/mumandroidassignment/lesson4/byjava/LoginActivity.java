package app.mumandroidassignment.lesson4.byjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        init();
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

    public void login(View view) {
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(username) && users.get(i).getPassword().equals(password)) {
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

                users.add(new User(firstname, lastname, username, password));

                edUsername.setText(username);
                edPassword.setText(password);
            }
        }
    }
}
