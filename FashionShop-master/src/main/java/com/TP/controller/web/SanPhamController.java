package com.TP.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TP.DTO.DanhMucDTO;
import com.TP.DTO.SanPhamDTO;
import com.TP.IDAO.IDanhMuc;
import com.TP.IDAO.ISanPham;
import com.TP.converter.SanPhamConverter;
import com.TP.entity.DanhMucSanPham;
import com.TP.entity.GioHang;
import com.TP.entity.SanPham;
import com.TP.service.DanhMucService;
import com.TP.service.SanPhamService;

@Controller(value = "productOfWeb")
@RequestMapping("/sanpham")
public class SanPhamController {
	
	@Autowired
	IDanhMuc danhMucService;
	
	@Autowired
	ISanPham sanPhamService;
	
	
	
	
	@GetMapping("/{id}/{tendanhmuc}")
	public String Default(@PathVariable int id, @PathVariable String tendanhmuc, ModelMap modelMap,HttpSession httpSession) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", listGioHangs.size());
		}
		List<DanhMucDTO> danhMucDTOs = danhMucService.CreateMenu();
		modelMap.addAttribute("danhmucDTO", danhMucDTOs);
	
		
		List<SanPhamDTO> listSanPham = sanPhamService.LayDanhSachSanPhamTheoMaDanhMuc(id,0,40);
		List<SanPhamDTO> allSanPhams = sanPhamService.LayDanhSachSanPhamTheoMaDanhMuc(id, -1,-1);
		double tongPages = Math.ceil((double) allSanPhams.size() / 40);
		modelMap.addAttribute("tendanhmuc", tendanhmuc);
		modelMap.addAttribute("listSanPham", listSanPham);
		modelMap.addAttribute("madanhmuc",id);
		
		modelMap.addAttribute("madanhmuc",id);
		modelMap.addAttribute("listallSanpham", allSanPhams);
		modelMap.addAttribute("tongsoPages", tongPages);
		
		return "web/sanpham1";
	}
}
