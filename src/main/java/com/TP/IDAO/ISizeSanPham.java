package com.TP.IDAO;

import java.util.List;

import com.TP.entity.SizeSanPham;

public interface ISizeSanPham {
	List<SizeSanPham> layDanhSachSize();
	int save(SizeSanPham sizeSanPham);
}
