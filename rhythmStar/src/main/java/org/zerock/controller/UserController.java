package org.zerock.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.dto.LoginDto;
import org.zerock.domain.dto.SignupDto;
import org.zerock.domain.dto.UpdateDto;
import org.zerock.service.UserService;

@RestController
public class UserController {
	final private UserService userservice;

	  public UserController(UserService userservice) {
	      this.userservice = userservice;
	  }
	
	//회원가입
	@RequestMapping(value="/User/SignUp", method=RequestMethod.POST)
	public void Signup(@RequestBody SignupDto signup) {

		userservice.createUser(signup);
	}
	
	//회원정보 수정
	@RequestMapping(value="/User/Update", method=RequestMethod.PUT)
	public void Update(@RequestBody UpdateDto update) {
		
		userservice.updateUser(update);
	}
	
	//로그인
	@RequestMapping(value="/User/Login", method=RequestMethod.POST)
	public String Login(@RequestBody LoginDto login) {
	
		return userservice.LoginUser(login);
	}
}
