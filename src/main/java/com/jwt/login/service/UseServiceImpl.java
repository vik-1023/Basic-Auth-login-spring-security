package com.jwt.login.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.login.entity.UserInfo;
import com.jwt.login.repository.UserInfoRepo;
import com.jwt.login.userInfoDto.UserInfoDto;

@Service
public class UseServiceImpl implements UserInfoService {

	private UserInfoRepo userInfoRepo;

	public UseServiceImpl(UserInfoRepo userInfoRepo) {
		super();
		this.userInfoRepo = userInfoRepo;
	}
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserInfo create(UserInfoDto userInfoDto) {
		UserInfo user = new UserInfo();
		user.setUsername(userInfoDto.getUsername());
		user.setPassword(passwordEncoder().encode(userInfoDto.getPassword()));
		UserInfo userSave = userInfoRepo.save(user);

		return userSave;
	}

	@Override
	public List<UserInfo> getAll() {
		
		return userInfoRepo.findAll();
	}

	@Override
	public UserInfo getUserById(Long id) {
		
		UserInfo user=userInfoRepo.findById(id).orElseThrow(()->new RuntimeException("User not found "+id));
	
		return user;
	}

	@Override
	public UserInfo update(Long id, UserInfoDto userInfoDto) {
	UserInfo user=	userInfoRepo.findById(id).orElseThrow(()->new RuntimeException("user not found "+id));
		
		user.setUsername(userInfoDto.getUsername());
		user.setPassword(passwordEncoder().encode(userInfoDto.getPassword()));
		return userInfoRepo.save(user);
	}

	@Override
	public void delete(Long id) {
		userInfoRepo.deleteById(id);
	}

}
