
getDetail();

function getDetail() {
	//console.log(window.location.href);//주소로 보낼때 주소에 있는 값 가져오도록..
	var aValue = window.opener.document.getElementById( "titleno" ).value;
	//console.log(aValue);
    fetch("/detail?titleno="+aValue)
    .then(response => response.json())
    .then(data =>{
		const detaillist = data;
		let html = ``;
        detaillist.forEach(detail => {
            html += `<div>
                         <p><span style="font-size:10pt; border-radius: 10px 10px 10px 10px; border: 3px solid skyblue; padding: 0.3em 0.4em;"">${detail.text}</span>
                         &nbsp;
                         <button class="delbtn" onclick="javascript:delDetail('${detail.textno}','${detail.titleno}');"
                          style="font-weight:bold;font-size:8pt; border-radius: 5px 5px 5px 5px; border: 1.5px solid skyblue;background-color:rgba(0,0,0,0); color:skyblue; padding:3px;"
                          >삭제</button></p>
                     </div>`
        });

        document.querySelector("#detaillist").innerHTML = html;
        
        // 사후 호버
        $('.delbtn').hover(function(){
			console.log(this);
			$(this).css('background-color','skyblue');
			$(this).css('color','white');
		},function() {
			$(this).css('background-color','white');
			$(this).css('color','skyblue');
		});
	});
}

function delDetail(textno,titleno) {
    
    var result = confirm("정말로 삭제하시겠습니까");
    if(result){
		const requestData = { "textno": textno , "titleno": titleno };
    
	    fetch("/deldetail", {
	        method: "POST",
	        headers: {
	            "Content-Type": "application/json",
	        },
	        body: JSON.stringify(requestData),
	    })
	    
	    .then(response => console.log(response.status))
	    .then(() => getDetail());
	}
    else{return;}
    
    
}

function insdetail() {
	var aValue = window.opener.document.getElementById( "titleno" ).value;
    const requestData = { "newText": $("#new_memo").val() ,"titleno": aValue};
	console.log(requestData);
    fetch("/insdetail", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(requestData),
    })
        .then(response => console.log(response.status))
    	.then(() => getDetail())
    	.then(document.querySelector("#new_memo").value = null);
}