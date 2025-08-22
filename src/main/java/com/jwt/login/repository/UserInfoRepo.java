package com.jwt.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.login.entity.UserInfo;
@Repository
public interface UserInfoRepo  extends JpaRepository<UserInfo, Long>{

}
