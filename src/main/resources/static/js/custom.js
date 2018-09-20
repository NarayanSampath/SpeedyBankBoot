$(document).ready(function() {
	$("#message").css({"visibility" : "hidden"});
	setTimeout(function() {
		$("#main-vid").css('opacity', '1');
		$("#inner-div").css('opacity', '1');
	}, 1000);
	$("#submit").click(function() {
		var data = (JSON.stringify({
			"email" : $("#email").val(),
			"password" : $("#password").val(),
			"userName" : $("#username").val()
		}));
		$.ajax({
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			url : "/register",
			data : data,
			success : function(response) {
				$("#message").css({"visibility" : "visible"});
				$("#message").html("<br><h5>Creation of Account for Email : '"+ response.email+ "'   "+ response.status+ "  -  "+ response.message+ "</h5>");
				if (response.status != "Failed") {
					setTimeout(function() { $("#message").html("<br> <h5>Redirecting to Login Page</h5>");}, 2000);
					setTimeout(function() { window.location.href = "/signin"; }, 4000)
				}else{
					setTimeout(function() {$("#message").css({"visibility" : "hidden"});}, 4000);
				}
			}
		});
	})
	$("#login").click(function() {
		var data = (JSON.stringify({
			"username" : $("#loginemail").val(),
			"password" : $("#loginpassword").val()			
		}));
		$.ajax({
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			url : "/login",
			data : JSON.stringify(data),
			success : function(response) {console.log(response);}
		});
	})
})