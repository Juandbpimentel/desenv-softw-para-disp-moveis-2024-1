package com.example.aplicacaoadapter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aplicacaoadapter.R;

import java.util.ArrayList;

public class ListViewCustomAdapter extends BaseAdapter {
    String[] comidas;
    Context context;

    public ListViewCustomAdapter(String[] comidas, Context contexto){
        this.comidas = comidas;
        this.context = contexto;
    }
    //ArrayList comidasarray = new ArrayList();
    @Override
    public int getCount() {
        return comidas.length;
    }

    @Override
    public Object getItem(int position) {
    //    comidasarray.get(position);
        return comidas[position];

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
            holder.tvNomeComida = convertView.findViewById(R.id.itemTextView);
            holder.imNomeComida = convertView.findViewById(R.id.itemImageView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvNomeComida.setText(comidas[position]);
        holder.imNomeComida.setBackgroundResource(R.drawable.joelho);
        return convertView;
    }

    static class ViewHolder{
        TextView tvNomeComida;
        ImageView imNomeComida;

    }
}


