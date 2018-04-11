package app.mumandroidassignment.lesson7.byjava.question1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

import app.mumandroidassignment.R;

public class WebItemAdpter extends RecyclerView.Adapter<WebItemAdpter.ViewHolder> {

    private List<WebInfo> data;

    public WebItemAdpter(List<WebInfo> infos) {
        this.data = infos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_web, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setBackgroundResource(data.get(position).getIconId());
        holder.ib.setBackgroundResource(R.mipmap.go1);
        holder.webInfo = data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView icon;
        private ImageButton ib;
        public WebInfo webInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            ib = itemView.findViewById(R.id.ib);
            ib.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String addr = webInfo.getAddr();
            Intent intent = new Intent(itemView.getContext(), WebActivity.class);
            intent.putExtra("url", addr);
            itemView.getContext().startActivity(intent);
        }
    }
}
