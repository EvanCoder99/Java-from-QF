<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	//增加商品
	function pNum(cid,p,no){
		var nums = parseInt($("#num_count"+no).val()) + 1;	//唯一识别，取出数量
		location.href = "cart?action=update&cid="+cid+"&num="+nums+"&price="+p;
	}
	//减少商品
	function mNum(cid,p,no){
		var nums = $("#num_count"+no).val() - 1;
		if(Number(nums) == 0){
			if(confirm("确认要删除吗?")){
				location.href="cart?action=delete&cid="+cid;
			}
		}else{
			location.href = "cart?action=update&cid="+cid+"&num="+nums+"&price="+p;
		}
	}

	function deleteCart(cid){
		if(confirm("确认要删除吗")){
			location.href="cart?action=delete&cid="+cid;
		}
	}

	function clearCart(){
		if(confirm("确认要删除吗")){
			location.href="cart?action=clear";
		}
	}
</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp"%>
<div class="container" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>我的购物车<small>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</small></h3>
	</div>
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-bordered table-striped table-hover">
 				<tr>
 					<th>序号</th>
 					<th>商品名称</th>
 					<th>价格</th>
 					<th>数量</th>
 					<th>小计</th>
 					<th>操作</th>
 				</tr>
 				<c:set value="0" var="sum"></c:set>
 				<c:forEach items="${carts}" var="c" varStatus="i">
	 				<tr>
	 					<th>${i.count}</th>
	 					<th>${c.goods.p_name}</th>
	 					<th>${c.goods.p_price}</th>
	 					<th width="100px">
		 					<div class="input-group">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" onclick="mNum(${c.c_id},${c.goods.p_price},${i.count})">-</button>
		 						</span>
		 						<input type="text" class="form-control" id="num_count${i.count}" value="${c.c_num}" readonly="readonly" style="width:40px">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" onclick="pNum(${c.c_id},${c.goods.p_price},${i.count})">+</button>
		 						</span>
	 						</div>
	 					</th>
	 					<th>¥&nbsp;${c.c_count}</th>
	 					<th>
	 						<button type="button" class="btn btn-default" onclick="deleteCart(${c.c_id})">删除</button>
	 					</th>
	 				</tr>
	 				<c:set var="sum" value="${sum+c.c_count}"></c:set>
 				</c:forEach>
			</table>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="pull-right" style="margin-right: 40px;">
			
	            <div>
	            	<a id="removeAllProduct" onclick="clearCart()" href="#" class="btn btn-default btn-lg">清空购物车</a>
	            	&nbsp;&nbsp;
	            	<a href="${pageContext.request.contextPath}/order?action=preview" class="btn  btn-danger btn-lg">订单预览</a>
	            	
	            </div>
	            <br><br>
	            <div style="margin-bottom: 20px;">        		  
	            	商品金额总计：<span id="total" class="text-danger"><b>￥&nbsp;&nbsp;${sum}</b></span>
	            </div>
		</div>
	</div>
</div>
	
    
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>