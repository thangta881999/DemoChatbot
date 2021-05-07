package com.TP.IDAO;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.TP.DTO.HoaDonDTO;
import com.TP.entity.HoaDon;

public interface IHoaDon {
	List<HoaDonDTO> findAll(int offset, int limit);
	int save(HoaDon hoaDon);
	HoaDonDTO findById(int id);
	long getBillsuccess();
	long getBillprocessing();
	int getTotalrevenue();
	boolean deleteById(int mahoadon);
	Map<Integer,Double> getMonthlyrevenue ();
	Map<String,BigInteger> getProductSellbyCat();
}
