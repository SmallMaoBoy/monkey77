$(document).ready(function() {
	getBusinessList(1);
	
	//默认情况下获取商品列表
	function getBusinessList(indexPage){
		$.ajax({
			type : 'post',
			data : {
				indexPage :indexPage,
			},
			url : "BuyerAction_getBusinessList",
			dataType : "json",
			success : function(data) {
				var businessid;
				var business=data.business;                                
				$("#staff").empty();
				for(var i=0;i<business.length;i++){
					var count=data.business[i].number;
				$("#staff").append('<tr>'+
										'<td style="text-align: center;">'+business[i].account+'</td>'+
										'<td style="text-align: center;">'+business[i].sex+'</td>'+
										'<td style="text-align: center;">'+business[i].worklocation+'</td>'+
	'<td style="text-align: center;" >'+'<button class="btn btn-primary btn-xs" data-toggle="modal" onclick="businessid='+business[i].id+'" id="del" data-target="#myModal">删除'+
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
				getBusinessList(page);
				$('#page-switch-root').find('>li').removeClass('active');
				$(this).parent().addClass('active');
			})
	}
	
	$("#delete").click(function(){

       $.ajax({
       type : 'post',
			data : {
				id :businessid,
			},
			url : "BuyerAction_deceteBusinessById",
             success : function(data){
                 getBusinessList(1);
             }
       });
       
 			 
  
  })
	
})