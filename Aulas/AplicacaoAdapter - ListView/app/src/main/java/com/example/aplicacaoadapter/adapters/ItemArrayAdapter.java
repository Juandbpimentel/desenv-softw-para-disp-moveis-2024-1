package com.example.aplicacaoadapter.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacaoadapter.R;
import com.example.aplicacaoadapter.items.Item;

import java.net.URI;
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
        TextView item_name = holder.item_name;
        ImageView item_image = holder.item_image;
        TextView itme_description = holder.itme_description;
        item_name.setText(itemList.get(listPosition).getName());
        item_image.setBackground(itemList.get(listPosition).);
        item_name.setText(itemList.get(listPosition).getName());
    }

    static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView item_name;
        public TextView itme_description;
        public ImageView item_image;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            item_name = itemView.findViewById(R.id.row_item_name);
            item_image = itemView.findViewById(R.id.row_item_image);
            itme_description = itemView.findViewById(R.id.row_item_name);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(itemView.getContext(),":D - "+ item_name.getText(),Toast.LENGTH_SHORT).show();
            Log.d("onClick","onClick "+ getLayoutPosition()+" "+item_name.getText());
        }
    }
}
