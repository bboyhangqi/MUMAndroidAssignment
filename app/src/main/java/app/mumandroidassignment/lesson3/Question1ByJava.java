package app.mumandroidassignment.lesson3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import app.mumandroidassignment.R;

/**
 * Created by CodingHome on 4/3/18.
 */

public class Question1ByJava extends Activity {

    private EditText edLBs, edKGs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1_by_kotlin);
        edLBs = findViewById(R.id.ed_lbs);
        edKGs = findViewById(R.id.ed_kgs);
    }

    public void convert(View view) {
        String lbs = edLBs.getText().toString();
        if(!TextUtils.isEmpty(lbs)){
            double pounds = Double.parseDouble(lbs);
            double kilograms = pounds * 0.454;
            edKGs.setText(kilograms + "");
        }
    }
}
