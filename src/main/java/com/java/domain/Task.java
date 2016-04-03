package com.java.domain;

import java.util.Date;

/**
 * @author Adluru
 * 
 *Class that gives details about the task
 *
 */
public class Task {

	private int id;
	private Date dueDate;
	private boolean complete;
	private String description;
	private static int uniqueIdCounter = 0;
	
	
	
	public Task(Date dueDate, String description, boolean complete) {
		super();
		this.id = getUniqueId();
		this.dueDate = dueDate;
		this.complete = complete;
		this.description = description;
	}
	private int getUniqueId() {
		return uniqueIdCounter++;
	}
	/**
	 * @return the task id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param sets unique id for the task
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the task due date
	 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * @param sets the task due date 
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @return if task is completed or not
	 */
	public boolean isComplete() {
		return complete;
	}
	/**
	 * @param sets whether task completed or not
	 */
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	/**
	 * @return description of the task
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param stas the description of the task
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
