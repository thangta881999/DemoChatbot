package com.TP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.TP.DAO.HoaDonDAO;
import com.TP.DAO.SanPhamDAO;
import com.TP.DTO.SanPhamDTO;
import com.TP.IDAO.ISanPham;
import com.TP.entity.SanPham;

@Service
public class SanPhamService implements ISanPham {

	@Autowired
	SanPhamDAO sanPhamDAO;
	


	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham) {
		
		return sanPhamDAO.LayDanhSachChiTietSanPhamTheoMa(masanpham);
	}

	public List<SanPhamDTO> LayDanhSachSanPhamTheoMaDanhMuc(int madanhmuc,int offset,int limit) {
		
		return sanPhamDAO.LayDanhSachSanPhamTheoMaDanhMuc(madanhmuc,offset,limit);
	}

//	@Override
	public boolean XoaSanPhamTheoMaSanPham(int masp) {
		return 	sanPhamDAO.XoaSanPhamTheoMaSanPham(masp);
	}

	public boolean themSanPham(SanPham sanPham) {
		return sanPhamDAO.themSanPham(sanPham);
	}

	public boolean capnhatSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.capnhatSanPham(sanPham);
	}

	public List<SanPhamDTO> findAll(int offset,int limit) {
		// TODO Auto-generated method stub
		return sanPhamDAO.findAll(offset, limit);
	}

	@Override
	public void indexBooks() throws Exception {
		// TODO Auto-generated method stub
		sanPhamDAO.indexBooks();
	}

	@Override
	public List<SanPhamDTO> search(String keyword,int offset, int limit) {
		// TODO Auto-generated method stub
		return sanPhamDAO.search(keyword, offset, limit);
	}

	@Override
	public List<SanPhamDTO> findByCategoryAndOrder(int madanhmuc,String orderby,String order,int offset,int limit ) {
		// TODO Auto-generated method stub
		return sanPhamDAO.findByCategoryAndOrder(madanhmuc,orderby,order,offset,limit);
	}

	@Override
	public List<SanPhamDTO> sortAll(String orderby, String order, int offset, int limit) {
		// TODO Auto-generated method stub
		return sanPhamDAO.sortAll(orderby, order, offset, limit);
	}

	@Override
	public int save2(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.save2(sanPham);
	}
	
}
