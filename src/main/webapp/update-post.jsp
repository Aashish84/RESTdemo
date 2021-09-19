<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<script src="jquery.js"></script>
	</head>
	<body>
		<form id="form-submit" >
		    <input type="text"  name="txtname" id="name" />
		    <input type="submit" value="click" id="submit"/>
		</form><hr>
		<%
			System.out.println(request.getParameter("id"));
		%>
		<script>	
			//var xyz = <% request.getParameter("id"); %>;
    		//var xyz = $.url.attr("id");
    		//console.log(xyz);
    		var params = new window.URLSearchParams(window.location.search);
    		var id = params.get('id');
		    $(document).ready(function(){
		    	
		        $("#submit").click(function(event){
					event.preventDefault();
		            var username = $("#name").val();
		            var u = 'ctrlA/1';
		            var mydata=JSON.stringify({id:id,name:username});
		            
		            $.ajax({
		                //async :false,
		                url : u,
		                type : 'PUT',
		                data : mydata,
		                contentType: 'application/json',
		                success: function(result,status,xhr){
		                	alert(status);
		                	//window.location.replace("http://localhost:8080/demojson/ctrlA");
		                },
		                error :function(){
		                	alert("error");
		                },
		                complete: function(){
		                	window.location.replace("/demojson/view-post");
		                }
		            });
		        });
		    });
		</script>
	</body>
</html>