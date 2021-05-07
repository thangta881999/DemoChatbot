package com.TP.controller.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.TP.DTO.DanhMucDTO;
import com.TP.IDAO.IDanhMuc;
import com.TP.IDAO.IHoaDon;
import com.TP.entity.ChiTietHoaDon;
import com.TP.entity.ChiTietHoaDonId;
import com.TP.entity.DanhMucSanPham;
import com.TP.entity.GioHang;
import com.TP.entity.HoaDon;
import com.TP.service.ChiTietHoaDonService;
import com.TP.service.DanhMucService;
import com.TP.service.HoaDonService;

@Controller
@RequestMapping("giohang/")
public class GioHangController {
	
	@Autowired
	IDanhMuc danhMucService;
	
	@Autowired
	IHoaDon hoaDonService;
	
	@GetMapping(path="checkout")
	public ModelAndView ResponseMomo(@RequestParam String message,@RequestParam String orderId)
	{
		if (message.equals("Success"))
		{
			HoaDon hd= new HoaDon();
			hd.setMahoadon(Integer.parseInt(orderId));
			hd.setThanhtoan(true);
			hoaDonService.save(hd);
			return new ModelAndView("redirect:/giohang/");
		}
		return new ModelAndView("redirect:/giohang/paymentError");
	}
	
	@GetMapping(path="paymentError")
	public String ErrorPayment()
	{
		
		return "web/checkoutError";
	}
	@GetMapping(produces = "text/plain; charset=utf-8")
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", listGioHangs.size());
			modelMap.addAttribute("giohangs", listGioHangs);
			
		}
		List<DanhMucDTO> danhMucDTOs = danhMucService.CreateMenu();
		modelMap.addAttribute("danhmucDTO", danhMucDTOs);
	
		return "web/giohang";
	}
}
