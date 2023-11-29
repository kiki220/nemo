
refresh();

function refresh() {
	fetch("/chkloginid")
    .then(response => response.text())
    .then(data =>{
		$("#loginid_span").text(data+"님");
	});
	
    fetch("/list")
    .then(response => response.json())
    .then(data =>{
		const todolist = data;
		let html = ``;
        todolist.forEach(todo => {
            html += `<div>
                         <p><button onclick="javascript:detail('${todo.titleno}')" style="border-radius: 15px 15px 15px 0; border-bottom: 5px solid #B9C4C4; padding: 0.3em; background: #dcf1fb; border-top: 0px; border-right: 0px; border-left: 0px;">${todo.title}</button>
                         &nbsp;
                         <button class="delbtn" Sonclick="javascript:del('${todo.titleno}');"
                         		 style="font-weight:bold;font-size:8pt; border-radius: 5px 5px 5px 5px; border: 1.5px solid skyblue;background-color:rgba(0,0,0,0); color:skyblue; padding:3px;"
                         >삭제</button></p>
                     </div>`
        });

        document.querySelector("#todolist").innerHTML = html;
        
        // 사후 호버
        $('.delbtn').hover(function(){
			console.log(this);
			$(this).css('background-color','skyblue');
			$(this).css('color','white');
		},function() {
			$(this).css('background-color','white');
			$(this).css('color','skyblue');
		});
		
		//document.querySelector("#whologin").innerText = todolist[0].userid;
	});
}

function ins() {
    const requestData = { "newText": $("#new_text").val() };

    fetch("/ins", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(requestData),
    })
        .then(response => console.log(response.status))
    	.then(() => refresh())
    	.then(document.querySelector("#new_text").value = null);
}

function del(no) {
    console.log(no);
    
    var result = confirm("정말로 삭제하시겠습니까");
    if(result){
		const requestData = { "titleno": no };
    
	    fetch("/del", {
	        method: "POST",
	        headers: {
	            "Content-Type": "application/json",
	        },
	        body: JSON.stringify(requestData),
	    })
	    
	    .then(response => console.log(response.status))
	    .then(() => refresh());
	}
    else{return;}
    
    
}

function logout() {
	fetch('/logout')
	.then(()=>location.replace('http://localhost:8090/login'));
}

function detail(no) {
	var url = "detailmemo.html"//?no="+no;
	console.log(url);
    var name = "popup test";
    var option = "width = 500, height = 500, top = 100, left = 200, location = no"
    window.open(url, name, option);
   
    $("#titleno").val(no);        
    
}
