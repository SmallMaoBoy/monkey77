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


//修改采购员订单列表 买入价格 的模态框
$(document).ready(function(e) {
	var currentbuyinprice;
    $('.cgbuyinprice').click(function(){
    	currentbuyinprice=$(this).attr('buyinpriceID');
		$('#myModal3').modal('show')
	})
	$(".tijiao3").click(function () {
		var value=$("#shuju3").val();
		
		 $.post("/MonkeySevenServer/kung/changebuyinprice", { buyinprice:value ,id:currentbuyinprice },function(data){
     if(data.result==0){ alert("修改失败！"); }
	 else { window.location.reload();  }
   } ); 
		 });
      
    
});


//修改商品价格的模态框
$(document).ready(function(e) {
	var currentgoodprice;
    $('.cggoodprice').click(function(){
    	currentgoodprice=$(this).attr('goodpriceID');
		$('#myModal4').modal('show')
	})
	$(".tijiao4").click(function () {
		var value=$("#shuju4").val();
		
		 $.post("/MonkeySevenServer/kung/changegoodprice", { price:value ,id:currentgoodprice },function(data){
     if(data.result==0){ alert("修改失败！"); }
	 else { window.location.reload();  }
   } ); 
		 });
      
    
});


//修改商品数量的模态框
$(document).ready(function(e) {
	var currentgoodnumber;
    $('.cggoodnumber').click(function(){
    	currentgoodnumber=$(this).attr('goodnumberID');
		$('#myModal5').modal('show')
	})
	$(".tijiao5").click(function () {
		var value=$("#shuju5").val();
		
		 $.post("/MonkeySevenServer/kung/changegoodnumber", { number:value ,id:currentgoodnumber },function(data){
     if(data.result==0){ alert("修改失败！"); }
	 else { window.location.reload();  }
   } ); 
		 });
      
    
});
