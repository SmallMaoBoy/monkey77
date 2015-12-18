/**
 * 
 */
$(document).ready(function() {

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

	$("#test_number").click(function() {
		$.ajax({
			type : "post",
			data : {
				mobile : $("#input_phone").val()
			},
			url : "RegisterAction_sendIndentifyingCode",
		});
	})
});
