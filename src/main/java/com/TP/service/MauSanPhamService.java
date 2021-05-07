package com.TP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.DAO.MauSanPhamDAO;
import com.TP.IDAO.IMauSanPham;
import com.TP.entity.MauSanPham;

@Service
public class MauSanPhamService implements IMauSanPham {
	@Autowired
	MauSanPhamDAO mauSanPhamDAO;

	public List<MauSanPham> LayDanhSachMau() {
		
		return mauSanPhamDAO.LayDanhSachMau();
	}

	@Override
	public int save(MauSanPham mauSanPham) {
		// TODO Auto-generated method stub
		return mauSanPhamDAO.save(mauSanPham);
	}
	
	

}
