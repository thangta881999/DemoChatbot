package com.TP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.DAO.ChiTietHoaDonDAO;
import com.TP.IDAO.IChiTietHoaDon;
import com.TP.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements IChiTietHoaDon{

	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDAO;
	
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
	}

}
