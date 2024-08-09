package br.dev.juanpimentel.appap1.Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.dev.juanpimentel.appap1.DAOs.ProgramBoyDAO;
import br.dev.juanpimentel.appap1.Entities.ProgramBoy;
import br.dev.juanpimentel.appap1.DAOs.TodoDAO;
import br.dev.juanpimentel.appap1.Entities.Todo;

@Database(entities = {ProgramBoy.class,Todo.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProgramBoyDAO programBoyDAO();
    public abstract TodoDAO todoDAO();
}
