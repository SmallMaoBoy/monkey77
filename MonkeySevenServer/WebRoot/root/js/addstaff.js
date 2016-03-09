$(document).ready(function(){
    $("#sure").click(function(){
   	$.ajax({
   		type:'post',
   	    data:{
   	    	account:$("#account").val(),
   	        sex:$("#sex").val(),
   	       	worklocation:$("#worklocation").val(),
   	        password:$("#pwd").val(),
   	    },
   	 url: "BuyerAction_createBusiness",
     dataType : "json",
   	
   	});
  });
    
    
    $("#yes").click(function(){
   	$.ajax({
   		type:'post',
   	    data:{
   	    	
   	    	name:$("#name").val(),
   	        sex:$("#sex1").val(),
   	       	worklocation:$("#worklocation1").val(),
   	        password:$("#pwd1").val(),
   	        account:$("#account1").val(),
   	    },
   	   
   		url: "BuyerAction_createBuyer",
   	 dataType : "json",
   	});
  });

})

