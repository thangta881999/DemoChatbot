package com.TP.converter;

import org.springframework.stereotype.Component;

import com.TP.DTO.DanhMucDTO;
import com.TP.entity.DanhMucSanPham;

@Component
public class DanhMucConverter {
	public DanhMucDTO toDTO(DanhMucSanPham entity) {
		DanhMucDTO dto = new DanhMucDTO();
		if (entity!=null)
		{
			dto.setMadanhmuc(entity.getMadanhmuc());
			dto.setTendanhmuc(entity.getTendanhmuc());
			dto.setParent_madanhmuc(entity.getParent_madanhmuc());
		}
		

		return dto;
	}
	public DanhMucSanPham toEntity(DanhMucDTO dto)
	{
		DanhMucSanPham entity= new DanhMucSanPham();
		if(dto !=null)
		{
			entity.setMadanhmuc(dto.getMadanhmuc());
			entity.setTendanhmuc(dto.getTendanhmuc());
			entity.setParent_madanhmuc(dto.getParent_madanhmuc());
		}
		return entity;
			
	}
}
