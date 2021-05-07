package com.TP.IDAO;

import java.util.List;

import com.TP.DTO.DanhMucDTO;
import com.TP.entity.DanhMucSanPham;

public interface IDanhMuc {
	List<DanhMucSanPham> findAll(int offset, int limit);
	boolean deleteChildrent(int madm);
	boolean deleteAll(int madm);
	boolean save(DanhMucSanPham danhmuc);
	DanhMucDTO findById(int madm);
	public List<DanhMucSanPham> findByParent();
	public List<DanhMucSanPham> findByChildren(int parent_madanhmuc);
	public List<DanhMucDTO>CreateMenu();
}
