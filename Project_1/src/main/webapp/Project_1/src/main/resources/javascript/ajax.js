//The following is going to involve a bit of AJAX
function fetchPolkamanList(){
	let xhr = new XMLHttpRequest();
	let url ="/190401PolkamanServlet/FetchPolkamansServlet"; // this refers to
	//the fetch polkamans servlet resource
	
	let option = null;
	let ers_users = null;
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			polkamans = JSON.parse(xhr.response);
			
			console.log(ers_users);
			for(let index in ers_users){ //for each loop
				option = document.createElement("option");
				option.setAttribute("value", ers_users[index]["id"]);
				option.innerHTML=ers_users[index]["name"];
				document.getElementById("ers_userslist").appendChild(option);
			}
			document.getElementById("listdefault").innerHTML = 
				"----PICK A STARTER---";
		}
	}
	
	xhr.open("GET",url);
	xhr.send();
}

window.onload = function(){
	console.log("AJAX ready")
	Fetchers_users_servelet();
}