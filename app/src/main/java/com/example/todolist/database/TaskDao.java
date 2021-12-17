package com.example.todolist.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todolist.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("select * from task order by priority")
    LiveData<List<Task>> loadAllTasks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(Task task);

    @Update
    void update(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("Select * from task where id =:taskId")
    LiveData<Task> loadTAskById(int taskId);

}
