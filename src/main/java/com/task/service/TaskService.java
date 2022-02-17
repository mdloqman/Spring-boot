package com.task.service;
import java.util.List;


import com.task.entity.*;
public interface TaskService {
	Tasks saveTask(Tasks task);
	List<Tasks> getAllTasks();
	Tasks getTasksById(long id);
	Tasks updateTaskById(Tasks task, long id);
	void deleteTaskByID(long id);
}
