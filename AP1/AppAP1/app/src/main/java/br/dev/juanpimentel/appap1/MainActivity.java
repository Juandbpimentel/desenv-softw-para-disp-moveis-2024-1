package br.dev.juanpimentel.appap1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.dev.juanpimentel.appap1.Adapters.PrograBoyArrayAdapter;
import br.dev.juanpimentel.appap1.Adapters.TodoArrayAdapter;
import br.dev.juanpimentel.appap1.DAOs.ProgramBoyDAO;
import br.dev.juanpimentel.appap1.DAOs.TodoDAO;
import br.dev.juanpimentel.appap1.Databases.AppDatabase;
import br.dev.juanpimentel.appap1.Entities.ProgramBoy;
import br.dev.juanpimentel.appap1.Entities.Todo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    RecyclerView recyclerViewTodo;
    Button createTodobtn;
    ArrayList<Todo> todos;
    TodoArrayAdapter adapter;
    TodoDAO todoDAO;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerViewTodo = findViewById(R.id.recyclerViewTodo);
        createTodobtn = findViewById(R.id.main_btn_create_novo);
        createTodobtn.setOnClickListener(this);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app-database")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        todoDAO = db.todoDAO();
        todos = new ArrayList<Todo>(todoDAO.getAll());

        adapter = new TodoArrayAdapter(R.layout.todo_fragment, todos);
        recyclerViewTodo.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTodo.setAdapter(adapter);
        for (Todo t : todos ) {
           Log.d("Todo",t.toString());
        }
        swipeToDelete();
    }

    public void swipeToDelete(){
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(MainActivity.this, "Você deletou o todo com sucesso!", Toast.LENGTH_SHORT).show();
                int position = viewHolder.getAdapterPosition();
                Todo todo = todos.get(position);
                todos.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());
                todoDAO.delete(todo);
            }
        }).attachToRecyclerView(recyclerViewTodo);
    }

    @Override
    public void onClick(View v) {
        if (v == createTodobtn) {
            Intent intent = new Intent(this, CreateTodo.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        TodoDAO todoDAO = db.todoDAO();
        todos = new ArrayList<Todo>(todoDAO.getAll());
        adapter = new TodoArrayAdapter(R.layout.todo_fragment, (ArrayList<Todo>) todos);
        recyclerViewTodo.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTodo.setAdapter(adapter);
        swipeToDelete();
    }
}