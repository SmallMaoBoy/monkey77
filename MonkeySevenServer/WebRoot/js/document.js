function getUserInfo(){
	 var userid=$.cookie('userid');
	$.ajax({
		type : "post",
		data : {
			userId:userid
		},
		url : "UserAction_getUserInfo",
		dataType : "json",
		success : function(data) {
			$("#img1").attr("src",data.user.pic);
			$("#nickname").attr("value",data.user.name);
			if(data.user.sex==0){
				$("#sex_boy").attr("checked",true);
			}else{
				$("#sex_girl").attr("checked",true);
			}
			var arr=data.user.birthday.split("-");
			$("#biry").attr("value",arr[0]);
			$("#birm").attr("value",arr[1]);
			$("#bird").attr("value",arr[2]);
			$("#phone").attr("value",data.user.mobile);
			$("#mail").attr("value",data.user.mail);
		}
	});
}


function updateUserInfo(){
	 var userid=$.cookie('userid');
	 var sex;
	 if($("#sex_boy").attr("checked")=="checked"){
		 sex=0;
	 }else{
		 sex=1;
	 }
	 var birstr=$("#biry").attr("value")+"-"+$("#birm").attr("value")+"-"+$("#bird").attr("value");
	$.ajax({
		type : "post",
		data : {
			userId:userid,
			mobile:$("#phone").val(),
			mail:$("#mail").val(),
			name:$("#nickname").val(),
			sex:sex,
			birstr:birstr
		},
		url : "UserAction_updateUserInfo",
		dataType : "json",
		success : function(data) {
			if(data.statusCode==0){
				alert("修改成功");
			}else{
				alert("修改失败");
			}
		}
	});
}

getUserInfo();