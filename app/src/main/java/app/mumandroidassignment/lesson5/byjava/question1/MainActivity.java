package app.mumandroidassignment.lesson5.byjava.question1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import app.mumandroidassignment.R;

/**
 * Created by CodingHome on 4/5/18.
 */

public class MainActivity extends Activity {

    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5_q1);
        autoCompleteTextView = findViewById(R.id.actv_move);
        final String[] moives = {"AAA", "BBB", "CCC", "DDD", "EEE"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moives);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, moives[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
