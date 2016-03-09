$(document).ready(function() {
	getShopList(1);
	
	//默认情况下获取商品列表
	function getShopList(indexPage){
		$.ajax({
			type : 'post',
			data : {
				indexPage :indexPage,
			},
			url : "ShopAction_getShopList",
			dataType : "json",
			success : function(data) {
				var shopid;
				var shops=data.shops;                                
				$("#shop").empty();
				for(var i=0;i<shops.length;i++){
					var count=data.shops[i].number;
				$("#shop").append('<tr>'+
						                '<td style="text-align: center;">'+i+'</td>'+
										'<td style="text-align: center;">'+shops[i].name+'</td>'+
										'<td style="text-align: center;">'+shops[i].description+'</td>'+
										'<td style="text-align: center;" >'+'<a href="shoplocaltion.html?id='+shops[i].id+'" >详情</a>'+'</td>'+
										'</tr>' );
				}
				if(data.count!=0){
					createPageNum(data.count/12+1,indexPage);
				}
				
			}
		});
	}
	/**
	 * 创建商品列表页数
	 * pageNum：总页数
	 * currentIndex:当前页数
	 */
	function createPageNum(pageNum,currentIndex){
		$("#page-switch-root").empty();
			for(var i=1;i<=pageNum;i++){
				if(i==currentIndex){
					$("#page-switch-root").append('<li class="active"><a href="javascript:;" class="i1 page-change" page="'+i+'">'+i+'</a></li>');
				}else{
					$("#page-switch-root").append('<li><a href="javascript:;" class="i1 page-change" page="'+i+'">'+i+'</a></li>');
				}
			}
			$('.page-change').click(function(){
				var page=$(this).attr('page');
				getShopList(page);
				$('#page-switch-root').find('>li').removeClass('active');
				$(this).parent().addClass('active');
			})
	}
	
	$("#delete").click(function(){

       $.ajax({
       type : 'post',
			data : {
				id :shopid,
			},
			url : "ShopAction_deceteShopById",
             success : function(data){
                 getShopList(1);
             }
       });
       
 			 
  
  })
	
})