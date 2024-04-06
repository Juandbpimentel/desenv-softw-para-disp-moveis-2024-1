package com.example.aplicacaoadapter.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.content.res.AppCompatResources;

import com.example.aplicacaoadapter.Item;
import com.example.aplicacaoadapter.ItemActivity;
import com.example.aplicacaoadapter.R;

import java.util.ArrayList;

public class ListViewCustomAdapter extends BaseAdapter {
    ArrayList<Item> items = new ArrayList<>();
    Context context;

    public ListViewCustomAdapter(ArrayList<Item> items, Context contexto){
        this.items = items;
        this.context = contexto;
    }
    //ArrayList comidasarray = new ArrayList();
    @Override
    public int getCount() {
        return items == null ? 0:items.size();
    }

    @Override
    public Object getItem(int position) {
    //    comidasarray.get(position);
        return items.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_custom_listview,parent,false);
            holder = new ViewHolder();
            holder.iw_item_image = convertView.findViewById(R.id.item_image);
            holder.tv_item_name = convertView.findViewById(R.id.item_name);
            holder.tv_item_description = convertView.findViewById(R.id.item_description);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_item_name.setText(items.get(position).getName());
        holder.tv_item_description.setText(items.get(position).getDescription());
        holder.iw_item_image.setImageDrawable(items.get(position).getImage());
        convertView.setOnClickListener(v -> {

            Intent intent = new Intent(context, ItemActivity.class);
            intent.putExtra("item_title", items.get(position).getName());
            intent.putExtra("item_description", items.get(position).getDescription());
            intent.putExtra("item_image_id", items.get(position).getImageId());
            context.startActivity(intent);
            Toast.makeText(context, "Clicou no item "+items.get(position).getName(), Toast.LENGTH_SHORT).show();
        });
        return convertView;
    }

    static class ViewHolder{
        TextView tv_item_name;
        TextView tv_item_description;
        ImageView iw_item_image;

    }
}


