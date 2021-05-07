package com.TP.api.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TP.IDAO.IChiTietHoaDon;
import com.TP.IDAO.IChiTietSanPham;
import com.TP.IDAO.IHoaDon;
import com.TP.Respone.HoaDonResponse;
import com.TP.Respone.ValidRespone;
import com.TP.entity.ChiTietHoaDon;
import com.TP.entity.ChiTietHoaDonId;
import com.TP.entity.ChiTietSanPham;
import com.TP.entity.GioHang;
import com.TP.entity.HoaDon;
import com.TP.service.ChiTietHoaDonService;
import com.TP.service.ChiTietSanPhamService;
import com.TP.service.HoaDonService;

@RestController
@RequestMapping("api/")
public class OrderAPI {

	@Autowired
	IHoaDon hoaDonService;

	@Autowired
	IChiTietHoaDon chiTietHoaDonService;

	@Autowired

	IChiTietSanPham chiTietSanPhamService;

	@PostMapping(path = "order")

	public HoaDonResponse Insert(@ModelAttribute @Valid HoaDon hoaDon, BindingResult result, HttpSession httpSession) {
		HoaDonResponse response = new HoaDonResponse();
		Map<String, String> errors = new HashMap<String, String>();
		if (null != httpSession.getAttribute("giohang")) {
			if (result.hasErrors()) {

				errors = result.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				response.setValidated(false);
				response.setErrorMessages(errors);
				return response;
			}

			response.setValidated(true);
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");

			if (listGioHangs.size() < 0) {
				response.setValidated(false);
				return response;
			}
			if (listGioHangs.size() > 0) {
				for (GioHang gioHang : listGioHangs) {

					ChiTietSanPham ctsp = chiTietSanPhamService.findById(gioHang.getMachitiet());
					if (gioHang.getSoluong() > ctsp.getSoluong()) {

						errors.put(String.valueOf(gioHang.getMachitiet()),
								"Số lượng sản phẩm còn lại: " + String.valueOf(ctsp.getSoluong()));
						response.setValidated(false);
						response.setErrorMessages(errors);
						response.setValidated(false);

					}
				}
				if (response.isValidated()==false)
				{
					return response;
				}
				
			}
			hoaDon.setTinhtrang(false);
			hoaDon.setThanhtoan(false);
			int idHoaDon = hoaDonService.save(hoaDon);
			if (idHoaDon > 0) {
				response.setId(idHoaDon);
				Set<ChiTietHoaDon> listChiTietHoaDon = new HashSet<ChiTietHoaDon>();

				for (GioHang gioHang : listGioHangs) {

					ChiTietSanPham ctsp = chiTietSanPhamService.findById(gioHang.getMachitiet());
					
						ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
						chiTietHoaDonId.setMachitietsanpham(gioHang.getMachitiet());
						chiTietHoaDonId.setMahoadon(hoaDon.getMahoadon());

						ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
						chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
						chiTietHoaDon.setGiatien(gioHang.getGiatien());
						chiTietHoaDon.setSoluong(gioHang.getSoluong());

						chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);

						ChiTietSanPham chiTietSanPham = new ChiTietSanPham();

						chiTietSanPham.setMachitietsanpham(gioHang.getMachitiet());
						chiTietSanPham.setSoluong(gioHang.getSoluong());

						chiTietSanPhamService.save(chiTietSanPham);

				}
			}

		}

		return response;
	}
}
