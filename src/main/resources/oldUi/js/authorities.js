$(document).ready(function() {
	getAuthorities();
	$("#createauthority").click(function() { createAuthoritiy(); })
	$("#deleteauthority").click(function() { deleteAuthoritiy(); })
	$("#updateauth").click(function() { updateUserAuthoritiy(); })
	$(document).on('change', '#users', function(e) {
		getUserAuthority(this.options[e.target.selectedIndex].id);
});	
})
function getAuthorities() {
	$.ajax({
		type : "GET",
		dataType : "json",
		contentType : "application/json",
		url : "/authorities/",
		success : function(response) {
			var str="<option id='0'>Select An Authority</option>";
			for(var authNum in response) str+="<option id='"+response[authNum]["id"]+"'>"+response[authNum]["authority"]+"</option>"
			$("#dropdownMenu").html(str);
			str='';
			for(var authNum in response) str+="<option id='"+response[authNum]["id"]+"'>"+response[authNum]["authority"]+"</option>"
			$("#authlist").html(str);			
		}
	})
	$.ajax({
		type:"GET",
		dataType:"json",
		contentType:"application/json",
		url:"/user/",
		success:function(response){
			var str=""
			str+="<table class='table table-responsive'><tr>";
			for(key in response[0]){ str+="<td><b>"+key+"</b></td>"	}
			str+="</tr>";
			for(var i in response){
				str+="<tr>";
				for(key in response[i]) str+="<td><input type='text' id='"+response[i]["id"]+key+"' value='"+response[i][key]+"'></td>"					
				$("#userslist").append("<option id='"+response[i]["id"]+"'>"+response[i]["email"]+"</option")
				$("#users").append("<option id='"+response[i]["id"]+"'>"+response[i]["email"]+"</option")
			}
			str+="</tr></table>"
			$("#userdisplay").html(str);
		}
	})
}
function createAuthoritiy() {
	$.ajax({
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		url : "/authorities/",
		data: JSON.stringify({"authority":$("#authorityname").val()}),
		success : function(response) {displayResponse(response);location.reload();}
	})
}
function deleteAuthoritiy(){
	$.ajax({
		type : "DELETE",
		dataType : "json",
		contentType : "application/json",
		url : "/authorities/",
		data: JSON.stringify({"id":$("#dropdownMenu").find('option:selected').attr('id'),"authority":$("#authorityname").val()}),
		success : function(response) {displayResponse(response);location.reload();}
	})
}
function updateUserAuthoritiy(){
	users=[]; auths=[];
	$("#userslist option:selected").each(function(){users.push($(this).attr("id"))});
	$("#authlist option:selected").each(function(){auths.push($(this).attr("id"))});
	if(users.length > 0 && auths.length > 0){
		var update_auth={"userIds":users,"authorityIds":auths};
		console.log(update_auth);
		$.ajax({
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			url : "/user/authority",
			data: JSON.stringify(update_auth),
			success : function(response) {displayResponse(response);location.reload();}
		})
	}else{
		alert("Update should have atleast one User and one Authority");
	}
}
function getUserAuthority(id){
	$.ajax({
		type : "GET",
		dataType : "json",
		contentType : "application/json",
		url : "/user/"+id,
		success : function(response) {
			str=""
			for(var index in response) str+="<option id='"+response[index]["id"]+"'>"+response[index]["authority"]+"</option>"
			$("#auths").html(str)
		}
	})
}
function displayResponse(response){
	str="-"
	for(key in response){
		str+=response[key]+'-'
	}
	alert(str);
}