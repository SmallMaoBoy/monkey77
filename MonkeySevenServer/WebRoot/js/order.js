$(document).ready(function() {
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}

	// 调用方法

	var orderNo = GetQueryString("orderNo");
	var userId=$.cookie('userid');
	getOrderInfo();
	function getOrderInfo(){
		$.ajax({
			type : "post",
			data : {
				orderNo : orderNo,
				userId:userId
			},
			url : "OrderAction_getOrderInfo",
			dataType : "json",
			success : function(data) {
				var shops=data.shops;
				var goods=data.carts;
				var sum=0;
				for(var i=0;i<shops.length;i++){
					$(".address").append('<input type="radio" id="address" name="address" value="'+shops[i].id+'" />'+shops[i].name+'<br/>');
				}
				for(var i=0;i<goods.length;i++){
					sum+=goods[i].price*goods[i].num;
					$("#good-content").append(
							'<li>'+
							  '<div class="order_shop_img"> <img src="'+goods[i].picUrl+'" class="shop_img"/></div>'+
							  '<div class="order_shop_detail"><div class="detail_name">'+goods[i].name+'</div><div class="detail_price">￥'+goods[i].price+'/'+goods[i].specification+'<span>x'+goods[i].num+'</span></div></div>'+
							  '</li>'
							);
				}
				
			
				$(".line_word_price").append('￥'+sum.toFixed(2));
				$("#totalprice").append('￥'+sum.toFixed(2));
			}
		});
	}

	
	function submissionOrder(){
		var shopId=$("input[name='address']:checked").val();
		$.ajax({
			type : "post",
			data : {
				shopId :shopId,
				remark:$("#remark").val(),
				payway:"线下支付",
				orderNo:orderNo,
				userId:userId
			},
			url : "OrderAction_submissionOrder",
			dataType : "json",
			success : function(data) {
				if(data.statusCode==0){
					window.location.href="complete_none.html?orderNo="+orderNo;
				}
			}
		});
	}
	
	$(".line_word").on("click",".go-pay",function(){go()});
	function go(){
		var addr = $('input[name="address"]:checked').val(); 
		if(addr==undefined){
			alert("地址不能为空！！！")
		}
		else{submissionOrder();}
	}
});