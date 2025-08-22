package com.jwt.login.service;

import java.util.List;

import com.jwt.login.entity.UserInfo;
import com.jwt.login.userInfoDto.UserInfoDto;

public interface UserInfoService {

	UserInfo create(UserInfoDto userInfoDto);

	List<UserInfo> getAll();

	UserInfo getUserById(Long id);

	UserInfo update(Long id, UserInfoDto userInfoDto);

	void delete(Long id);

}
