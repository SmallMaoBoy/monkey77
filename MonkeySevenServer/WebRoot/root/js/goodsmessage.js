$(document).ready(function() {
	
	var id=1;
	
	getGoodById(id);
	
	//获取商品
	function getGoodById(id){
		$.ajax({
			type : 'post',
			data : {
				id:id
			},
			url : "GoodAction_getGoodById",
			dataType : "json",
			success : function(data) {
				var productPic=data.productPic;
				var good=data.good;
				for(i=0;i<productPic.length;i++){
					var type=data.productPic[i].type;
					if(type=0){
						$("#content-goods").append.('<img src="'+productPic[i].picUrl+' " />');
					}
				}
				
				$("#message").append(
											'<h3>商品名称：'  +good.name+ '</h3>'+
											'<h3>商品描述：'  +good.title+ '</h3>'+
											'<h3>商品库存：'  +good.number+ '</h3>'+
											'<h3>商品产地：'  +good.originPlace+ '</h3>'+
											'<h3>销售程度：'  +good.status+ '</h3>'+
											'<h3>商品重量：'  +good.specification+ '</h3>'+
											'<h3>食用方法：'  +good.edibleMethod+ '</h3>'+
											'<h3>存储方法：'  +good.storage+ '</h3>'
				);
			}
		});
	}
	
	
})