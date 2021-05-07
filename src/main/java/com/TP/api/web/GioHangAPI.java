package com.TP.api.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.TP.DTO.GioHangDTO;
import com.TP.entity.GioHang;

@RestController(value = "GioHangAPIOfWeb")
@RequestMapping("api/")
@SessionAttributes({"themgiohang" })
public class GioHangAPI {
	
	@PutMapping(path = "carts")
	public void update(@RequestBody GioHangDTO giohang,HttpSession httpSession) {
		
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listSPGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraSanPhamDaTonTaiGioHang(httpSession, giohang.getMasp(), giohang.getMasize(), giohang.getMamau());
			
			listSPGioHang.get(vitri).setSoluong(giohang.getSoluong());
		}
	}


	@DeleteMapping(path = "carts")
	public void XoaGioHang(@RequestBody GioHangDTO giohang,HttpSession httpSession) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listSPGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraSanPhamDaTonTaiGioHang(httpSession,giohang.getMasp(),giohang.getMasize(), giohang.getMamau());
			
			listSPGioHang.remove(vitri);
		}
	}
	 @PostMapping(path = "carts") 
	  public String Insert(@RequestBody GioHang giohang,HttpSession httpSession) {
	  
	 
		
		  if (null == httpSession.getAttribute("giohang")) {
			  List<GioHang> listGioHang = new ArrayList<GioHang>();
		  listGioHang.add(giohang);
		  httpSession.setAttribute("giohang", listGioHang);
		  return listGioHang.size() + ""; 
		  }
		  else { 
			  List<GioHang> listSPGioHang =(List<GioHang>) httpSession.getAttribute("giohang");
		  int vitri = KiemTraSanPhamDaTonTaiGioHang(httpSession,giohang.getMasp(),
		  giohang.getMasize(), giohang.getMamau());
		  
		  if (vitri == -1) {
		  
		  
		  listSPGioHang.add(giohang); } else { int soluongmoi =
		  listSPGioHang.get(vitri).getSoluong() + 1;
		  listSPGioHang.get(vitri).setSoluong(soluongmoi); }
		  
		  return listSPGioHang.size() + ""; }
		 
	 } 

	private int KiemTraSanPhamDaTonTaiGioHang(HttpSession httpSession, int masp, int masize, int mamau) {
		if (httpSession.getAttribute("giohang") != null) {
			List<GioHang> listSanPhamGioHang = (List<GioHang>) httpSession.getAttribute("giohang");

			for (int i = 0; i < listSanPhamGioHang.size(); i++) {
				if (listSanPhamGioHang.get(i).getMasp() == masp && listSanPhamGioHang.get(i).getMasize() == masize
						&& listSanPhamGioHang.get(i).getMamau() == mamau) {
					return i;
				}

			}
		}
		return -1;
	}
}
