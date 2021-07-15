<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>

<body>
	
	<!-- content-section-starts-here -->
	<div class="container page-search">
		<div class="main-content">


			<div class="products-grid container">
				<div class="clearfix"></div>
				<div class="row" id="listproducts" name="listproducts">
					<c:if test="${listSanPhams.size()==0}">
						<div
								class=" col-md-4 col-sm-6 product simpleCart_shelfItem text-center ">
						<a class="product_name" href="/">Không có sản phẩm gợi ý cho bạn.Vui lòng đánh giá khi mua sản phẩm để được gợi ý</a>
						</div>
					</c:if>
					<c:if test="${listSanPhams.size()>0}">
						<c:forEach var="sanpham" items="${listSanPhams}">
							<div
									class=" col-md-4 col-sm-6 product simpleCart_shelfItem text-center ">
								<a href="chitiet/${sanpham.getMasanpham()}"> <img
										src='<c:url value="/resources/images/sanpham/${sanpham.getHinhsanpham()}" />' /><br />

								</a>

								<div class="mask">
									<a href="chitiet/${sanpham.getMasanpham()}">Quick View</a>
								</div>
								<a class="product_name" href="chitiet/${sanpham.getMasanpham()}">${sanpham.getTensanpham()}</a>
								<p>
									<span class="item_price">${sanpham.getGiatien()} VND</span>
								</p>
							</div>
						</c:forEach>
					</c:if>

				</div>
			</div>

				
		</div>



	
		<div class="clearfix"></div>
	</div>


	<!-- content-section-ends-here -->

	<script src='<c:url value="/resources/JS/jquery-3.4.1.min.js" />'></script>
</body>
<!-- Messenger Plugin chat Code -->
<div id="fb-root"></div>

<!-- Your Plugin chat code -->
<div id="fb-customer-chat" class="fb-customerchat">
</div>

<script>
	var chatbox = document.getElementById('fb-customer-chat');
	chatbox.setAttribute("page_id", "102518868784952");
	chatbox.setAttribute("attribution", "biz_inbox");

	window.fbAsyncInit = function() {
		FB.init({
			xfbml            : true,
			version          : 'v11.0'
		});
	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) return;
		js = d.createElement(s); js.id = id;
		js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>
</html>
