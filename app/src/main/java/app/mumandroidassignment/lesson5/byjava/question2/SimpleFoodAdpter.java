package app.mumandroidassignment.lesson5.byjava.question2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.mumandroidassignment.R;

/**
 * Created by CodingHome on 4/8/18.
 */

public class SimpleFoodAdpter extends RecyclerView.Adapter<SimpleFoodAdpter.ViewHolder> {

    private String[] data;

    public SimpleFoodAdpter(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        private ImageView icon = itemView.findViewById(R.id.im_icon);
        private TextView title = itemView.findViewById(R.id.tv_title);

    }
}
