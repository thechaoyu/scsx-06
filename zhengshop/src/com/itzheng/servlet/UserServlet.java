package com.itzheng.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.RandomStringUtils;

import com.itzheng.entity.User;
import com.itzheng.service.UserService;
import com.itzheng.service.impl.UserServiceImpl;
import com.itzheng.utils.UpdateFile;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		UserService userService = new UserServiceImpl();
		System.out.println("==============");

		String method = request.getParameter("method");

		System.out.println(method);

		// login
		if (method.equals("login")) {
			
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User user = userService.getUserByEmailAndPassword(email,password);
			
			System.out.println(user);
			
			if(user == null) {
				request.setAttribute("message", "登录失败");
				response.sendRedirect(request.getServletContext().getContextPath() + "/login.jsp");
				return;
			}			
			request.getSession().setAttribute("user", user);
			
			response.sendRedirect(request.getServletContext().getContextPath() + "/index.jsp");
			return;
		}

		if (method.equals("findAllUserByNameOrEmail")) {

			String name = request.getParameter("name");
			String email = request.getParameter("email");

			int firstpage = Integer.parseInt(request.getParameter("firstpage"));

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(name + "======" + email + "========" + firstpage);

			int count = userService.findCountUserByNameOrEmail(name, email);

			int pagenumber = 0;
			if (firstpage == 1 || firstpage == 0) {
				pagenumber = 0;
			} else {
				pagenumber = (firstpage - 1) * 5;
			}

			ArrayList<User> userlist = userService.findAllUserByNameOrEmail(name, email, pagenumber, 5);

			request.setAttribute("maxPageNum", count / 5 + 1);
			request.setAttribute("userlist", userlist);
			request.setAttribute("firstpage", firstpage);

			request.setAttribute("name", name);
			request.setAttribute("email", email);

			request.getRequestDispatcher("/pages/usershow.jsp").forward(request, response);

			return;
		}
		// addUser
		if (method.equals("addUser")) {
			response.sendRedirect(request.getServletContext().getContextPath() + "/pages/useradd.jsp");
			return;
		}
		// addUserSubmit
		if (method.equals("addUserSubmit")) {

			String username = request.getParameter("username");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String date = request.getParameter("date");

			System.out.println(username + "---" + name + "---" + date);

			// 设置上传文件
			UpdateFile updateFile = new UpdateFile();

			User user = updateFile.uploadFileOneUser(request, response, this);

			System.out.println(user + "----");

			user.setUsercode(getCode());

			System.out.println(user);

			boolean addUserSubmit = userService.addUserSubmit(user);

			if (!addUserSubmit) {

				request.setAttribute("message", "添加失败");
				request.getRequestDispatcher("/addStoreShowStoreType").forward(request, response);
				return;
			}
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			// UserServlet?method=findAllUserByNameOrEmail&name=&email=&firstpage=0
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("UserServlet?method=findAllUserByNameOrEmail&name=" + user.getName()
					+ "&email=" + user.getEmail() + "&firstpage=0").forward(request, response);

			return;

		}
		// userUpdate
		if (method.equals("userUpdate")) {

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String usercode = request.getParameter("usercode");

			User user = userService.findUserByusercode(usercode);

			System.out.println(user);

			request.setAttribute("user", user);
			request.setAttribute("name", name);
			request.setAttribute("email", email);

			request.getRequestDispatcher("/pages/userupdate.jsp").forward(request, response);
			return;
		}
		// updateUserSubmit
		if (method.equals("updateUserSubmit")) {

			String username = request.getParameter("username");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String date = request.getParameter("date");

			System.out.println(username + "---" + name + "---" + date);

			// 设置上传文件
			UpdateFile updateFile = new UpdateFile();

			User user = updateFile.uploadFileOneUserUpdate(request, response, this);

			System.out.println(user + "----");

			// user.setUsercode(getCode());

			System.out.println(user);
			boolean updateUserSubmit = false;

			updateUserSubmit = userService.updateUserSubmit(user);

			// boolean addUserSubmit = userService.addUserSubmit(user);

			if (!updateUserSubmit) {

				request.setAttribute("message", "修改失败");
				request.getRequestDispatcher("/addStoreShowStoreType").forward(request, response);
				return;
			}
			request.setAttribute("name", user.getName());
			request.setAttribute("email", user.getEmail());
			// vUserServlet?method=findAllUserByNameOrEmail&name=&email=&firstpage=0
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher("UserServlet?method=findAllUserByNameOrEmail&name=" + user.getName()
					+ "&email=" + user.getEmail() + "&firstpage=0").forward(request, response);

			return;

		}
		// deleteUserBycode
		if (method.equals("deleteUserBycode")) {

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String usercode = request.getParameter("usercode");

			boolean del = userService.deleteUserBycode(usercode);

			if (!del) {

				request.setAttribute("message", "修改失败");
				request.getRequestDispatcher("/addStoreShowStoreType").forward(request, response);
				return;
			}
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			// vUserServlet?method=findAllUserByNameOrEmail&name=&email=&firstpage=0
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher(
					"UserServlet?method=findAllUserByNameOrEmail&name=" + name + "&email=" + email + "&firstpage=0")
					.forward(request, response);

			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String getCode() {
		String a = RandomStringUtils.random(16, "abcdefghijklmnopqrstuvwxyz1234567890");
		System.out.println(a);
		return a;
	}

}
