package org.System.service;

import java.util.List;

import org.apache.catalina.User;

public interface IUserService {
	public boolean addUser(User user);
	
	public boolean deleteUserById(int id);
	
	public List<org.System.entity.User> queryAllUser();
	
	public User queryUserById(int id);
	
	public List<User> queryUserBypage(int currentPage,int pageSize);
	
	public boolean updateStudentById(int id,User user);
	
	
	
}
