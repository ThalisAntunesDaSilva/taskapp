package com.taskapplication.demo.Resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskapplication.demo.Entity.Task;
import com.taskapplication.demo.Repository.TaskRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "")

@RequestMapping(value = "/tasks")
public class TaskResource {
		
	@Autowired
	TaskRepository taskrepository;
		
		@GetMapping
	    public List<Task> listAllTasks() {
	        return taskrepository.findAll();}
	    
	 
	    @GetMapping("/task/{id}")
	    public Task listTaskById(@PathVariable(value="id") int id) {
	        return taskrepository.findById(id);

	    }
	    
	    @PostMapping("/task")
	    public Task saveTask(@RequestBody Task task){
	       return taskrepository.save(task);
	     }

	    @DeleteMapping("/task")
	    public void deleteTask(@RequestBody Task task){
	         taskrepository.delete(task); 
	    }

	    @PutMapping("/task")
	    public Task atualizaCompra(@RequestBody Task task){
	       return  taskrepository.save(task);
	    }

}
