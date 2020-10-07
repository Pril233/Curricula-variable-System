package org.System.service.impl;

import org.System.dao.impl.SystemDaoImpl;

public class SystemServiceImpl {
	SystemDaoImpl sysdaoimpl = new SystemDaoImpl();
	
	public boolean checkLogin(String username,String password,String usertype) {
		return sysdaoimpl.check(username, password, usertype);
	}
}
