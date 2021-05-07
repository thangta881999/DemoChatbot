package com.TP.IDAO;
import java.util.List;

import com.TP.entity.MauSanPham;

public interface IMauSanPham {
	List<MauSanPham> LayDanhSachMau();
	int save(MauSanPham mauSanPham);
}
