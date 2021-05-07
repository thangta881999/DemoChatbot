package com.TP.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TP.IDAO.IDanhMuc;
import com.TP.entity.DanhMucSanPham;
import com.TP.service.DanhMucService;

@Controller
@RequestMapping("/admin/categories")
public class DanhMucController {
	
	@Autowired
	IDanhMuc danhMucService;
	
	
	@GetMapping
	private String Default(ModelMap modelMap) {
	
		List<DanhMucSanPham> danhMucSanPhams= danhMucService.findAll(0,6);
		List<DanhMucSanPham> allcategories= danhMucService.findAll(-1,-1);
		double tongPages = Math.ceil((double) allcategories.size() / 6);
	
		modelMap.addAttribute("danhmuc",danhMucSanPhams);
		modelMap.addAttribute("tongsoPages", tongPages);
		return "admin/danhmuc"; 
	}
}
