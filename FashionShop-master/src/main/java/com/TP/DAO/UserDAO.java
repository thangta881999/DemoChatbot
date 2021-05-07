package com.TP.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.TP.IDAO.IUser;
import com.TP.entity.UserEntity;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDAO implements IUser{
	@Autowired
	SessionFactory sessionFactory;
	

	@Transactional
	public UserEntity loadUserbyUsername(String username,int status) {
		Session session = sessionFactory.getCurrentSession();
		try {
			UserEntity user =(UserEntity) session.createQuery("from user where username='" + username + "' and status='" + status + "'").getSingleResult();
			 
		
			if (user!=null) {
				return user;
			}
		
			else {
				return null;
			}
		} catch (Exception e) {
			return null;
			
		}
	}
	@Transactional
	public UserEntity loadUserbyUsernameAndPassword(String username,String password) {
		Session session = sessionFactory.getCurrentSession();
		try {
			UserEntity user =(UserEntity) session.createQuery("from user where username='" + username + "' and  password='" +  password + "'").getSingleResult();
			 
		
			if (user!=null) {
				return user;
			}
		
			else {
				return null;
			}
		} catch (Exception e) {
			return null;
			
		}
	}

	@Transactional

	@Override
	public boolean save(UserEntity UserEntity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(UserEntity);
		if(id > 0)
			return true;
		else 
			return false;
	}
}
