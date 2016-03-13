$(document).ready(function() {
	getMessageList(1);
	
	//默认情况下获取商品列表
	function getMessageList(indexPage){
		$.ajax({
			type : 'post',
			data : {
				indexPage :indexPage,
			},
			url : "MessageAction_getMessageList",
			dataType : "json",
			success : function(data) {
				
				var message=data.message;                                
				$("#user-word").empty();
				
				for(var i=0;i<message.length;i++){
					var count=data.message[i].number;
				$("#user-word").append('<tr>'+
						'<td style="text-align: center;">'+message[i].id+'</td>'+
						'<td style="text-align: center;">'+message[i].content+'</td>'+
						'<td style="text-align: center;">'+message[i].creatTime+'</td>'+
						'<td style="text-align: center;">'+message[i].contact+'</td>'+
						'</tr>');
				
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
	
	
	
})