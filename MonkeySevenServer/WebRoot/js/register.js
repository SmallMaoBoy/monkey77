/**
 * 
 */
$(document).ready(function() {

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
	$("#password").change(function(){
		var pwd1=$("#confirm").val();
		var pwd2=$("#password").val();
		if(pwd1!=pwd2){
			$("#pwdtip").text("密码不一致，请重新输入");
		}else{
			$("#pwdtip").text("");
		}
	});
	
});
