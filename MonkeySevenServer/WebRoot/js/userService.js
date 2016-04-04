$(document).ready(function() {
	$("#want_complain").click(
			function(){
		   var userid=$.cookie('userid');
		   if(userid==null||userid==''){alert("请先登录！")}
		   else{location.href = "complain.html";}
			}
			);
	
	//判断本地cookie是否存在用户信息
	changeUser();
	
	// 验证手机号码是否被注册
	$("#input_phone").change(function() {
		
		$.ajax({
			type : "post",
			data : {
				mobile : $("#input_phone").val()
			},
			url : "RegisterAction_isExistMobile",
			dataType : "json",
			success : function(data) {
				if (jQuery.parseJSON(data.statusCode) == "0") {
					$("#mobiletip").text("该号码已被注册");
				} else {
					$("#mobiletip").text("该号码可以使用");
				}

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$("#mobiletip").text("服务器响应异常，请联系管理员");
			}
		});
	});

	
	// 发送验证码
	$("#test_number").click(function() {
		$.ajax({
			type : "post",
			data : {
				mobile : $("#input_phone").val()
			},
			url : "RegisterAction_sendIndentifyingCode",
		});
	});
	
	
	// 验证密码是否一阵
	$("#confirm").change(function(){
		var pwd1=$("#confirm").val();
		var pwd2=$("#password").val();
		if(pwd1!=pwd2){
			$("#pwdtip").text("密码不一致，请重新输入");
		}else{
			$("#pwdtip").text("");
		}
	});
	// 验证密码是否一阵
	$("#password").change(function(){
		var pwd1=$("#confirm").val();
		var pwd2=$("#password").val();
		if(pwd1!=pwd2){
			$("#pwdtip").text("密码不一致，请重新输入");
		}else{
			$("#pwdtip").text("");
		}
	});
	
	
	// 注册新用户
	$("#registerbtn").click(function(){
			$.ajax({
			type : "post",
			data : {
				mobile : $("#input_phone").val(),
				password:$("#password").val(),
				identifyingCode:$("#re_number").val()
			},
			url : "RegisterAction_register",
			dataType : "json",
			success : function(data) {
				var statusCode=jQuery.parseJSON(data.statusCode);
				if (statusCode == "0") {
					alert("注册成功,马上去登陆");
					$("#myModal2").modal('hide');
					$("#myModal").modal('show');
				}else if(statusCode=="1"){
					alert("该手机号码已被注册");
				}else if(statusCode=="2"){
					alert("该号码没有发送验证码");
				}else if(statusCode=="3"){
					alert("验证码出错");
				}else{
					alert("服务器响应出错，请联系管理人员");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$("#mobiletip").text("服务器响应异常，请联系管理员");
			}
		});
	});
	
	
	//用户登录
	$("#loginbypwdbtn").click(function(){
		var loginurl="LoginAction_loginByPasswordWithCookie";
		$.ajax({
			type : "post",
			data : {
				mobile : $("#input_account").val(),
				password:$("#input_paswd").val()
			},
			url :loginurl ,
			dataType : "json",
			success : function(respdata) {
				var code=jQuery.parseJSON(respdata.statusCode);
				if (code == "0") {
					var user=respdata.data;
					$.cookie('userid', user.id, { expires: 7 });
					$.cookie('username', user.name, { expires: 7 });
					$.cookie('mobile', user.mobile, { expires: 7 });
					$.cookie('sex', user.sex, { expires: 7 });
					$("#myModal").modal('hide');
					changeUser();
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

function unsign(){
	$.cookie('userid',"");
	changeUser();
	
}

	
function changeUser(){
	var userid=$.cookie('userid');
	if(userid==null||userid=="null"||userid==""){
		$("#header_li1").html("<a data-toggle='modal' data-target='#myModal'>[登录] </a>");
		$("#header_li2").html("<a data-toggle='modal' data-target='#myModa2'>[注册] </a>");
		
	}else{
		var username=$.cookie('username');
		$("#header_li1").html("<a href='document.html'>"+username+"</a>");
		$("#header_li2").html("<a href='#' onclick='unsign()'>"+"注销"+"</a>");
	}
	
	
}
