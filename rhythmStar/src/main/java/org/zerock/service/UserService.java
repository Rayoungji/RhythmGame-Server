package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.dto.LoginDto;
import org.zerock.domain.dto.SignupDto;
import org.zerock.domain.dto.UpdateDto;
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
	  public String LoginUser (LoginDto login) {
		  
		 User user=userRepository.findById(login.getId());
		 
		 //회원가입이 안되어있을때 
		 if(user==null) {
			 return "dont have id";
			 }
		 else if(!user.getPassword().equals(login.getPassword())) {
			 return "password is wrong";
		 }
		 return "loging success";
	}
	  
}
