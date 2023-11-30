function login() {
	const requestData = { "userid": $("#userid").val(),"password": $("#password").val() };
	

    fetch("/login",{
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(requestData),
	})
    .then(response => response.text())
    .then(data => {
		var loginyn = data;

		if(loginyn == 'Y'){
			var link = 'http://localhost:8090/';
			location.replace(link);
		}
		else{
			alert("로그인정보가 존재하지 않습니다.");
			$("#password").val('');
			return;
		}
	});
}
