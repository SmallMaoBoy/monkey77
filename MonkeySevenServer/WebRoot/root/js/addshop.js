$(document).ready(function() {
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.400244,39.92556);
	map.centerAndZoom(point, 12);
	var marker = new BMap.Marker(point);// 创建标注
	map.addOverlay(marker);             // 将标注添加到地图中
	marker.enableDragging();           // 不可拖拽
	map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

	
     $("#sure").click(function(){
    	$.ajax({
    		type:'post',
    	    data:{
    	    	name:$("#name").val(),
    	        description:$("#description").val(),
    	       	lat:marker.getPosition().lng,
    	        lng:marker.getPosition().lat,
    	    },
    	    dataType : "json",
    	url: "ShopAction_createShop",
    	});
   })
})