package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.dto.User.LoginDto;
import org.zerock.domain.dto.User.LoginResponseDto;
import org.zerock.domain.dto.User.SignupDto;
import org.zerock.domain.dto.User.UpdateDto;
import org.zerock.domain.entity.User;
import org.zerock.repository.UserRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UserService {
	
	final private UserRepository userRepository;

	  public UserService(UserRepository userRepository) {
	      this.userRepository = userRepository;
	  }
	  
	  //회원가입
	  public void createUser (SignupDto signup) {
		  
		  User user=new User();
		  
		  user.setName(signup.getName());
		  user.setId(signup.getId());
		  user.setPassword(signup.getPassword());
		  
		  userRepository.save(user);
	  }
	  
	  //회원수정
	  public void updateUser (UpdateDto update) {
	
		 User user=userRepository.findByName(update.getName());
		  user.setId(update.getId());
		  user.setPassword(update.getPassword());
		 
		  userRepository.save(user);
		  
	  }
	  
	  //로그인
	  public LoginResponseDto LoginUser (LoginDto login) {
		  
		 User user=userRepository.findById(login.getId());
		 LoginResponseDto loginmsg=new LoginResponseDto();
		 
		 //회원가입이 안되어있을때 
		 if(user==null) {
			 String response= "dont have id";
			 loginmsg.setMsg(response);
			 return loginmsg;
			 }
		 else if(!user.getPassword().equals(login.getPassword())) {
			 String response= "password is wrong";
			 loginmsg.setMsg(response);
			 return loginmsg;
		 }
		 String response ="loging success";
		 loginmsg.setMsg(response);
		 return loginmsg;
	}
	  
}
