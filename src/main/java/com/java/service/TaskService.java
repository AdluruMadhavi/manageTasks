package com.java.service;

import java.util.Date;
import java.util.List;

import com.java.domain.Task;

public interface TaskService {
	
	public void createTask(String description,Date dueDate);
	public void updateTask(String description,Date dueDate,boolean status);
	public void markStatus(boolean status);
	public Task getTask(int id);
	public List<Task> getAllTasks();
	

}
