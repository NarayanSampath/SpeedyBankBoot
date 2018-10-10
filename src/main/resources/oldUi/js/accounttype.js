$(document).ready(function() {
	getAccType();
	$("#createacctype").click(function() { createAccType(); })
	$("body").on('click','.deleteAccType',function() {deleteAccType($(this).attr("id"));})
	$("body").on('click','.updateacctype', function(){updateAccType( $(this).attr("id"));})
	
})
function createAccType() {
	var postData =  {
			"id":0,
			"typename":$("#typename").val(),
			"interestrate":$("#interestrate").val(),
			"withdrawallimit":$("#withdrawallimit").val(),
			"minimumduration":$("#minimumduration").val(),
			"minimumbalance":$("#minimumbalance").val()
			}
	$.ajax({
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		url : "/accounttype/",
		data: JSON.stringify(postData),
		success : function(response) {
			displayResponse(response);
			location.reload();
		}
	})
}
function deleteAccType(id){
	$.ajax({
		type : "DELETE",
		dataType : "json",
		contentType : "application/json",
		url : "/accounttype/"+id,
		success : function(response) {displayResponse(response);location.reload();}
	})
}
function updateAccType(id){
	var kvp = {}
	$("#acctypetbl").find("tr").each(function(){
		var curRow = this;
		if($(curRow).attr("id")==id){
			$(curRow).find("input").each(function(){
				kvp[$(this).attr("id").toLowerCase()] = $(this).val();
			})				
		}		
	})
	console.log(JSON.stringify(kvp));
	$.ajax({
		type : "PUT",
		dataType : "json",
		contentType : "application/json",
		url : "/accounttype/",
		data: JSON.stringify(kvp),
		success : function(response) {displayResponse(response);location.reload();}
	})
}
function getAccType(){
	$.ajax({
		type : "GET",
		dataType : "json",
		contentType : "application/json",
		url : "/accounttype/",
		success : function(response) {
			var str="<table id='acctypetbl' class='table table-responsive'>"
			for(key in response[0]){
				str+="<td style='text-align: center;'><b>"+key+"</b></td>"
			}str+="<td></td><td></td></tr>" 
			for(row in response){
				str+="<tr id='"+response[row]['id']+"'>";
				for(key in response[row]){
					str+="<td><input type='text' class='input-group-text'  id='"+key+"' value='"+response[row][key]+"'></td>"
				}
				str+="<td>" +
						"<div style='min-width:100px;'>" +
						"<button class='btn btn-outline-success fas fa-sync updateacctype mr-1' data-toggle='tooltip' data-placement='bottom' title='Update Current Values'   id='"+response[row]['id']+"'></button>" +
						"<button class='btn btn-outline-danger fas fa-trash-alt deleteAccType ml-1' data-toggle='tooltip' data-placement='bottom' title='Delete This Type'  id='"+response[row]['id']+"'></button>" +
						"</div></td>"+
					  "</tr>"
			}str+="</table>"
			$("#accounttypes").html(str);
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