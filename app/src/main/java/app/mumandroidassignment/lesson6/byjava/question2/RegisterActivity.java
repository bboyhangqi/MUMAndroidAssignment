package app.mumandroidassignment.lesson6.byjava.question2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.mumandroidassignment.R;

/**
 * Created by CodingHome on 4/5/18.
 */

public class RegisterActivity extends Activity {

    private EditText edFirstname, edLastname, edEmail, edPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        edFirstname=findViewById(R.id.ed_first_name);
        edLastname=findViewById(R.id.ed_last_name);
        edEmail=findViewById(R.id.ed_emall);
        edPassword=findViewById(R.id.ed_password);
    }

    public void createAccount(View view){
        String firstname = edFirstname.getText().toString();
        String lastname = edLastname.getText().toString();
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        if (TextUtils.isEmpty(firstname) || TextUtils.isEmpty(lastname) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please fill out all forms", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent();
            intent.putExtra("firstname", firstname);
            intent.putExtra("lastname", lastname);
            intent.putExtra("username", email);
            intent.putExtra("password", password);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
}
