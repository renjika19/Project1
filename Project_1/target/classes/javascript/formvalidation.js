/*
 * We will be performing front end validation.
 * NOTE: Front end validation is never enough
 * It is purely to help the end user and prevent needless server hits
 */
let error = null;
let errorId = null;
let usernameTaken = false;
function validateRegistration(){
	let ers_username = document.forms["register"]["username"].value;
	let password1 = document.forms["register"]["password1"].value;
	let password2 = document.forms["register"]["password2"].value;
	let name = document.forms["register"]["name"].value;
	
	if(errorId != null){
		document.getElementById("error").remove();
		errorId = null;
	}
	
	if(usernameTaken){
		error = document.createElement("div");
		error.setAttribute("class","alert alert-danger");
		error.setAttribute("id","error");
		errorId = "error";
		error.innerHTML = "USERNAME TAKEN";
		document.getElementById("errorDiv").appendChild(error);
		return false;
		}
	if(pass1!=pass2){
		error = document.createElement("div");
		error.setAttribute("class","alert alert-danger");
		error.setAttribute("id","error");
		errorId = "error";
		error.innerHTML = "PASSWORDS DID NOT MATCH CORRECTLY";
		document.getElementById("errorDiv").appendChild(error);
		return false;
		
	}
	return true;
}
	function validateUsername(){
		let username = document.forms["register"]["username"].value;
		if(username.length>2){
			let xhr = new XMLHttpRequest();
			let url = "/Project_1/ConfirmLoginAJAX";
			
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.response == "USERNAME TAKEN"){
						usernameTaken = true;
					}else{
						usernameTaken = false;
					}
				}
			}
			
			xhr.open("POST",url);
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhr.send("username="+username);
			
		}
	}