package app.mumandroidassignment.lesson3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.mumandroidassignment.R;

/**
 * Created by CodingHome on 4/3/18.
 */

public class Question2ByJava extends Activity {

    private TextView tvDishName;
    private EditText edAddFood;
    private List<String> foodList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2_by_kotlin);
        tvDishName = findViewById(R.id.tv_dish_name);
        edAddFood = findViewById(R.id.ed_add_food);
        initFoodList();
    }

    private void initFoodList() {
        foodList.add("Hamburger");
        foodList.add("Pizza");
        foodList.add("Mexican");
        foodList.add("American");
        foodList.add("Chinese");
    }

    public void addFood(View view) {
        String addedFood = edAddFood.getText().toString();
        if (!addedFood.isEmpty()) {
            foodList.add(0, addedFood);
            tvDishName.setText(addedFood);
            edAddFood.setText(null);
        }
    }

    public void decide(View view) {
        int index = new Random().nextInt(foodList.size());
        tvDishName.setText(foodList.get(index));
        edAddFood.setText(null);
    }
}
