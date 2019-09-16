/**
 * 
 */

const log = console.log;

jQuery(function () { 

	login();
	join();
});

function login() {
	$("#login").click( function() {
		window.open("login.html", "Log-in", "width=350,height=350");
		
	})
	
}

function join() {
	$("#join").click( function() {
		window.open("join.html", "Join", "width=400,height=400");
	})
}
