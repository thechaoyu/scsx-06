package com.itzheng.service.impl;

import java.util.ArrayList;

import com.itzheng.dao.UserDao;
import com.itzheng.dao.impl.UserDaoImpl;
import com.itzheng.entity.User;
import com.itzheng.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userdao = new UserDaoImpl();

	@Override
	public int findCountUserByNameOrEmail(String name, String email) {
		// TODO Auto-generated method stub
		return userdao.findCountUserByNameOrEmail(name, email);
	}

	@Override
	public ArrayList<User> findAllUserByNameOrEmail(String name, String email, int firstpage, int page) {
		// TODO Auto-generated method stub
		return userdao.findAllUserByNameOrEmail(name, email, firstpage, page);
	}

	@Override
	public boolean addUserSubmit(User user) {
		// TODO Auto-generated method stub
		return userdao.addUserSubmit(user);
	}

	@Override
	public User findUserByusercode(String usercode) {
		// TODO Auto-generated method stub
		return userdao.findUserByusercode(usercode);
	}

	@Override
	public boolean updateUserSubmit(User user) {
		// TODO Auto-generated method stub

		if (user.getImage() == null || user.getImage().equals("")) {
			return userdao.updateUserSubmit(user);
		}

		return userdao.updateUserSubmitImg(user);
	}

	@Override
	public boolean deleteUserBycode(String usercode) {
		// TODO Auto-generated method stub
		return userdao.deleteUserBycode(usercode);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userdao.getUserByEmailAndPassword(email,password);
	}

}
