// JavaScript Document
// 修改提取点店员的模态框
$(document).ready(function(e) {
	var currentOrder;
    $('.cgorder').click(function(){
		currentOrder=$(this).attr('orderID');
		$('#myModal').modal('show')
	})
	$(".tijiao").click(function () {
		var value=$("#shuju").val();
		
		 $.post("/MonkeySevenServer/kung/changeoporderstatus", { status:value ,id:currentOrder },function(data){
     if(data.result==0){ alert("修改失败！"); }
	 else { window.location.reload();  }
   } ); 
		 });
      
    
});

//修改采购员订单的模态框
$(document).ready(function(e) {
	var currentOrder;
	
    $('.cgbuyorder').click(function(){
		currentOrder=$(this).attr('buyorderID');
		$('#myModal').modal('show')
	})
	$(".tijiao1").click(function () {
		var value=$("#shuju1").val();
		 $.post("/MonkeySevenServer/kung/changebuyorderstatus", { status:value ,id:currentOrder },function(data){
     if(data.result==0){ alert("修改失败！"); }
	 else { window.location.reload();  }
   } ); 
		 });
      
    
});

//修改采购员订单商品种类的模态框
$(document).ready(function(e) {
	var currentGood;
    $('.cggood').click(function(){
    	currentGood=$(this).attr('ordergoodID');
		$('#myModal2').modal('show')
	})
	$(".tijiao2").click(function () {
		var value=$("#shuju2").val();
		
		 $.post("/MonkeySevenServer/kung/changeordergood", { good:value ,id:currentGood },function(data){
     if(data.result==0){ alert("修改失败！"); }
	 else { window.location.reload();  }
   } ); 
		 });
      
    
});