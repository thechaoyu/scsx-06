package com.itzheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzheng.dao.UserDao;
import com.itzheng.dao.impl.UserDaoImpl;
import com.itzheng.entity.User;
import com.itzheng.service.UserService;
import com.itzheng.service.impl.UserServiceImpl;
import com.itzheng.utils.MyTime;
import com.itzheng.utils.UpdateFile;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class UserPhoneServlet
 */
public class UserPhoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("==============");

		String method = request.getParameter("method");

		System.out.println(method);
		
		UserService userService = new UserServiceImpl();
		
		if (method.equals("login")) {

			// 获取请求名字

			String email = request.getParameter("email");
			String password = request.getParameter("password");
	
			// 调用dao层
			
			
			User user = userService.getUserByEmailAndPassword(email, password);
	
			response.setContentType("application/x-json");
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
	
			JSONArray jsonArray = JSONArray.fromObject(user);
			out.print(jsonArray);
			System.out.println(jsonArray);
	
			out.flush();
			out.close();
			return;
		}
		//register
		if (method.equals("register")) {
			
			String username = request.getParameter("username");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			User user = new User();
			
			user.setUsercode(UpdateFile.getCodeUtils());
			user.setUsername(username);
			user.setPassword(password);
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setUsertype("2");
			user.setState("1");
			user.setDate(MyTime.getTime());
			
			boolean flag = userService.addUserSubmit(user);
			
			PrintWriter out = response.getWriter();
			
			out.print(flag);
	
			out.flush();
			
			out.close();
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
