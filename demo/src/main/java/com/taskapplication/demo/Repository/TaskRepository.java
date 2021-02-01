package com.taskapplication.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taskapplication.demo.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	Task findById(int id);
	}






