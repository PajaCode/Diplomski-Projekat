package com.diplomski.aswebapp.repository;

import com.diplomski.aswebapp.entities.Task;
import com.diplomski.aswebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

}
