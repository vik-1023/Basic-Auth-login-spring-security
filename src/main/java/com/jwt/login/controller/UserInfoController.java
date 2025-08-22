package com.jwt.login.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.login.entity.UserInfo;
import com.jwt.login.service.UseServiceImpl;
import com.jwt.login.userInfoDto.UserInfoDto;

@RestController
public class UserInfoController {

	private UseServiceImpl useServiceImpl;

	public UserInfoController(UseServiceImpl useServiceImpl) {
		super();
		this.useServiceImpl = useServiceImpl;
	}

	@PostMapping("/create")
	public ResponseEntity<UserInfo> createUser(@RequestBody UserInfoDto userDto) {

		return ResponseEntity.status(201).body(useServiceImpl.create(userDto));
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserInfo>> getAll() {
		return ResponseEntity.ok(useServiceImpl.getAll());
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<UserInfo> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(useServiceImpl.getUserById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> UpdateUser(@PathVariable Long id, @RequestBody UserInfoDto userInfoDto) {
		useServiceImpl.update(id, userInfoDto);
		return ResponseEntity.ok("User Updated successFully");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		useServiceImpl.delete(id);
		return ResponseEntity.ok("user Deleted Successfully");
	}

}
