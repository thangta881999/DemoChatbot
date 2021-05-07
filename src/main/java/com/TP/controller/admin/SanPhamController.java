package com.TP.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TP.DTO.SanPhamDTO;
import com.TP.IDAO.IDanhMuc;
import com.TP.IDAO.IMauSanPham;
import com.TP.IDAO.ISanPham;
import com.TP.IDAO.ISizeSanPham;
import com.TP.entity.DanhMucSanPham;
import com.TP.entity.MauSanPham;
import com.TP.entity.SanPham;
import com.TP.entity.SizeSanPham;
import com.TP.service.DanhMucService;
import com.TP.service.MauSanPhamService;
import com.TP.service.SanPhamService;
import com.TP.service.SizeSanPhamService;

@Controller(value = "productOfAdmin")
@RequestMapping("/admin/product")
public class SanPhamController {
	
	@Autowired
	ISanPham sanPhamService;
	@Autowired
	IDanhMuc danhMucService;
	@Autowired
	ISizeSanPham sizeSanPhamService;
	
	@Autowired
	IMauSanPham mauSanPhamService;
	
	@GetMapping
	private String Default(ModelMap modelMap) {
		List<SanPhamDTO> listSanPhams = sanPhamService.findAll(0,5);
		List<SanPhamDTO> allSanPhams = sanPhamService.findAll(-1,-1);
		List<DanhMucSanPham> danhMucSanPhams= danhMucService.findAll(-1,-1);
		List<SizeSanPham> sizeSanPhams = (List<SizeSanPham>) sizeSanPhamService.layDanhSachSize();
		List<MauSanPham> mauSanPhams = (List<MauSanPham>) mauSanPhamService.LayDanhSachMau();
		double tongPages = Math.ceil((double) allSanPhams.size() / 5);
		
		modelMap.addAttribute("listSanPhams", listSanPhams);
		modelMap.addAttribute("listallSanpham", allSanPhams);
		modelMap.addAttribute("tongsoPages", tongPages);
		modelMap.addAttribute("danhmuc",danhMucSanPhams);
		modelMap.addAttribute("sizeSanPhams", sizeSanPhams);
		modelMap.addAttribute("mauSanPhams", mauSanPhams);
		return "admin/themsanpham"; 
	}
}
