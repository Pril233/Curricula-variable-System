package org.System.dao;
import java.util.List;

import org.System.entity.User;

public interface IUserDao {
	public boolean addUser(User user);
	
	public boolean deleteUserById(int id);
	
	public List<User> queryAllUser();
	
	public User queryUserByusername(String username);
	
	public boolean UpdateUserByusername(String username,User user);
	
	public boolean isExist(int id);
	
	public List<User> queryUserBypage(int currentPage,int pageSize);
	
	public User queryUserById(int id);
	
	
	
	
	
	
}
