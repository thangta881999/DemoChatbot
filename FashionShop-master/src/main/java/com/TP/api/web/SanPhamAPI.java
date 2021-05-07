package com.TP.api.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.TP.DTO.SanPhamDTO;
import com.TP.IDAO.ISanPham;
import com.TP.converter.SanPhamConverter;
import com.TP.entity.SanPham;
import com.TP.service.SanPhamService;

@Controller(value = "SanPhamAPIOfWeb")
@RequestMapping("api/")
public class SanPhamAPI {
	@Autowired 
	ISanPham sanPhamService;
	
	
	@GetMapping(value = "/indexData")
	@ResponseBody
	public String indexData() {
		try {
			sanPhamService.indexBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Indexed at " + new Date().toGMTString();
	}

	@GetMapping(value="categories/{madanhmuc}/order/products")
	@ResponseBody
	public List<SanPhamDTO> findByCategoryAndOrder(@PathVariable int madanhmuc,@RequestParam(value = "orderby", required = false) String orderby ,@RequestParam(value = "order",required = false) String order
									,@RequestParam(defaultValue ="-1") int offset,@RequestParam(defaultValue = "-1") int limit)
	
	{
		
		return sanPhamService.findByCategoryAndOrder(madanhmuc,orderby,order,offset,limit);
	}
	@GetMapping(value="order/products")
	@ResponseBody
	public List<SanPhamDTO> sortALL(@RequestParam(value = "orderby", required = false) String orderby ,@RequestParam(value = "order",required = false) String order
									,@RequestParam(defaultValue ="-1") int offset,@RequestParam(defaultValue = "-1") int limit)
	
	{
		
		return sanPhamService.sortAll(orderby, order, offset, limit);
	}
	@GetMapping(value="/search")
	@ResponseBody
	public List<SanPhamDTO> search(@RequestParam(value = "keyword") String keyword , @RequestParam(defaultValue = "-1") int offset, @RequestParam int limit) {
		
		
		return sanPhamService.search(keyword,offset,limit);
	}
	@GetMapping(path = "products", produces="application/json; charset=utf-8")
	@ResponseBody
	public List<SanPhamDTO> findAll(@RequestParam(defaultValue ="-1") int offset,@RequestParam(defaultValue ="-1") int limit) {
		return sanPhamService.findAll(offset,limit);
	}
	@GetMapping(path = "pages/products", produces="application/text; charset=utf-8")
	@ResponseBody
	public String GetPage(@RequestParam int limit) {
		List<SanPhamDTO> allSanPhams = sanPhamService.findAll(-1,-1);
		double tongPages = Math.ceil((double) allSanPhams.size() / limit);	
		
		return String.valueOf(tongPages);
	}
	
	@GetMapping(path = "pages/categories/{id}/products", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getPagesByCategory(@PathVariable int id,@RequestParam int limit) {
		List<SanPhamDTO> allSanPhams = sanPhamService.LayDanhSachSanPhamTheoMaDanhMuc(id, -1,-1);
		double tongPages = Math.ceil((double) allSanPhams.size() / limit);
		return String.valueOf(tongPages);
	}

	@GetMapping(path = "categories/{id}/products", produces="application/json; charset=utf-8")
	@ResponseBody
	public List<SanPhamDTO> findProductsByCategory(@PathVariable int id,@RequestParam int offset,@RequestParam int limit) {
	
		return sanPhamService.LayDanhSachSanPhamTheoMaDanhMuc(id, offset,limit);
	}
}
