package com.diplomski.aswebapp.services;

import com.diplomski.aswebapp.entities.Task;
import com.diplomski.aswebapp.entities.User;
import com.diplomski.aswebapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


    @Autowired(required = true)
    private TaskRepository taskRepository;


    public void addTask(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user){

        return taskRepository.findByUser(user);
    }

}
