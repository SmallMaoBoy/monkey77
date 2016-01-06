$(document).ready(function() {
	//获取购物车信息
	function getCartInfo(userId){
		$.ajax({
			type:'post',
			data:{},
			url:"CartAction_getCartInfo",
			dataType:"Json",
			success:function(){
				
			}
		});
	}
})