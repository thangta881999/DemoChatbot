package com.TP.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.TP.IDAO.ISizeSanPham;
import com.TP.entity.MauSanPham;
import com.TP.entity.SizeSanPham;

@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDAO  implements ISizeSanPham{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<SizeSanPham> layDanhSachSize() {
		Session session=sessionFactory.getCurrentSession();
		String query="from SIZESANPHAM";
		List<SizeSanPham> sizeSanPhams= (List<SizeSanPham>)session.createQuery(query).getResultList();
		
		return sizeSanPhams;
	}

	@Override
	@Transactional	
	public int save(SizeSanPham sizeSanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String query="FROM SIZESANPHAM " + 
				"WHERE size='"+sizeSanPham.getSize()+"'";
		List<SizeSanPham> sizeSanPhams = session.createQuery(query).getResultList();
		
		 
		if (sizeSanPhams.size()>0)
		{
			return sizeSanPhams.get(0).getMasize();
		}
			return (Integer)session.save(sizeSanPham);
		
	
	}

}
