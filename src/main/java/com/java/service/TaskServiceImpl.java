package com.java.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.domain.Task;

public class TaskServiceImpl implements TaskService {

	public void createTask(String description,Date dueDate) {
		Task task = new Task(dueDate,description,false); 
	}

	public void updateTask(String description,Date dueDate,boolean status) {
	
	}

	public void markStatus(boolean status) {
		// TODO Auto-generated method stub

	}

	public Task getTask(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Task> getAllTasks(){
		List<Task> tasks = new ArrayList<Task>();
		
		return tasks;
	}
}
