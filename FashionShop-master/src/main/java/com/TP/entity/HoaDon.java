package com.TP.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "HOADON")
public class HoaDon extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int mahoadon;
	
	@NotNull
	@Size(min = 3, max = 30, message = "Nhập tên người nhận từ 3-30 ký tự")
	String tenkhachhang;
	@NotNull
	@Pattern(regexp = "(\\+84|0)[0-9]{9}",message = "Nhập vào số điện thoại")
	String sodt;
	@NotEmpty(message = "Nhập đầy đủ địa chỉ giao hàng")
	String diachigiaohang;
	Boolean tinhtrang;
	Boolean thanhtoan;
	public Boolean getThanhtoan() {
		return thanhtoan;
	}

	public void setThanhtoan(Boolean thanhtoan) {
		this.thanhtoan = thanhtoan;
	}


	String hinhthucgiaohang;
	String ghichu;
	
	String tongtien;
	  
	  public String getTongtien() { return tongtien; }
	  
	  public void setTongtien(String tongtien) { this.tongtien = tongtien; }
	 

	@OneToMany( cascade = CascadeType.REMOVE)
	 @JoinColumn(name = "mahoadon") 
	Set<ChiTietHoaDon> danhsachChiTietHoaDon;

	public int getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}

	public String getTenkhachhang() {
		return tenkhachhang;
	}

	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}

	public String getSodt() {
		return sodt;
	}

	public void setSodt(String sodt) {
		this.sodt = sodt;
	}

	public String getDiachigiaohang() {
		return diachigiaohang;
	}

	public void setDiachigiaohang(String diachigiaohang) {
		this.diachigiaohang = diachigiaohang;
	}

	public Boolean getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(Boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}



	public Set<ChiTietHoaDon> getDanhsachChiTietHoaDon() {
		return danhsachChiTietHoaDon;
	}

	public void setDanhsachChiTietHoaDon(Set<ChiTietHoaDon> danhsachChiTietHoaDon) {
		this.danhsachChiTietHoaDon = danhsachChiTietHoaDon;
	}

	public String getHinhthucgiaohang() {
		return hinhthucgiaohang;
	}

	public void setHinhthucgiaohang(String hinhthucgiaohang) {
		this.hinhthucgiaohang = hinhthucgiaohang;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
}
