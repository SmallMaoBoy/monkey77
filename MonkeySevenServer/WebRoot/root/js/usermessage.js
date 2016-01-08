$(document).ready(function() {
	getUserList(1);
	
	//默认情况下获取商品列表
	function getUserList(indexPage){
		$.ajax({
			type : 'post',
			data : {
				indexPage :indexPage,
			},
			url : "UserAction_getUserList",
			dataType : "json",
			success : function(data) {
			
				var users=data.users;
				$("#user-message").empty();
				for(var i=0;i<users.length;i++){
					var count=data.users[i].number;
				$("#user-message").append('<tr>'+
												'<td style="text-align: center;">'+users[i].name+'</td>'+
												'<td style="text-align: center;">'+users[i].sex+'</td>'+
												'<td style="text-align: center;">'+users[i].mobile+'</td>'+
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
				getUserList(page);
				$('#page-switch-root').find('>li').removeClass('active');
				$(this).parent().addClass('active');
			})
	}
	
	
	
})