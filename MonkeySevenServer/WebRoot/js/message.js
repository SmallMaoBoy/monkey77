$(document).ready(function() {
	$('#btn-submit').click(function(){
		if($(".input_2").val()==''||$(".input_1").val()==''){
			alert("输入内容,或联系方式不能为空！");
		}
		else{
		var userId=$.cookie('userid');
		$.ajax({
			type : "post",
			data : {
				userId :userId,
				contact:$(".input_1").val(),
				content:$(".input_2").val()
			},
			url : "MessageAction_createMessage",
			dataType : "json",
			success : function(data) {
				alert('提交成功');
			}
		});}
	});
});