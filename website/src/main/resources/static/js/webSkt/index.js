//var url = 'ws://' + window.location.host + '/websocket/macro';
//var sock = new WebSocket(url);

var url = 'http://' + window.location.host + '/webskt/index';
var sock = new SockJS(url);

function sayMacro() {
	console.log("sending message: Macro!");
	sock.send("Macro!");
}

sock.onopen = function() {
	console.log("opening...");
	sayMacro();
}

sock.onmessage = function(e) {
	console.log("received message: " + e.data);
	setTimeout(function() {
		sayMacro();
	}, 2000);
}

sock.onclose = function() {
	console.log("closing...");
}
