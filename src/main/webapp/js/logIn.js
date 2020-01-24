$(function()
{
	$('#submitButton').click(logIn);
});

function logIn()
{
	var name = document.getElementById('name').value;
	var password = document.getElementById('password').value;
	
	$.ajax({
		url: "login", 
		method: "POST", 
		data: {name:name, password:password},
		dataType: "text",
		success: function(data)
		{
			if(data == "success")
				window.location = "welcome?name=" + name;
			else
				$('#errorMessage').html(data);
		},
		error:function(data){
			$('#errorMessage').html("Error messaging: " + data.responseText);
		}
	})
}