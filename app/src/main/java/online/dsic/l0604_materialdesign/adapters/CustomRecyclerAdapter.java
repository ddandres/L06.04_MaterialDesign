package online.dsic.l0604_materialdesign.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import online.dsic.l0604_materialdesign.R;
import online.dsic.l0604_materialdesign.pojo.Item;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }
    private ArrayList<Item> data;
    private OnItemClickListener listener;

    public CustomRecyclerAdapter(ArrayList<Item> data, CustomRecyclerAdapter.OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        CustomRecyclerAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv.setText(data.get(position).getText());
        holder.iv.setImageResource(data.get(position).getImage());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View v;
        public TextView tv;
        public ImageView iv;

        public ViewHolder(View view) {
            super(view);
            v = view;
            tv = (TextView) view.findViewById(R.id.tvAction);
            iv = (ImageView) view.findViewById(R.id.ivIcon);
        }
    }
}
