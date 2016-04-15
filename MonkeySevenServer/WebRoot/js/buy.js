$(document).ready(function() {

	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	
	var id=GetQueryString("id");
	getGoodById(id);
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
				$("#change_img").empty();
				$("#detailimg").empty();
				for(var i=0;i<productPic.length;i++){
					if(productPic[i].type==0){
						$("#change_img").append(
								'<li data-thumb="'+productPic[i].picUrl+'">'+
								'<img src="'+productPic[i].picUrl+'">'+
								'</li>'
						);
					}else{
						$("#detailimg").append(
								'<img width="100%" src="'+productPic[i].picUrl+'"/>'
						);
					}
				}
			    $(".flexslider").flexslider();
			    $("#good_name").text(good.name);
			    $("#good_place").text(good.originPlace);
			    $("#sum_price1").text((good.price+0.99).toFixed(2));
			    $("#sum_price2").val(good.price);
			    $("#specification").text(good.specification);
			    $("#status").text(good.status);
			    $("#title").text(good.title);
				}
				});
		}
	});