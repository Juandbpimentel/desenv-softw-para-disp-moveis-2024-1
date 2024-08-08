package br.dev.juanpimentel.appap1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import br.dev.juanpimentel.appap1.DAOs.ProgramBoyDAO;
import br.dev.juanpimentel.appap1.Databases.AppDatabase;
import br.dev.juanpimentel.appap1.Entities.ProgramBoy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    RecyclerView recyclerViewPB;
    FloatingActionButton createProgramBoyBtn;
    ArrayList<ProgramBoy> programadores;
    PrograBoyArrayAdapter adapter;
    ProgramBoyDAO programBoyDAO;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerViewPB = findViewById(R.id.recyclerViewPB);
        createProgramBoyBtn = findViewById(R.id.main_activity_flt_btn_add_program_boy);
        createProgramBoyBtn.setOnClickListener(this);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app-database")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        programBoyDAO = db.programBoyDAO();
        programadores = new ArrayList<ProgramBoy>(programBoyDAO.getAll());

        adapter = new PrograBoyArrayAdapter(R.layout.programboy_fragment, (ArrayList<ProgramBoy>) programadores);
        recyclerViewPB.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPB.setAdapter(adapter);
        for (ProgramBoy p : programadores ) {
           Log.d("Pessoa",p.toString());
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
                Toast.makeText(MainActivity.this, "Você deletou o programador", Toast.LENGTH_SHORT).show();
                int position = viewHolder.getAdapterPosition();
                ProgramBoy programador = programadores.get(position);
                programadores.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());
                programBoyDAO.delete(programador);
            }
        }).attachToRecyclerView(recyclerViewPB);
    }

    @Override
    public void onClick(View v) {
        if (v == createProgramBoyBtn) {
            Intent intent = new Intent(this, CreateProgramBoy.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ProgramBoyDAO programBoyDAO = db.programBoyDAO();
        programadores = new ArrayList<ProgramBoy>(programBoyDAO.getAll());
        adapter = new PrograBoyArrayAdapter(R.layout.programboy_fragment, (ArrayList<ProgramBoy>) programadores);
        recyclerViewPB.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPB.setAdapter(adapter);
        swipeToDelete();
    }
}