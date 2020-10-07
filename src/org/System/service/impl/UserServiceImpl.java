package org.System.service.impl;

import java.util.List;

import org.System.dao.IUserDao;
import org.System.dao.impl.UserDaoimpl;
import org.System.service.IUserService;
import org.apache.catalina.User;


public class UserServiceImpl implements IUserService{
		IUserDao userdao = new UserDaoimpl();

	public boolean addUser(User user) {
		return userdao.addUser((org.System.entity.User) user);
	}

	@Override
	public boolean deleteUserById(int id) {
		if(userdao.isExist(id)) {
			return userdao.deleteUserById(id);
		}
		else
			System.out.print("要删除的id不存在");
			return false;
		
	}

	@Override
	public List<org.System.entity.User> queryAllUser() {
		return userdao.queryAllUser();
	}

	@Override
	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryUserBypage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStudentById(int id, User user) {
		// TODO Auto-generated method stub
		return false;
	}




}
