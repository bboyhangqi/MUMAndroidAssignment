package app.mumandroidassignment.lesson4.byjava;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import app.mumandroidassignment.R;

/**
 * Created by CodingHome on 4/5/18.
 */

public class ShoppingActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
    }

    public void onCategoryClick (View view){
        int id = view.getId();
        switch (id){
            case R.id.beauty:
                Toast.makeText(this,
                        "You have chosen the Beauty category of shopping",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.clothing:
                Toast.makeText(this,
                        "You have chosen the Clothing category of shopping",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.electronics:
                Toast.makeText(this,
                        "You have chosen the Electronics category of shopping",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.food:
                Toast.makeText(this,
                        "You have chosen the Food category of shopping",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
