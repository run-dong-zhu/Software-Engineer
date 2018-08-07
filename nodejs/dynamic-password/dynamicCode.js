function passwordGenerator() {
	var pwd = '';
	for(var i = 0; i < 6; i++) {
		var number = Math.floor(Math.random() * 10);
		pwd = pwd + number;
	}
	console.log(pwd);
	return pwd;
}

var password = passwordGenerator();

//module.exports.passwordGenerator = passwordGenerator;
module.exports.password = password;
