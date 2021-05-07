$(document).ready(
		function (){

//			margin-page
			$(".page-detail").css({
				"margin-top": $(".banner-top").outerHeight()
			})
			$(window).resize(function(){
				$(".page-detail").css({
					"margin-top": $(".banner-top").outerHeight()
				})
			});
			$(".btnGioHang").click(
					function () {
						var mamau = $(this).closest("tr").find(".mau").attr(
							"data-mamau");
						var tenmau = $(this).closest("tr").find(".mau").text();

						var masize = $(this).closest("tr").find(".size").attr(
							"data-masize");
						var tensize = $(this).closest("tr").find(".size")
							.text();

						var soluong = $(this).closest("tr").find(".soluong")
							.text();

						var tensp = $("#tensp").text();
						var masp = $("#tensp").attr("data-masp");

						var giatien = $("#giatien").attr("data-giatien");

						var machitiet = $(this).attr("data-machitiet");
						var json={};
						json["masp"]=masp;
						json["masize"]=masize;
						json["mamau"]=mamau;
						json["tensp"]=tensp;
						json["giatien"]=giatien;
						json["tenmau"]=tenmau;
						json["tensize"]=tensize;
						json["soluong"]=1;
						json["machitiet"]=machitiet;
						$.ajax({
							url: "/api/carts",
							type: "POST",
							 contentType: 'application/json',
					            data: JSON.stringify(json),

							success: function (value) {
								$("#giohang").find("div").addClass(
									"circle-giohang")
								$("#giohang").find("div").html(
									"<span style='color:white'>" + value + "</span>");
								
							}
						})
					});
		}
		);