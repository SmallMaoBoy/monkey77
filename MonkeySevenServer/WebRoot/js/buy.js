$(document).ready(function() {

	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	
	var id=GetQueryString("id");
	getGoodById(1);
	function getGoodById(id){
		$.ajax({
			type : 'post',
			data : {
				"id":id
			},
			url : "GoodAction_getGoodById",
			dataType : "json",
			success : function(data) {
				var productPic=data.productPic;
				var good=data.good;
				$("#change_img").empty();
				$("#change_img").append(
						'<div class="single-top-left" >'+
						'<div class="flexslider" style="height:380px; width:380px;">'+
						  '<ul class="slides">'+
							'<li data-thumb="'+productPic[0].picUrl+'">'+
								'<img src="'+productPic[0].picUrl+'" />'+
							'</li>'+
							'<li data-thumb="'+productPic[1].picUrl+'">'+
								'<img src="'+productPic[1].picUrl+'" />'+
							'</li>'+
							'<li data-thumb="'+productPic[2].picUrl+'">'+
								'<img src="'+productPic[2].picUrl+'" />'+
							'</li>'+
							'<li data-thumb="'+productPic[3].picUrl+'">'+
								'<img src="'+productPic[3].picUrl+'" />'+
							'</li>'+
								'</ul>'+
						'</div>'+
                        
                   '</div><!--结束1-->'
				);
				}
				});
		}
	});