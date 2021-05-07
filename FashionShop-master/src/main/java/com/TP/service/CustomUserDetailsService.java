package com.TP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TP.DAO.UserDAO;
import com.TP.DTO.MyUser;
import com.TP.entity.RoleEntity;
import com.TP.entity.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
    
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 	 UserEntity userEntity = userDAO.loadUserbyUsername(username,1);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		  for (RoleEntity role: userEntity.getRoles()) { authorities.add(new
		  SimpleGrantedAuthority(role.getCode())); }
		 
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), 
							true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

	
}
