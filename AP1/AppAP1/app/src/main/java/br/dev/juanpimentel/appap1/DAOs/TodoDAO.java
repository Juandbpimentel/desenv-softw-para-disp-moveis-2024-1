package br.dev.juanpimentel.appap1.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.dev.juanpimentel.appap1.Entities.Todo;

@Dao
public interface TodoDAO {
    @Insert
    void insert(Todo todo);

    @Insert
    void insertAll(Todo... todo);

    @Update
    void update(Todo todo);

    @Delete
    void delete(Todo todo);

    @Delete
    void deleteAll(Todo... todo);

    @Query("DELETE FROM todo where id = :id")
    void deleteById(String id);

    @Query("SELECT * FROM todo WHERE id = :id")
    Todo get(String id);

    @Query("SELECT * FROM todo WHERE id IN (:ids)")
    List<Todo> get(List<String> ids);

    @Query("SELECT * FROM todo")
    List<Todo> getAll();
}
