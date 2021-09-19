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
		<button id="click-me">hello</button><hr/>
		
		<table id="data" border="1">
			<tr></tr>
		</table>
		
		<script>
			function isJson(str) {
			    try {
			        JSON.parse(str);
			    } catch (e) {
			        return false;
			    }
			    return true;
			}
	
		$(document).ready(function(){
			//$("#click-me").click(function(){
				
				$("#data tr").remove();
				
				$.ajax({
					
					url:'http://localhost:8080/demojson/ctrlA',
					type : 'GET',
					
					success:function (response,status,xhr){
						console.log(response);
						$(response).each(function(i){
							console.log(response[i]);
							if(isJson(response[i])){
								console.log("yes");
								ob =$.parseJSON((response[i]));
								console.log(ob["name"]);
								btn = "<button class='update' value="+ob["id"]+">update</button>";
								$("#data").append(
										"<tr>"+
											"<td>"+ob["name"]+"</td>"
											+"<td>"+btn+"</td>"
										+"</tr>"
										);
							}
						});
					},error: function(){
						console.log("error");
					}
				});
			//});
		});
		
			//$(".update").click(function(){
			//If the game pieces are added after the page load (i.e. by clicking a button) you need to use event delegation by using jquery .on()
			$(document).on('click','.update', function(){
				//window.location.replace("/demojson/update-post/"+$(this).val());
				window.location.replace("/demojson/update-post/2");
				//alert($(this).html());
			});
	</script>
	</body>
</html>