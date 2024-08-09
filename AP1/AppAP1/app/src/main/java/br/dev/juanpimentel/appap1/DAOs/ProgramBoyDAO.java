package br.dev.juanpimentel.appap1.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.dev.juanpimentel.appap1.Entities.ProgramBoy;

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

    @Query("DELETE FROM program_boy where id = :id")
    void deleteById(String id);

    @Query("SELECT * FROM program_boy WHERE id = :id")
    ProgramBoy get(String id);

    @Query("SELECT * FROM program_boy WHERE id IN (:ids)")
    List<ProgramBoy> get(List<String> ids);

    @Query("SELECT * FROM program_boy")
    List<ProgramBoy> getAll();
}
