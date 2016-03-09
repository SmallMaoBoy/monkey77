$(document)
		.ready(
				function() {
					var userid = $.cookie("userid");
					//创建订单
					
					// 获取购物车信息
					function getCartInfo(id) {
						$
								.ajax({
									type : 'post',
									data : {
										"userId" : id
									},
									url : "CartAction_getCartInfo",
									dataType : "Json",
									success : function(data) {
										var cart = data.cart;
										$("#content-shopping").empty();
										$("#in_all").empty();
										$("#content-shopping")
												.append(
														'<tr class="sp_2">'
																+ '<td style=" margin-left:20px">图片</td>'
																+ '<td>商品</td>'
																+ '<td>规格</td>'
																+ '<td>价格</td>'
																+ '<td>数量</td>'
																+ '<td>小计</td>'
																+ '<td>操作</td></tr>');
										var sum_number = 0;
										var sum_price = 0
										for (i = 0; i < cart.length; i++) {
											$("#content-shopping")
													.append(
															'<tr><td > <img src="'
																	+ cart[i].picUrl
																	+ '" class="sp_img"/></td>'
																	+ '<td>'
																	+ cart[i].name
																	+ '</td>'
																	+ '<td>'
																	+ cart[i].specification
																	+ '</td>'
																	+ '<td>￥'
																	+ cart[i].price
																	+ '</td>'
																	+ '<td><div class="count">'
																	+ '<span><img src="imgs/bag_close.gif" class="a-d-btn reduce_img" goodid="'
																	+ cart[i].goodId
																	+ '"></span>'
																	+ '<div class="num-btn">'
																	+ cart[i].num
																	+ '</div>'
																	+ '<span><img src="imgs/bag_open.gif" class="a-d-btn add_img" goodid="'
																	+ cart[i].goodId
																	+ '"></span>'
																	+ '</div></td>'
																	+ '<td>￥'
																	+ cart[i].totalPrice
																	+ '</td>'
																	+ '<td><a href="#">删除</a></td></tr>');
											sum_number = cart[i].num
													+ sum_number;
											sum_price = cart[i].num
													* cart[i].price + sum_price;
										}
										$("#in_all")
												.append(

														'<div class="all_display">'
																+ '<span class="style1">已选择<em class="style2">'
																+ sum_number
																+ '件</em>'
																+ '商品&nbsp; | &nbsp;订单金额</span>'
																+ '<span class="style2">￥'
																+ sum_price
																+ '</span>'
																+ '<a id="btngopay" class="go-pay">去结算</a>'
																+ '</div><!-- all_display -->'

												);
									}
								});
					}
					getCartInfo(userid);
					$("#content-shopping").on("click", ".reduce_img",
							function() {
								var goodid = $(this).attr('goodid');
								delCart(userid, 1, goodid)
							});
					$("#content-shopping").on("click", ".add_img", function() {
						var goodid = $(this).attr('goodid');
						addOldCart(userid, 1, goodid);

					});

					function delCart(userid, num, goodid) {
						$
								.ajax({
									type : 'post',
									data : {
										"userId" : userid,
										"goodId" : goodid,
										"num" : num
									},
									url : "CartAction_delCart",
									dataType : "Json",
									success : function(data) {
										var cart = data.cart;
										$("#content-shopping").empty();
										$("#in_all").empty();
										$("#content-shopping")
												.append(
														'<tr class="sp_2">'
																+ '<td style=" margin-left:20px">图片</td>'
																+ '<td>商品</td>'
																+ '<td>规格</td>'
																+ '<td>价格</td>'
																+ '<td>数量</td>'
																+ '<td>小计</td>'
																+ '<td>操作</td></tr>');
										var sum_number = 0;
										var sum_price = 0
										for (i = 0; i < cart.length; i++) {
											if (cart[i].num > 0) {
												$("#content-shopping")
														.append(
																'<tr><td > <img src="'
																		+ cart[i].picUrl
																		+ '" class="sp_img"/></td>'
																		+ '<td>'
																		+ cart[i].name
																		+ '</td>'
																		+ '<td>'
																		+ cart[i].specification
																		+ '</td>'
																		+ '<td>￥'
																		+ cart[i].price
																		+ '</td>'
																		+ '<td><div class="count">'
																		+ '<span><img src="imgs/bag_close.gif" class="a-d-btn reduce_img" goodid="'
																		+ cart[i].goodId
																		+ '"></span>'
																		+ '<div class="num-btn">'
																		+ cart[i].num
																		+ '</div>'
																		+ '<span><img src="imgs/bag_open.gif" class="a-d-btn add_img" goodid="'
																		+ cart[i].goodId
																		+ '"></span>'
																		+ '</div></td>'
																		+ '<td>￥'
																		+ cart[i].totalPrice
																		+ '</td>'
																		+ '<td><a href="#">删除</a></td></tr>');
											} else {
												$("#content-shopping")
														.append(
																'<tr><td > <img src="'
																		+ cart[i].picUrl
																		+ '" class="sp_img"/></td>'
																		+ '<td>'
																		+ cart[i].name
																		+ '</td>'
																		+ '<td>'
																		+ cart[i].specification
																		+ '</td>'
																		+ '<td>￥'
																		+ cart[i].price
																		+ '</td>'
																		+ '<td><div class="count">'
																		+ '<span><img src="imgs/bag_close.gif" class="a-d-btn" goodid="'
																		+ cart[i].goodId
																		+ '"></span>'
																		+ '<div class="num-btn">'
																		+ cart[i].num
																		+ '</div>'
																		+ '<span><img src="imgs/bag_open.gif" class="a-d-btn add_img" goodid="'
																		+ cart[i].goodId
																		+ '"></span>'
																		+ '</div></td>'
																		+ '<td>￥'
																		+ cart[i].totalPrice
																		+ '</td>'
																		+ '<td><a href="#">删除</a></td></tr>');
											}
											sum_number = cart[i].num
													+ sum_number;
											sum_price = cart[i].num
													* cart[i].price + sum_price;
										}
										$("#in_all")
												.append(

														'<div class="all_display">'
																+ '<span class="style1">已选择<em class="style2">'
																+ sum_number
																+ '件</em>'
																+ '商品&nbsp; | &nbsp;订单金额</span>'
																+ '<span class="style2">￥'
																+ sum_price
																+ '</span>'
																+ '<a id="btngopay"  class="go-pay">去结算</a>'
																+ '</div><!-- all_display -->'

												);
									}
								});
					}
					function addOldCart(userid, num, goodid) {
						$
								.ajax({
									type : 'post',
									data : {
										"userId" : userid,
										"goodId" : goodid,
										"num" : num
									},
									url : "CartAction_addOldCart",
									dataType : "Json",
									success : function(data) {
										var cart = data.cart;
										$("#content-shopping").empty();
										$("#in_all").empty();
										$("#content-shopping")
												.append(
														'<tr class="sp_2">'
																+ '<td style=" margin-left:20px">图片</td>'
																+ '<td>商品</td>'
																+ '<td>规格</td>'
																+ '<td>价格</td>'
																+ '<td>数量</td>'
																+ '<td>小计</td>'
																+ '<td>操作</td></tr>');
										var sum_number = 0;
										var sum_price = 0
										for (i = 0; i < cart.length; i++) {
											$("#content-shopping")
													.append(
															'<tr><td > <img src="'
																	+ cart[i].picUrl
																	+ '" class="sp_img"/></td>'
																	+ '<td>'
																	+ cart[i].name
																	+ '</td>'
																	+ '<td>'
																	+ cart[i].specification
																	+ '</td>'
																	+ '<td>￥'
																	+ cart[i].price
																	+ '</td>'
																	+ '<td><div class="count">'
																	+ '<span><img src="imgs/bag_close.gif" class="a-d-btn reduce_img" goodid="'
																	+ cart[i].goodId
																	+ '"></span>'
																	+ '<div class="num-btn">'
																	+ cart[i].num
																	+ '</div>'
																	+ '<span><img src="imgs/bag_open.gif" class="a-d-btn add_img" goodid="'
																	+ cart[i].goodId
																	+ '"></span>'
																	+ '</div></td>'
																	+ '<td>￥'
																	+ cart[i].totalPrice
																	+ '</td>'
																	+ '<td><a href="#">删除</a></td></tr>');
											sum_number = cart[i].num
													+ sum_number;
											sum_price = cart[i].num
													* cart[i].price + sum_price;
										}
										$("#in_all")
												.append(

														'<div class="all_display">'
																+ '<span class="style1">已选择<em class="style2">'
																+ sum_number
																+ '件</em>'
																+ '商品&nbsp; | &nbsp;订单金额</span>'
																+ '<span class="style2">￥'
																+ sum_price
																+ '</span>'
																+ '<a id="btngopay"  class="go-pay">去结算</a>'
																+ '</div><!-- all_display -->'

												);
									}
								});
					}

					
					function createOrder(){
						$.ajax({
							type : "post",
							data : {
								userId :userid,
							},
							url : "OrderAction_createOrder",
							dataType : "json",
							success : function(data) {
								window.location.href="add_order.html?orderNo="+data.orderNo;
							}
						});
					}
					
					$("#in_all").on("click",".go-pay",function(){createOrder()});
					
					
				})