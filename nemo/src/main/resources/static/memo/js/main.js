
refresh();

function refresh() {
	$.ajax({
		url: "/chkloginid",
		success: function(data) {
			$("#loginid_span").text(data+"님");
		}
	});
	
	$.ajax({
		url: "/list",
		success: function(data) {
			var todolist = data;
			let html = ``;
			for (i=0;i<todolist.length;i++) {
				todo = todolist[i];
				html += `<div>
	                         <p><button onclick="javascript:detail('${todo.titleno}')" style="border-radius: 15px 15px 15px 0; border-bottom: 5px solid #B9C4C4; padding: 0.3em; background: #dcf1fb; border-top: 0px; border-right: 0px; border-left: 0px;">${todo.title}</button>
	                         &nbsp;
	                         <button class="delbtn" onclick="javascript:del('${todo.titleno}');"
	                         		 style="font-weight:bold;font-size:8pt; border-radius: 5px 5px 5px 5px; border: 1.5px solid skyblue;background-color:rgba(0,0,0,0); color:skyblue; padding:3px;"
	                         >삭제</button></p>
	                     </div>`;
			}
	
	        $("#todolist").html(html);
	        
	        // 사후 호버
	        $('.delbtn').hover(function(){
				//console.log(this);
				$(this).css('background-color','skyblue');
				$(this).css('color','white');
			},function() {
				$(this).css('background-color','white');
				$(this).css('color','skyblue');
			});
		}
	});
}

function ins() {
    const requestData = { "newText": $("#new_text").val() };
    
    $.ajax({
		type: 'post',
		url: '/ins',
		headers: {
			"Content-Type": "application/json"
		},
		data: JSON.stringify(requestData),
		success: function() {
			refresh();
			$("#new_text").val('');
		}
	});
}

function del(no) {
    var result = confirm("정말로 삭제하시겠습니까");
    if(result){
		const requestData = { "titleno": no };
    
	    $.ajax({
			type: 'post',
			url: '/del',
			headers: {
				"Content-Type": "application/json"
			},
			data: JSON.stringify(requestData),
			success: function() {
				refresh();
			}
		});
	}
    else{return;}
    
    
}

function logout() {
	$.ajax({
		url: "/logout",
		success: function() {
			location.replace('http://localhost:8090/login');
		}
	});
}

function detail(no) {
	var url = "memo/html/detailmemo.html"
    var name = "popup test";
    var option = "width = 500, height = 500, top = 100, left = 200, location = no"
    window.open(url, name, option);
   
    $("#titleno").val(no);        
}
