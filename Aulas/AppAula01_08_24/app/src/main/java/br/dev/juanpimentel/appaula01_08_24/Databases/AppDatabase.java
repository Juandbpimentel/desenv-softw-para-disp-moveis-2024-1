package br.dev.juanpimentel.appaula01_08_24.Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.dev.juanpimentel.appaula01_08_24.DAOs.ProgramBoyDAO;
import br.dev.juanpimentel.appaula01_08_24.Entities.ProgramBoy;

@Database(entities = {ProgramBoy.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProgramBoyDAO programBoyDAO();
}
