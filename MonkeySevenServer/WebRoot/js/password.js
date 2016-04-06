$(document).ready(function(){
	
	var userId=$.cookie('userid');
	var name=$.cookie('username');
	
	function initData(){
		$(".ad_name").attr("value",name);
		$("#apassword").change(function(){
				$.ajax({
					type : "post",
					data : {
						password : $("#apassword").val(),
						userId:userId
					},
					url : "UserAction_checkPassword",
					dataType : "json",
					success : function(data) {
						if(data.statusCode==0){
							$("#passtip").text("原密码正确");
						}else{
							$("#passtip").text("原密码错误");
						}
					}
				});
		});
		
		$("#btn-submit").click(function(){
			if($("#userPw1").val()!=$("#userPw2").val()){
				alert('密码不一致');
			}else{
				$.ajax({
					type : "post",
					data : {
						password : $("#apassword").val(),
						newPassword:$("#userPw1").val(),
						userId:userId
					},
					url : "UserAction_updatePasswordByUserId",
					dataType : "json",
					success : function(data) {
						if(data.statusCode==0){
							alert('修改成功');
						}else{
							alert('修改失败');
						}
					}
				});
			}
		});
	}
	
	initData();
});