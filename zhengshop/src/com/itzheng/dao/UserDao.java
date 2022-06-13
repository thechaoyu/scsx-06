package com.itzheng.dao;

import java.util.ArrayList;

import com.itzheng.entity.User;

public interface UserDao {

	int findCountUserByNameOrEmail(String name, String email);

	ArrayList<User> findAllUserByNameOrEmail(String name, String email, int firstpage, int page);

	boolean addUserSubmit(User user);

	User findUserByusercode(String usercode);

	boolean updateUserSubmit(User user);

	boolean updateUserSubmitImg(User user);

	boolean deleteUserBycode(String usercode);

	User getUserByEmailAndPassword(String email, String password);

}
