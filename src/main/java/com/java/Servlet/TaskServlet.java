package com.java.Servlet;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;
import com.java.domain.Task;
import com.java.service.TaskService;

/**
 * Form Handling Servlet
 * Most of the action for this sample is in webapp/guestbook.jsp, which displays the
 * {@link Greeting}'s. This servlet has one method
 * {@link #doPost(<#HttpServletRequest req#>, <#HttpServletResponse resp#>)} which takes the form
 * data and saves it.
 * @param <Greeting>
 */
@Controller
public class TaskServlet {

 
  
  @Autowired
	private TaskService service;
  
  @RequestMapping("/")
  public String loginPage()
  {
	  return "redirect:/html/login.html";
  }
  
  @RequestMapping("/login")
	@ResponseBody
	public List<Task> validateLogin(@RequestBody User user) {
	  System.out.println("inside validateLogin");
		 UserService userService = UserServiceFactory.getUserService();
		    User user1 = userService.getCurrentUser();  // Find out who the user is.
		    List<Task> tasks = null;
		    if (user1 != null) {
		    	 

		    	    // Run an ancestor query to ensure we see the most up-to-date
		    	    // view of the Greetings belonging to the selected Guestbook.
		    	      		tasks = ObjectifyService.ofy()
		    	          .load()
		    	          .type(Task.class) // We want only Greetings
		    	          .order("-date")       // Most recent first - date is indexed.
		    	          .limit(5)             // Only show 5 of them.
		    	          .list();
		    }
		    else 
		    	throw new RuntimeException();
		   
		
		return tasks;
	}

	
	@RequestMapping("/tasks")
	@ResponseBody
	public List<Task> getAllTasks() {
		
		List<Task> tasks = null;
		 UserService userService = UserServiceFactory.getUserService();
		    User user = userService.getCurrentUser();  // Find out who the user is.

		    if (user != null) {
		    	tasks = service.getAllTasks();
		    }
		   
		
		return tasks;
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public String addTask(@RequestBody Task task)
	{
		service.createTask(task);
		return "redirect : /html/home.html";
	}
	
}