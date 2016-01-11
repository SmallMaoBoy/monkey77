$(document).ready(function() {
	
	/**
	 * getGoodsWay
	 * 0代表用户默认情况下查看商品的方式，
	 * 1代表搜索情况下查看商品
	 * 2代表根据分类查看商品 
	 */
	var getGoodsWay=0;
	var keyWords=null;
	$('#search-btn').click(function(){getGoodsWay=1;getGoodsByKeyWord(1,$("#search-fruit").val())});
	/**
	 * orderType
	 * 0代表按照销量从大到小获取商品
	 * 1代表按照销量从小到大获取商品
	 * 2代表按照价格从大到小获取商品
	 * 3代表按照价格从小到大获取商品
	 */
	var orderType=0;
    $('#sort0').click(function(){orderType=0;getDefalutGoods(1)});
    $('#sort1').click(function(){orderType=1;getDefalutGoods(1)});
    $('#sort2').click(function(){orderType=2;getDefalutGoods(1)});
    $('#sort3').click(function(){orderType=3;getDefalutGoods(1)});
	getDefalutGoods(1);
	
	//默认情况下获取商品列表
	function getDefalutGoods(pageIndex){
		$.ajax({
			type : 'post',
			data : {
				page :pageIndex,
				orderType:orderType
			},
			url : "GoodAction_getDefalutGoods",
			dataType : "json",
			success : function(data) {
				/*var fr_name=data.goods[3].name;
				var fr_price=data.goods[3].price;
				var specification=data.goods[3].specification;
				$("#fruit_name").text(fr_name);
				$("#fruit_price").text(fr_price);
				$("#specification").text(specification);*/
				var goods=data.goods;
				$("#content-goods").empty();
				for(var i=0;i<goods.length;i++){
					var count=data.goods[i].number;
					if(count>0){
					$("#content-goods").append('<div class="col-xs-12 col-sm-6 col-lg-3 box2">'+
    '<div class="thumbnail">'+
      '<img src="'+
      goods[i].picUrl
      +'" />'+
      '<div class="caption">'+
        '<h4 id="fruit_name">'+goods[i].name+'</h4>'+'<h5 class="volume">销量：'+goods[i].saleVolume+'</h5>'+
        '<p>¥<span id="fruit_price">'+goods[i].price+'   '+'</span >/<span id="specification">'+'   '+goods[i].specification+'</span></p>'+
        '<p><a href="http://localhost:8080/MonkeySevenServer/buy.html?id='+goods[i].id+'" class="btn btn-primary" role="button">商品详情</a> <a class="btn btn-default add_to_car" role="button" goodid="'+goods[i].id+'">加入购物车</a></p>'+
      '</div>'+
    '</div>'+
  '</div>');}
					else{
	  $("#content-goods").append('<div class="col-xs-12 col-sm-6 col-lg-3">'+
			    '<div class="thumbnail box2">'+
			      '<img src="'+
			      goods[i].picUrl
			      +'" />'+
			      '<div class="caption">'+
			        '<h4 id="fruit_name">'+goods[i].name+'</h4>'+'<h5 class="volume">销量：'+goods[i].saleVolume+'</h5>'+
			        '<p>¥<span id="fruit_price">'+goods[i].price+'   '+'</span >/<span id="specification">'+'   '+goods[i].specification+'</span></p>'+
			        '<p><a href="#" class="btn btn-danger" disabled="disabled" role="button">库存不足</a> <a class="btn btn-default" role="button" disabled="disabled">加入购物车</a></p>'+
			      '</div>'+
			    '</div>'+
			  '</div>'
  
					);}
					
				}
				if(data.count!=0){
					createPageNum(data.count/12+1,pageIndex);
				}
				
			}
		});
	}
	
	//根据分类获取商品
	function getSortGoods(pageIndex,sort){
		$.ajax({
			type : 'post',
			data : {
				page :pageIndex,
				orderType:orderType,
				sort:sort
			},
			url : "GoodAction_getSortGoods",
			dataType : "json",
			success : function(data) {
				//console.log(data.goods[1].name);
				var goods=data.goods;
				$("#content-goods").empty();
				for(var i=0;i<goods.length;i++){
					var count=data.goods[i].number;
					if(count>0){
					$("#content-goods").append('<div class="col-xs-12 col-sm-6 col-lg-3 box2">'+
    '<div class="thumbnail">'+
      '<img src="'+
      goods[i].picUrl
      +'" />'+
      '<div class="caption">'+
        '<h4 id="fruit_name">'+goods[i].name+'</h4>'+'<h5 class="volume">销量：'+goods[i].saleVolume+'</h5>'+
        '<p>¥<span id="fruit_price">'+goods[i].price+'   '+'</span >/<span id="specification">'+'   '+goods[i].specification+'</span></p>'+
        '<p><a href="buy.html" class="btn btn-primary" role="button">商品详情</a> <a class="btn btn-default add_to_car" role="button" goodid="'+goods[i].id+'">加入购物车</a></p>'+
      '</div>'+
    '</div>'+
  '</div>');}
					else{
	  $("#content-goods").append('<div class="col-xs-12 col-sm-6 col-lg-3">'+
			    '<div class="thumbnail box2">'+
			      '<img src="'+
			      goods[i].picUrl
			      +'" />'+
			      '<div class="caption">'+
			        '<h4 id="fruit_name">'+goods[i].name+'</h4>'+'<h5 class="volume">销量：'+goods[i].saleVolume+'</h5>'+
			        '<p>¥<span id="fruit_price">'+goods[i].price+'   '+'</span >/<span id="specification">'+'   '+goods[i].specification+'</span></p>'+
			        '<p><a href="#" class="btn btn-danger" disabled="disabled" role="button">库存不足</a> <a class="btn btn-default" role="button" disabled="disabled">加入购物车</a></p>'+
			      '</div>'+
			    '</div>'+
			  '</div>'
  
					);}
					
				}
				if(data.count!=0){
					createPageNum(data.count/12+1,pageIndex);
				}
 
			}
		});
	}
	
	/**根据搜索获取商品列表
	 * 搜索范围包括商品名字，商品标题，商品种类，商品产地
	 */
	
	function getGoodsByKeyWord(pageIndex,keyWords){
		$.ajax({
			type : 'post',
			data : {
				page :pageIndex,
				orderType:orderType,
				keyWords:keyWords
			},
			url : "GoodAction_getKeyWordsGoods",
			dataType : "json",
			success : function(data) {
				//console.log(data.goods[1].name);
				alert(goodid);
				var goods=data.goods;
				$("#content-goods").empty();
				if(goods.length==0){$("#content-goods").append('<div class="can_not">未找到相关商品!</div>')}
				else{
				for(var i=0;i<goods.length;i++){
					var count=data.goods[i].number;
					if(count>0){
					$("#content-goods").append('<div class="col-xs-12 col-sm-6 col-lg-3 box2">'+
    '<div class="thumbnail">'+
      '<img src="'+
      goods[i].picUrl
      +'" />'+
      '<div class="caption">'+
        '<h4 id="fruit_name">'+goods[i].name+'</h4>'+'<h5 class="volume">销量：'+goods[i].saleVolume+'</h5>'+
        '<p>¥<span id="fruit_price">'+goods[i].price+'   '+'</span >/<span id="specification">'+'   '+goods[i].specification+'</span></p>'+
        '<p><a href="buy.html" class="btn btn-primary" role="button">商品详情</a> <a class="btn btn-default add_to_car" role="button" goodid="'+goods[i].id+'">加入购物车</a></p>'+
      '</div>'+
    '</div>'+
  '</div>');}
					else{
	  $("#content-goods").append('<div class="col-xs-12 col-sm-6 col-lg-3">'+
			    '<div class="thumbnail box2">'+
			      '<img src="'+
			      goods[i].picUrl
			      +'" />'+
			      '<div class="caption">'+
			        '<h4 id="fruit_name">'+goods[i].name+'</h4>'+'<h5 class="volume">销量：'+goods[i].saleVolume+'</h5>'+
			        '<p>¥<span id="fruit_price">'+goods[i].price+'   '+'</span >/<span id="specification">'+'   '+goods[i].specification+'</span></p>'+
			        '<p><a href="#" class="btn btn-danger" disabled="disabled" role="button">库存不足</a> <a class="btn btn-default" role="button" disabled="disabled">加入购物车</a></p>'+
			      '</div>'+
			    '</div>'+
			  '</div>'
  
					);}
					
				}}//else的关闭符号
				if(data.count!=0){
					createPageNum(data.count/12+1,pageIndex);
				}
			}
		});
	}
	
	//加入购物车成功弹出框
	function showarea(){
		var con = document.getElementById("t_area");
		con.style.display = "block";
		timer=setTimeout(offarea,1000);	
		}
	function offarea(){      //dissappeared when mouse move out this div
		var con = document.getElementById("t_area");
		con.style.display = "none";
		}
	var timer;
	function show(){
		var con = document.getElementById("t_idea");
		con.style.display = "block";
		time_id=setTimeout(hide,3000);	
		}
	function hide(){      //dissappeared when mouse move out this div
		var con = document.getElementById("t_idea");
		con.style.display = "none";
		}
	var time_id;
		//加入购物车
	var userid=$.cookie("userid");
	$("#content-goods").on("click",".add_to_car",function(){
		if(userid.trim()==""){
		show();
		return false;
		}
		else{
				var goodid=$(this).attr('goodid');
				addNewCart(userid,goodid,1);
				showarea();
				getCartInfo(userid);
				return false;
		}
		
		
		
	});
	$("#content-goods").on("onMouseOut",".add_to_car",function(){
		timer=setTimeout(offarea,1000);
		clearTimeout(timer);
	});

	
	//右下角购物车总数显示
	getCartInfo(userid);
	function getCartInfo(userid){
		//alert(userid);
		$.ajax({
			type:'post',
			data:{"userId":userid},
			url:"CartAction_getCartInfo",
			dataType:"Json",
			success:function(data){
				var sum_number=0;
				var cart=data.cart;
				for(i=0;i<cart.length;i++){
				$("#test_hidden").append(cart[i].num
						);
				sum_number=cart[i].num+sum_number;
				}
				$("#num").empty();
				$("#num").append(sum_number);
			}});}

	function addNewCart(userid,goodid,num){
		$.ajax({
			type:'post',
			data:{"userId":userid,
				  "goodId":goodid,
				  "num":num
				},
			url:"CartAction_addNewCart",
			dataType:"Json",
			success:function(data){}
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
				getDefalutGoods(page);
				$('#page-switch-root').find('>li').removeClass('active');
				$(this).parent().addClass('active');
			})
	}
	
})

