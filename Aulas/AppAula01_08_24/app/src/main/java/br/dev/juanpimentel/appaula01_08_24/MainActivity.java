package br.dev.juanpimentel.appaula01_08_24;

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
import java.util.List;

import br.dev.juanpimentel.appaula01_08_24.Adapters.PrograBoyArrayAdapter;
import br.dev.juanpimentel.appaula01_08_24.DAOs.ProgramBoyDAO;
import br.dev.juanpimentel.appaula01_08_24.Databases.AppDatabase;
import br.dev.juanpimentel.appaula01_08_24.Entities.ProgramBoy;

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
        /*
            programadores = new ArrayList<ProgramBoy>();
            programadores.add(new ProgramBoy("Juan", "Desenvolvimento de Software", 22));
            programadores.add(new ProgramBoy("Pedro", "Desenvolvimento de Software", 22));
            programadores.add(new ProgramBoy("João", "Desenvolvimento de Software", 22));
            programadores.add(new ProgramBoy("Maria", "Desenvolvimento de Software", 22));
            programadores.add(new ProgramBoy("José", "Desenvolvimento de Software", 22));
            for (ProgramBoy p : programadores)
                programBoyDAO.insert(p);
        */
        programadores = new ArrayList<ProgramBoy>(programBoyDAO.getAll());

        adapter = new PrograBoyArrayAdapter(R.layout.programboy_fragment, (ArrayList<ProgramBoy>) programadores);
        recyclerViewPB.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPB.setAdapter(adapter);
        for (ProgramBoy p : programadores ) {
           Log.d("Pessoa",p.toString());
        }
        swapToDelete();
    }

    public void swapToDelete(){
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
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
         db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app-database")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        ProgramBoyDAO programBoyDAO = db.programBoyDAO();
        programadores = new ArrayList<ProgramBoy>(programBoyDAO.getAll());
        adapter = new PrograBoyArrayAdapter(R.layout.programboy_fragment, (ArrayList<ProgramBoy>) programadores);
        recyclerViewPB.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPB.setAdapter(adapter);
        swapToDelete();
    }

    private void swipeToDelete(){

    }
}