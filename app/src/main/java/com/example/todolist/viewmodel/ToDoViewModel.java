package com.example.todolist.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todolist.database.AppDatabase;
import com.example.todolist.model.TaskEntry;
import com.example.todolist.repo.Repository

import java.util.List;


public class ToDoViewModel extends AndroidViewModel {

    Repository repository;

    private  LiveData<List<TaskEntry>> tasks;

    private MutableLiveData<Boolean> _showSnackBarEvent =new MutableLiveData<>();
    public LiveData<Boolean>showSnackBarEvent()
    {
        return _showSnackBarEvent;
    }
    public void doneShowSnackBarEvent()
    {
        _showSnackBarEvent.setValue(false);
    }

    public ToDoViewModel(Application application){
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
        repository = new Repository(database);
        tasks = repository.getTasks();
    }

    public LiveData<List<TaskEntry>> getTasks(){
        return tasks;
    }

    public void deleteTask(TaskEntry task)
    {
        repository.deleteTask(task);
        _showSnackBarEvent.setValue(true);
    }
    public void update(TaskEntry task)
    {
        repository.updateTask(task);
        _showSnackBarEvent.setValue(true);
    }
}
