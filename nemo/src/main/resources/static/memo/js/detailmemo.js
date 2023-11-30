
getDetail();

function getDetail() {
	var aValue = window.opener.document.getElementById( "titleno" ).value;
	
	$.ajax({
		url: "/detail?titleno="+aValue,
		success: function(data) {
			var detaillist = data;
			var html = ``;
			
			for (i=0;i<detaillist.length;i++) {
				var detail = detaillist[i];
				
				html += `<div>
	                         <p><span style="font-size:10pt; border-radius: 10px 10px 10px 10px; border: 3px solid skyblue; padding: 0.3em 0.4em;"">${detail.text}</span>
	                         &nbsp;
	                         <button class="delbtn" onclick="javascript:delDetail('${detail.textno}','${detail.titleno}');"
	                          style="font-weight:bold;font-size:8pt; border-radius: 5px 5px 5px 5px; border: 1.5px solid skyblue;background-color:rgba(0,0,0,0); color:skyblue; padding:3px;"
	                          >삭제</button></p>
	                     </div>`;
			}
	
	        $("#detaillist").html(html);
	        
	        // 사후 호버
	        $('.delbtn').hover(function(){
				$(this).css('background-color','skyblue');
				$(this).css('color','white');
			},function() {
				$(this).css('background-color','white');
				$(this).css('color','skyblue');
			});
		}
	});
}

function delDetail(textno,titleno) {
    
    var result = confirm("정말로 삭제하시겠습니까");
    if(result){
		const requestData = { "textno": textno , "titleno": titleno };
    
	    $.ajax({
			type: 'post',
			url: '/deldetail',
			headers: {
				"Content-Type": "application/json"
			},
			data: JSON.stringify(requestData),
			success: function() {
				getDetail();
			}
		});
	}
    else{return;}
    
    
}

function insdetail() {
	var aValue = window.opener.document.getElementById( "titleno" ).value;
    const requestData = { "newText": $("#new_memo").val() ,"titleno": aValue};
	
    $.ajax({
		type: 'post',
		url: '/insdetail',
		headers: {
			"Content-Type": "application/json"
		},
		data: JSON.stringify(requestData),
		success: function() {
			getDetail();
			$('#new_memo').val('');
		}
	});
}