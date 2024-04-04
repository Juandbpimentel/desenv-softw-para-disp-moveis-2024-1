package com.example.aplicacaoadapter.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacaoadapter.R;
import com.example.aplicacaoadapter.items.Item;

import java.util.ArrayList;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder>{

    private int listItemLayout;
    private ArrayList<Item> itemList;

    public ItemArrayAdapter(int layoutId, ArrayList<Item> itemList){
        this.listItemLayout = layoutId;
        this.itemList = itemList;
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0: itemList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout,parent,false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        item.setText(itemList.get(listPosition).getName());
    }

    static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView item;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            item = itemView.findViewById(R.id.row_item);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(itemView.getContext(),":D - "+ item.getText(),Toast.LENGTH_SHORT).show();
            Log.d("onClick","onClick "+ getLayoutPosition()+" "+item.getText());
        }
    }
}
