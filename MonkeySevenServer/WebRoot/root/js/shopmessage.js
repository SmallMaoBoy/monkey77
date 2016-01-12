$(document).ready(function() {
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	 
	// 调用方法
	
	var id=GetQueryString("id");
	getShopById(id);
	function getShopById(id){
		$.ajax({
			type : 'post',
			data : {
				id:id
				
			},
			url : "ShopAction_getShopById",
			dataType : "json",
			success : function(data) {
				var shop=data.shop;
				var map = new BMap.Map("allmap");
				var point = new BMap.Point(shop.lat,shop.lng);				
				var marker = new BMap.Marker(point);// 创建标注
				map.addOverlay(marker);             // 将标注添加到地图中
				map.centerAndZoom(point, 12);
				map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
				map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
				var opts = {
						  width : 200,     // 信息窗口宽度
						  height: 100,     // 信息窗口高度
						  title : shop.name, // 信息窗口标题
						  enableMessage:true,//设置允许信息窗发送短息
						}
						var infoWindow = new BMap.InfoWindow(shop.description, opts);  // 创建信息窗口对象 
						marker.addEventListener("click", function(){          
							map.openInfoWindow(infoWindow,point); //开启信息窗口
						});
				
				}
		});
	}
	
})