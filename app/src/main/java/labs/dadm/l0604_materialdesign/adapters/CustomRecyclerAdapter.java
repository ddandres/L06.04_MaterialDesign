/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0604_materialdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import labs.dadm.l0604_materialdesign.R;
import labs.dadm.l0604_materialdesign.pojo.Item;

// Custom adapter to associate the source data with Views within the RecyclerView.
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    // Interface defined to react to clicks on the Views within the RecyclerView
    public interface OnItemClickListener {
        void onItemClicked(int position);
    }

    final private Context context;
    // Hold reference to the source data
    final private ArrayList<Item> data;
    // Hold reference to the implementation of the listener
    final private OnItemClickListener listener;

    // Custom constructor that receives the source data and the listener
    public CustomRecyclerAdapter(Context context, ArrayList<Item> data, CustomRecyclerAdapter.OnItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    // Creates a ViewHolder for the RecyclerView to represent Items.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create the View from an XML layout resource
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        // Create a ViewHolder that will hold references to the View and its subViews
        return new ViewHolder(view, listener);
    }

    // Updates the information displayed on the ViewHolder according to the given position.
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        // Update the subViews within the holder with information from the data source
        holder.tv.setText(data.get(position).getText());
        holder.tv.setCompoundDrawablesWithIntrinsicBounds(
                ResourcesCompat.getDrawable(context.getResources(), data.get(position).getImage(), null),
                null, null, null);
    }

    // Returns the number of elements in the data source.
    @Override
    public int getItemCount() {
        return data.size();
    }

    // Custom ViewHolder to hold references to the View and subViews displaying the data.
    static class ViewHolder extends RecyclerView.ViewHolder {
        // Hold a reference to the View to later associate an onClickListener
        View v;
        // Hold a reference to a TextView to later change its text
        TextView tv;

        ViewHolder(View view, final CustomRecyclerAdapter.OnItemClickListener listener) {
            super(view);
            v = view;
            v.setOnClickListener(v -> listener.onItemClicked(getAbsoluteAdapterPosition()));
            tv = view.findViewById(R.id.tvItem);
        }
    }
}