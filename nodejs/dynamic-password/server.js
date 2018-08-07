var http = require('http');
var pwd = require('./dynamicCode');

function onRequest(req, res) {
	res.writeHead(200, {'Content-Type': 'text/plain'});
	res.write(pwd.password);
	res.end();
}

http.createServer(onRequest).listen(8000);
