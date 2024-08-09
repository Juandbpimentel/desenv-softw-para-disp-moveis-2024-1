package br.dev.juanpimentel.appap1.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.dev.juanpimentel.appap1.Entities.ProgramBoy;
import br.dev.juanpimentel.appap1.R;

public class PrograBoyArrayAdapter extends RecyclerView.Adapter<PrograBoyArrayAdapter.ViewHolder>{

    private final int listProgramBoyId;
    private final ArrayList<ProgramBoy> programadores;

    public PrograBoyArrayAdapter(int listProgramBoyId, ArrayList<ProgramBoy> programadores) {
        this.listProgramBoyId = listProgramBoyId;
        this.programadores = programadores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listProgramBoyId,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView item_id = holder.item_id;
        TextView item_nome = holder.item_nome;
        TextView item_area_atuacao = holder.item_area_atuacao;
        TextView item_idade = holder.item_idade;
        item_id.setText(programadores.get(position).getId());
        item_nome.setText(programadores.get(position).getNome());
        item_area_atuacao.setText(programadores.get(position).getAreaDeProgramacao());
        item_idade.setText(String.valueOf(programadores.get(position).getIdade()));
    }

    @Override
    public int getItemCount() {
        return programadores == null ? 0:programadores.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView item_id;
        public TextView item_nome;
        public TextView item_area_atuacao;
        public TextView item_idade;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            item_nome = itemView.findViewById(R.id.programboy_fragment_tv_nome);
            item_area_atuacao = itemView.findViewById(R.id.programboy_fragment_tv_area_atuacao);
            item_idade = itemView.findViewById(R.id.programboy_fragment_tv_idade);
            item_id = itemView.findViewById(R.id.programboy_fragment_tv_id);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(itemView.getContext(),"Você clicou no programador "+ item_nome.getText(),Toast.LENGTH_SHORT).show();
            Log.d("onClick","onClick "+ getLayoutPosition()+" "+item_nome.getText());
        }
    }
}
