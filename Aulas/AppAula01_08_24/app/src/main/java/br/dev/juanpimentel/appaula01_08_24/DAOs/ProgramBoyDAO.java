package br.dev.juanpimentel.appaula01_08_24.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.UUID;

import br.dev.juanpimentel.appaula01_08_24.Entities.ProgramBoy;

@Dao
public interface ProgramBoyDAO {
    @Insert
    void insert(ProgramBoy programBoy);

    @Insert
    void insertAll(ProgramBoy... programBoy);

    @Update
    void update(ProgramBoy programBoy);

    @Delete
    void delete(ProgramBoy programBoy);

    @Delete
    void deleteAll(ProgramBoy... programBoy);

    @Query("SELECT * FROM program_boy WHERE id = :id")
    ProgramBoy get(String id);

    @Query("SELECT * FROM program_boy WHERE id IN (:ids)")
    List<ProgramBoy> get(List<String> ids);

    @Query("SELECT * FROM program_boy")
    List<ProgramBoy> getAll();
}
