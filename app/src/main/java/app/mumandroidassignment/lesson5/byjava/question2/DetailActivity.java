package app.mumandroidassignment.lesson5.byjava.question2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;

import app.mumandroidassignment.R;
import app.mumandroidassignment.lesson5.bykotlin.question2.bean.Product;

/**
 * Created by CodingHome on 4/8/18.
 */

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");
        ImageView icon = findViewById(R.id.im_icon);
        TextView title = findViewById(R.id.tv_title);
        TextView color = findViewById(R.id.tv_color);
        TextView id = findViewById(R.id.tv_id);
        TextView dec = findViewById(R.id.tv_description);

        Glide.with(this)
                .asBitmap()
                .load(product.getImageUrl())
                .into(icon);
        title.setText(product.getTitle());
        color.setText(String.format(Locale.getDefault(), "Color : %s", product.getColor()));
        id.setText("Walmart : " + product.getItemid());
        dec.setText(product.getDesc());
    }
}
