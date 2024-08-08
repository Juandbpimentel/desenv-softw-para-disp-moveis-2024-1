package br.dev.juanpimentel.appap1.Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.dev.juanpimentel.appap1.DAOs.ProgramBoyDAO;
import br.dev.juanpimentel.appap1.Entities.ProgramBoy;

@Database(entities = {ProgramBoy.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProgramBoyDAO programBoyDAO();
}
