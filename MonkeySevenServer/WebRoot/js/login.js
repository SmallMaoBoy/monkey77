$(document).ready(function() {
	$("#loginbypwdbtn").click(function(){
		$.ajax({
			type : "post",
			data : {
				mobile : $("#input_account").val(),
				password:$("#input_paswd").val()
			},
			url : "LoginAction_loginByPassword",
			dataType : "json",
			success : function(data) {
				var code=jQuery.parseJSON(data.statusCode);
				if (code == "0") {
					alert("登陆成功");
				}else if(code == "1"){
					alert("帐号不存在");
				}else if(code=="2"){
					alert("密码出错");
				}else{
					alert("服务器响应出错，请联系管理员");
				}
			}
		});	
	});
});