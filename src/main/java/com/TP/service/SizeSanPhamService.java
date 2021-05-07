package com.TP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.DAO.SizeSanPhamDAO;
import com.TP.IDAO.ISizeSanPham;
import com.TP.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements ISizeSanPham {
	@Autowired
	SizeSanPhamDAO sizeSanPhamDAO;
	public List<SizeSanPham> layDanhSachSize() {
		// TODO Auto-generated method stub
		return sizeSanPhamDAO.layDanhSachSize();
	}
	@Override
	public int save(SizeSanPham sizeSanPham) {
		// TODO Auto-generated method stub
		return sizeSanPhamDAO.save(sizeSanPham);
	}
	
}
