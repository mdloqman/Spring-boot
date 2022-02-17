package com.task.service.impl;


import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.task.entity.Tasks;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.TasksRepository;
import com.task.service.TaskService;

@Service
public class TaskServiceimpl implements TaskService {
	private TasksRepository tasksRepository; 

	public TaskServiceimpl(TasksRepository tasksRepository) {
		super();
		this.tasksRepository = tasksRepository;
	}
	@Override
	public Tasks saveTask(Tasks task) {
		return tasksRepository.save(task);
	}
	@Override
	public List<Tasks> getAllTasks() {
		return tasksRepository.findAll();
	}
	
	@Override
	public Tasks getTasksById(long id) {
		//Optional<Tasks> task = tasksRepository.findById(id);
		//if(task.isPresent()) {
			//return task.get();
		//}
	//	else {
			//throw new ResourceNotFoundException("Tasks", "Id", id);
		//}
		//alternative method
		return tasksRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Tasks", "Id", id));
		
		
		
	}
	@Override
	public Tasks updateTaskById(Tasks task, long id) {
		//check if the task is there in database
		Tasks exsistingTask= tasksRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Task", "Id", id));
		exsistingTask.setUserName(task.getUserName());
		exsistingTask.setTask(task.getTask());
		exsistingTask.setDescription(task.getDescription());
		exsistingTask.setEnddate(task.getEnddate());
		exsistingTask.setStatus(task.isStatus());
		//save existing task to DB
		tasksRepository.save(exsistingTask);
		return exsistingTask;
	}
	
	
	@Override
	public void deleteTaskByID(long id) {
		//check if there is task with that id in DB
		tasksRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Task", "Id", id));
		tasksRepository.deleteById(id);
	}
	
	
}
