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
				<header>
					<h3 class="head text-center keyword" keyword="${keyword}" >Tìm kiếm: ${keyword}</h3>
				</header>
			
				<div class="clearfix"></div>
				<div class="row" id="listproducts" name="listproducts">
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
				</div>
				<div class="button head text-center" style="margin-top:7%" > <span id="load_more">LOAD MORE...</span></div>
			</div>

				
		</div>



	
		<div class="clearfix"></div>
	</div>


	<!-- content-section-ends-here -->

	<script src='<c:url value="/resources/JS/jquery-3.4.1.min.js" />'></script>
	<script src='<c:url value="/resources/JS/web/search.js" />'></script>
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
