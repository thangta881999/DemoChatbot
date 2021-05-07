package com.TP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.DAO.UserDAO;
import com.TP.IDAO.IUser;
import com.TP.entity.UserEntity;

@Service
public class UserService implements IUser{
	
	@Autowired
	UserDAO UserDAO;


	
	public UserEntity loadUserbyUsername(String username,int status)
	{
		return UserDAO.loadUserbyUsername(username, status);
	}



	@Override
	public boolean save(UserEntity UserEntity) {
		// TODO Auto-generated method stub
		return UserDAO.save(UserEntity);
	}
}
