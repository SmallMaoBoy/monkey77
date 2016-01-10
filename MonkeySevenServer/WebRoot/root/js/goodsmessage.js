$(document).ready(function() {
	//获取id
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	 
	// 调用方法
	
	var id=GetQueryString("id");
	
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
				$(" #item1").append(	'<img src="../'+productPic[0].picUrl+' " style="width:1200px; height: 300px; ">'	);
			    $(" #item2").append(	'<img src="../'+productPic[1].picUrl+' " style="width:1200px; height: 300px; ">'	);							
				$(" #item3").append(	'<img src="../'+productPic[2].picUrl+' " style="width:1200px; height: 300px; ">'	);		
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
				$("#pic").append('<img src="../'+productPic[3].picUrl+'" style="width:1200px;  ">'+
								'<img src="../'+productPic[4].picUrl+'" style="width:1200px;  ">'+
								'<img src="../'+productPic[5].picUrl+'" style="width:1200px;  ">'+
								'<img src="../'+productPic[6].picUrl+'" style="width:1200px; ">'
				
				);
			
			}
		});
	}
	
	
})