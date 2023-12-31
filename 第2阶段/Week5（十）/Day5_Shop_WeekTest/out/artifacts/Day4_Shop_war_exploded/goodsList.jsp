<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品列表页</title>

</head>
<body>
	<%@ include file="header.jsp"%>
	
   
<div class="panel panel-default" style="margin: 0 auto;width: 95%;">
	<div class="panel-heading">
	    <h3 class="panel-title"><span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;商品列表</h3>
	</div>
	<div class="panel-body">
	   	   <!--列表开始-->
	    <div class="row" style="margin: 0 auto;">
	    	<c:forEach items="${p.list}" var="g" varStatus="i">
		    	<div class="col-sm-3">
				    <div class="thumbnail">
				      <img src="${pageContext.request.contextPath}/${g.p_image}" width="180" height="180"  alt="小米6" />
				      <div class="caption">
				        <h4>商品名称<a href="${pageContext.request.contextPath}/goods?action=goodsDetail&pid=${g.p_id}">${g.p_name}</a></h4>
				        <p>热销指数
				        	<c:forEach begin="1" end="${g.p_state}">
				        		<img src="image/star_red.gif" alt="star"/>
				        	</c:forEach>
				        </p>
				         <p>上架日期:${g.p_time}</p>
			             <p style="color:orange">价格:${g.p_price}</p>
				      </div>
				    </div>
				  </div>
	    	</c:forEach>
		</div>

		<div align="center">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<c:if test="${p.currentPage != 1}">
					<li>
						<%-- param.tid：从链接http://localhost:8080/goods?action=show&tid=1&currentPage=1中获取tid的值，类似getParameter(tid)，根据key获取值 --%>
						<a href="/goods?action=show&tid=${param.tid}&currentPage=${p.currentPage-1}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					</c:if>

					<%--begin 起始值  end 结束值 varStatus 变量取值状态--%>
					<c:forEach begin="1" end="${p.pageCount}" varStatus="vs">
						<c:choose>
							<c:when test="${p.currentPage == vs.index}">
								<%-- vs.index 从begin开始取值 --%>
								<li class="active"><a href="/goods?action=show&tid=${param.tid}&currentPage=${vs.index}">${vs.index}</a></li>
								<%--
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>--%>
							</c:when>
							<c:otherwise>
								<li><a href="/goods?action=show&tid=${param.tid}&currentPage=${vs.index}">${vs.index}</a></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>

					<c:if test="${p.currentPage != p.pageCount}">
						<li>
							<a href="/goods?action=show&tid=${param.tid}&currentPage=${p.currentPage+1}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>

				</ul>
			</nav>
		</div>
   	</div>
</div>
      <!-- 底部 -->
   <%@ include file="footer.jsp"%>
</body>
</html>