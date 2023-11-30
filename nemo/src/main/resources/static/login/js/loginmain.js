function login() {
	const requestData = { "userid": $("#userid").val(),"password": $("#password").val() };
	
	$.ajax({
		type: 'post',
		url: '/login',
		headers: {
			"Content-Type": "application/json"
		},
		data: JSON.stringify(requestData),
		success: function(data) {
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
		}
	});
}
