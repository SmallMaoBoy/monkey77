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
			type : "post",
			data : {
				page :pageIndex,
				orderType:orderType
			},
			url : "GoodAction_getDefalutGoods",
			dataType : "json",
			success : function(data) {
				//console.log(data.goods[1].name);
			}
		});
	}
	
	//根据分类获取商品
	function getSortGoods(pageIndex,sort){
		$.ajax({
			type : "post",
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
	
})