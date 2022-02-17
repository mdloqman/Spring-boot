package com.task.controller;


import java.util.List;

import org.springframework.core.task.TaskRejectedException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.service.TaskService;
import com.task.entity.Tasks;
import com.task.repository.TasksRepository;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	private TaskService tasksservice;

	public TaskController(TaskService tasksservice) {
		super();
		this.tasksservice = tasksservice;
	}
	
	//build create employee REST API
	//http://localhost:8080/api/tasks
	@PostMapping()
	public ResponseEntity<Tasks> saveTasks(@RequestBody Tasks tasks)
	{
		return new ResponseEntity<Tasks>(tasksservice.saveTask(tasks), HttpStatus.CREATED);
	}
	
	//build 'get all tasks' REST API
	//http://localhost:8080/api/tasks
	@GetMapping()
	public List<Tasks> getAllTasks(){
		return tasksservice.getAllTasks();
	}
	
	//build 'get task by id' REST API
	//http://localhost:8080/api/tasks/1
	@GetMapping("{id}")
	public ResponseEntity<Tasks> getTasksById(@PathVariable("id")long id) // id should match id from getmapping(id)
	{
		return new ResponseEntity<Tasks>(tasksservice.getTasksById(id), HttpStatus.OK);
	}
	
	//build 'update task' REST API
	//http://localhost:8080/api/tasks/1
	@PutMapping("{id}")
	public ResponseEntity<Tasks> updateTaskById(@RequestBody Tasks task,  @PathVariable("id")long id)
	{
		
		return new ResponseEntity<Tasks>(tasksservice.updateTaskById(task, id), HttpStatus.OK);
		
	}
	
	
	//build 'delete task' REST API
	//http://localhost:8080/api/tasks/1
	//method 1
//	@DeleteMapping("{id}")
//	public void deleteTaskById(@PathVariable ("id") long id)
//	{
//		tasksservice.deleteTaskByID(id);
//	}
	//method 2
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTaskByID(@PathVariable("id") long id){
		//delete task from DB
		tasksservice.deleteTaskByID(id);
		return new ResponseEntity<String>("Task has been deleted successfully", HttpStatus.OK);
	}
}

