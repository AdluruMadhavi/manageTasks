$(document).ready(
		function() {

			$('#login').one(
					'click',
					function() {
						var loginData = JSON.stringify($(document.loginForm)
								.serializeObject());

						var username = $('#username').val();
						console.log("UserName from Login Form = " + username);
						var password = $('#password').val();
						console.log("Password from Login Form = " + password);
						$.ajax({
							type : 'POST',
							url : 'http://localhost:8080/managetasks/login',
							data : loginData,
							contentType : "application/json",
							dataType : 'json',
							//
							success : function() {
								console.log("Was in Success Block");
								
								$.getJSON('tasks.json', function(responseData) {
									var allTasks = responseData;
									$.each(allTasks, function(index, task) {

										$("#Table").append(
												"<tr>" + "<td>"
														+ (task.description)
														+ "</td>" + "<td>"
														+ (task.dueDate)
														+ "</td>" + "<td>"
														+ (task.completed)
														+ "</td>" + "</tr>");

									});
								});
								//window.location.href = "home.html";
							}

						});

					});
			$('#submit').one(
					'click',
					function() {
						var taskData = JSON.stringify($(document.tasksForm)
								.serializeObject());

						var description = $('#description').val();
						var dueDate = $('#dueDate').val();
						var complete = $('#complete').val();
						$.ajax({
							type : 'POST',
							url : '',
							data : taskData,
							contentType : "application/json",
							dataType : 'json',
							//
							success : function() {
								console.log("Was in Success Block");
								window.location.href = "home.html";
							}

						});

					});

		});// document.ready ends

$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};