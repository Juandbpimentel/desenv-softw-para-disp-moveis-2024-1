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

import java.util.ArrayList;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder>{

    private final int listItemLayout;
    private final ArrayList<Item> itemList;

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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int listPosition) {
        TextView item_name = holder.item_name;
        ImageView item_image = holder.item_image;
        TextView item_description = holder.item_description;
        item_name.setText(itemList.get(listPosition).getName());
        item_image.setImageDrawable(itemList.get(listPosition).getImage());
        item_description.setText(itemList.get(listPosition).getDescription());
    }

    static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView item_name;
        public TextView item_description;
        public ImageView item_image;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            item_name = itemView.findViewById(R.id.row_item_name);
            item_image = itemView.findViewById(R.id.row_item_image);
            item_description = itemView.findViewById(R.id.row_item_description);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(itemView.getContext(),"Você clicou no item "+ item_name.getText(),Toast.LENGTH_SHORT).show();
            Log.d("onClick","onClick "+ getLayoutPosition()+" "+item_name.getText() + " " + item_description.getText() + " " + item_image.getDrawable());
        }
    }
}
