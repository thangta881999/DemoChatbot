package com.TP.controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.TP.DTO.DanhMucDTO;
import com.TP.IDAO.IDanhMuc;
import com.TP.IDAO.ISanPham;
import com.TP.entity.DanhMucSanPham;
import com.TP.entity.GioHang;
import com.TP.entity.SanPham;
import com.TP.service.DanhMucService;
import com.TP.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietController {
	
	@Autowired
	ISanPham sanPhamService;
	
	@Autowired
	IDanhMuc danhMucService;
	
	@GetMapping(path = "/{masanpham}", produces = "text/plain; charset=utf-8")
	public String Default(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession) {
		
		SanPham sanPham = sanPhamService.LayDanhSachChiTietSanPhamTheoMa(masanpham);
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", listGioHangs.size());
		}
		
		modelMap.addAttribute("chiTietSanPham", sanPham);
		List<DanhMucDTO> danhMucDTOs = danhMucService.CreateMenu();
		modelMap.addAttribute("danhmucDTO", danhMucDTOs);
	
		return "web/chitiet";
	}
}