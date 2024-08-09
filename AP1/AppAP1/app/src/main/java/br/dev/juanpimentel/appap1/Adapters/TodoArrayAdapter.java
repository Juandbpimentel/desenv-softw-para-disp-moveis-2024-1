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

import br.dev.juanpimentel.appap1.Entities.Todo;
import br.dev.juanpimentel.appap1.R;

public class TodoArrayAdapter extends RecyclerView.Adapter<TodoArrayAdapter.ViewHolder>{

    private final int listTodoId;
    private final ArrayList<Todo> todos;

    public TodoArrayAdapter(int listTodoId, ArrayList<Todo> todos) {
        this.listTodoId = listTodoId;
        this.todos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listTodoId,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView todo_titulo = holder.todo_titulo;
        TextView todo_descricao = holder.todo_descricao;
        todo_titulo.setText(todos.get(position).getTitulo());
        todo_descricao.setText(todos.get(position).getDescricao());
    }

    @Override
    public int getItemCount() {
        return todos == null ? 0:todos.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView todo_id;public TextView todo_titulo;
        public TextView todo_descricao;

        public ViewHolder(View todoView){
            super(todoView);
            todoView.setOnClickListener(this);
            todo_titulo = todoView.findViewById(R.id.todo_fragment_tv_titulo);
            todo_descricao = todoView.findViewById(R.id.todo_fragment_tv_descricao);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(itemView.getContext(),"Você clicou no todo "+ todo_titulo.getText(),Toast.LENGTH_SHORT).show();
            Log.d("onClick","onClick "+ getLayoutPosition()+" "+todo_titulo.getText());
        }
    }
}
