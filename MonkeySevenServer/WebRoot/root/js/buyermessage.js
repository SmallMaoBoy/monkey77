$(document).ready(function() {
	getBuyerList(1);
	
	//默认情况下获取商品列表
	function getBuyerList(indexPage){
		$.ajax({
			type : 'post',
			data : {
				indexPage :indexPage,
			},
			url : "BuyerAction_getBuyerList",
			dataType : "json",
			success : function(data) {
				var buyerid;
				var buyer=data.buyer;                                
				$("#buyer").empty();
				for(var i=0;i<buyer.length;i++){
					var count=data.buyer[i].number;
				$("#buyer").append('<tr>'+
										'<td style="text-align: center;">'+buyer[i].name+'</td>'+
										'<td style="text-align: center;">'+buyer[i].sex+'</td>'+
										'<td style="text-align: center;">'+buyer[i].worklocation+'</td>'+
	'<td style="text-align: center;" >'+'<button class="btn btn-primary btn-xs" data-toggle="modal" onclick="buyerid='+buyer[i].id+'" id="del" data-target="#myModal">删除'+
										'</button>'+'</td>'+
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
				getBuyerList(page);
				$('#page-switch-root').find('>li').removeClass('active');
				$(this).parent().addClass('active');
			})
	}
	
	$("#delete").click(function(){

       $.ajax({
       type : 'post',
			data : {
				id :buyerid,
			},
			url : "BuyerAction_deceteBuyerById",
             success : function(data){
                 getBuyerList(1);
             }
       });
       
 			 
  
  })
	
})