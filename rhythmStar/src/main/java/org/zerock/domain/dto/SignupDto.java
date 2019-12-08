package org.zerock.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {

	 private String name;
	   private String age;
	   private String sex;
	   private String id;
	   private String password;
	   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	   
	   
}
