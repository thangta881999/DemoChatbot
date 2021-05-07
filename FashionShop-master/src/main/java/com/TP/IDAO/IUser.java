package com.TP.IDAO;

import com.TP.entity.UserEntity;

public interface IUser {
	UserEntity loadUserbyUsername(String username,int status);
	
	boolean save(UserEntity UserEntity);
}
