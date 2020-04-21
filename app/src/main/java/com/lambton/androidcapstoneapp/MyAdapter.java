package com.lambton.androidcapstoneapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.textViewBatch.setText(listItem.getBatchName());
        holder.textViewClient.setText(listItem.getClient());
        holder.textViewSubmitted.setText(listItem.getSubmitted_by());
        holder.textViewDue.setText(listItem.getDue_date());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewBatch;
        public TextView textViewClient;
        public TextView textViewSubmitted;
        public TextView textViewDue;


        public ViewHolder(View itemView ) {
            super(itemView);
            textViewBatch = (TextView) itemView.findViewById(R.id.textviewBatch);
            textViewClient = (TextView) itemView.findViewById(R.id.textviewClient);
            textViewSubmitted = (TextView) itemView.findViewById(R.id.textviewSubmitted);
            textViewDue = (TextView) itemView.findViewById(R.id.textviewDueDate);
        }
    }

}

