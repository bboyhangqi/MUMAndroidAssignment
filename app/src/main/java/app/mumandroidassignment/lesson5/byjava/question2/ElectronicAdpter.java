package app.mumandroidassignment.lesson5.byjava.question2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

import app.mumandroidassignment.R;
import app.mumandroidassignment.lesson5.bykotlin.question2.bean.Product;

/**
 * Created by CodingHome on 4/8/18.
 */

public class ElectronicAdpter extends RecyclerView.Adapter<ElectronicAdpter.ViewHolder> implements View.OnClickListener {

    private List<Product> data;

    public ElectronicAdpter(List<Product> list) {
        this.data = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        view.setClickable(true);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .asBitmap()
                .load(data.get(position).getImageUrl())
                .into(holder.icon);
        holder.title.setText(data.get(position).getTitle());
        holder.price.setText("Price : $" + data.get(position).getPrice());
        holder.color.setText(String.format(Locale.getDefault(), "Color : %s", data.get(position).getColor()));
        holder.itemView.setTag(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        Log.d("112233", "onClick");
        Product product = (Product) v.getTag();
        Intent intent = new Intent(v.getContext(), DetailActivity.class);
        intent.putExtra("product", product);
        v.getContext().startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        private ImageView icon = itemView.findViewById(R.id.im_icon);
        private TextView title = itemView.findViewById(R.id.tv_title);
        private TextView price = itemView.findViewById(R.id.tv_price);
        private TextView color = itemView.findViewById(R.id.tv_color);
    }
}
