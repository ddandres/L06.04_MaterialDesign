/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package online.dsic.l0604_materialdesign.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import online.dsic.l0604_materialdesign.R;
import online.dsic.l0604_materialdesign.pojo.Item;

/**
 * Custom adapter to associate the source data with Views within the RecyclerView.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    // Interface defined to react to clicks on the Views within the RecyclerView
    public interface OnItemClickListener {
        void onItemClicked(int position);
    }

    // Hold reference to the source data
    private ArrayList<Item> data;
    // Hold reference to the implementation of the listener
    private OnItemClickListener listener;

    // Custom constructor that receives the source data and the listener
    public CustomRecyclerAdapter(ArrayList<Item> data, CustomRecyclerAdapter.OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    /**
     * Creates a ViewHolder for the RecyclerView to represent Items.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Create the View from an XML layout resource
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        // Create a ViewHolder that will hold references to the View and its subViews
        CustomRecyclerAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * Updates the information displayed on the ViewHolder according to the given position.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // Update the subViews within the holder with information from the data source
        holder.tv.setText(data.get(position).getText());
        holder.iv.setImageResource(data.get(position).getImage());
        // Asscociate the click listener to the View
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(position);
            }
        });
    }

    /**
     * Returns the number of elements in the data source.
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * Custom ViewHolder to hold references to the View and subViews dsplaying the data.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Hold a reference to the View to later associate an onClickListener
        public View v;
        // Hold a reference to a TextView to later change its text
        public TextView tv;
        // Hold a reference to an ImageView to later change its image
        public ImageView iv;

        public ViewHolder(View view) {
            super(view);
            v = view;
            tv = (TextView) view.findViewById(R.id.tvAction);
            iv = (ImageView) view.findViewById(R.id.ivIcon);
        }
    }
}