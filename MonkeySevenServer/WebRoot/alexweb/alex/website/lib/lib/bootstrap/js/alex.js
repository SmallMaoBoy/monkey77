// JavaScript Document
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