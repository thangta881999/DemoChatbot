<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="container page-detail">
		<div class="row" style="margin-top: 15px">
			<div class="col-sm-2 col-md-2">

				<div class="menu-listy">
					<h2>our Products</h2>

					<ul class="categories-list">
						<c:forEach var="parent" items="${danhmucDTO}">
							<div class="categories">
								<ul>
									<h4 class="category-parent" style="margin-left: 10%">${parent.getTendanhmuc()}</h4>
									<c:if test="${not empty parent.getChildrentsDanhMuc() }">
										<c:forEach var="childrent"
											items="${parent.getChildrentsDanhMuc()}">
											<li><a
												href='<c:url value="/sanpham/${childrent.getMadanhmuc()}/${childrent.getTendanhmuc()}" />'>${childrent.getTendanhmuc()}</a></li>

										</c:forEach>
									</c:if>
								</ul>
							</div>
						</c:forEach>
					</ul>





				</div>
			</div>

			<div class="col-sm-8 col-md-8">
				<div class="row">
					<div class="col-sm-4 col-md-4 ">
						<img style="max-width: 100%"
							src='<c:url value="/resources/images/sanpham/${chiTietSanPham.getHinhsanpham()}" />'>
					</div>

					<div class="col-sm-8 col-md-8">
						<h3 id="tensp" data-masp="${chiTietSanPham.getMasanpham()}">${chiTietSanPham.getTensanpham()}</h3>
						<h4 id="giatien" data-giatien="${chiTietSanPham.getGiatien()}"
							style="color: red">${chiTietSanPham.getGiatien()}VND</h4>

						<table class="table">
							<thead>
								<tr>
									<td><h5>Màu</h5></td>
									<td><h5>Size</h5></td>
									<td><h5>Số lượng</h5></td>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="listchitietsanpham"
									items="${chiTietSanPham.getChiTietSanPham()}">
									<c:if test="${listchitietsanpham.getSoluong() > 0}">

										<tr>
											<td class="mau"
												data-mamau="${listchitietsanpham.getMauSanPham().getMamau()}">${listchitietsanpham.getMauSanPham().getTenmau()}</td>
											<td class="size"
												data-masize="${listchitietsanpham.getSizeSanPham().getMasize()}">${listchitietsanpham.getSizeSanPham().getSize()}</td>
											<td class="soluong">${listchitietsanpham.getSoluong()}</td>
											<td><button
													data-machitiet="${listchitietsanpham.getMachitietsanpham()}"
													class="btn btn-success btnGioHang">+ Thêm vào giỏ
													hàng</button></td>
										</tr>

									</c:if>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-sm-2 col-md-2">
				<span>${chiTietSanPham.getMota()}</span>
			</div>
		</div>
	</div>
	<script src='<c:url value="/resources/JS/jquery-3.4.1.min.js" />'></script>
	<script src='<c:url value="/resources/JS/web/chitiet.js" />'></script>
</body>
</html>