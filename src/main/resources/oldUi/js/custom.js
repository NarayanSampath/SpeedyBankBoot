$(document).ready(function() {
	$("#message").css({"visibility" : "hidden"});
	if(window.location.search.includes('?error')){
		$("#message").css({"visibility":"visible"});
		$("#message").html("<br><h5 style='color=black;'>"+window.location.search.split('=')[1].replace(/%20/g," ")+"<h5>");
	}
	setTimeout(function() {	$("#message").html(""); $("#message").css({"visibility":"hidden"});	}, 2000);
	//Home Page video and its text
	setTimeout(function() {	$("#main-vid").css('opacity', '1'); $("#inner-div").css('opacity', '1'); }, 1000);
	//Register Page 
	$("#submit").click(function() {
		var data = (JSON.stringify({ "email" : $("#email").val(), "password" : $("#password").val(), "userName" : $("#username").val() }));
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
					setTimeout(function() { window.location.href = "/login"; }, 4000);
				}else setTimeout(function() {$("#message").css({"visibility" : "hidden"});}, 4000);
			}
		});
	})
	$("#userdisplay").html();
})