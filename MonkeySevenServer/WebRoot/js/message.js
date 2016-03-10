$(document).ready(function() {
	$('#btn-submit').click(function(){
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
		});
	});
});