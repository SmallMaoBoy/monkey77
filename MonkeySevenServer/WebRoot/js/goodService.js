$(document).ready(function() {
	
	/**
	 * getGoodsWay
	 * 0代表用户默认情况下查看商品的方式，
	 * 1代表搜索情况下查看商品
	 * 2代表根据分类查看商品 
	 */
	var getGoodsWay=0;
	/**
	 * orderType
	 * 0代表按照销量从大到小获取商品
	 * 1代表按照销量从小到大获取商品
	 * 2代表按照价格从大到小获取商品
	 * 3代表按照价格从小到大获取商品
	 */
	var orderType=3;
	
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
      '<img src="/MonkeySevenServer'+
      goods[i].picUrl
      +'" />'+
      '<div class="caption">'+
        '<h4 id="fruit_name">'+goods[i].name+'</h4>'+
        '<p>¥<span id="fruit_price">'+goods[i].price+'   '+'</span >/<span id="specification">'+'   '+goods[i].specification+'</span></p>'+
        '<p><a href="buy.html" class="btn btn-primary" role="button">商品详情</a> <a class="btn btn-default" role="button" onclick="ad()">加入购物车</a></p>'+
      '</div>'+
    '</div>'+
  '</div>');}
					else{
	  $("#content-goods").append('<div class="col-xs-12 col-sm-6 col-lg-3">'+
			    '<div class="thumbnail box2">'+
			      '<img src="/MonkeySevenServer'+
			      goods[i].picUrl
			      +'" />'+
			      '<div class="caption">'+
			        '<h4 id="fruit_name">'+goods[i].name+'</h4>'+
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
			}
		});
	}
	
	/**根据搜索获取商品列表
	 * 搜索范围包括商品名字，商品标题，商品种类，商品产地
	 */
	function getGoodsByKeyWord(){
		
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

