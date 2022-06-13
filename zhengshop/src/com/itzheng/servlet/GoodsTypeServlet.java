package com.itzheng.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;

import com.itzheng.entity.GoodType;
import com.itzheng.entity.User;
import com.itzheng.service.GoodTypeService;
import com.itzheng.service.UserService;
import com.itzheng.service.impl.GoodTypeServiceImpl;
import com.itzheng.service.impl.UserServiceImpl;
import com.itzheng.utils.UpdateFile;

/**
 * Servlet implementation class GoodsTypeServlet
 */
public class GoodsTypeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		GoodTypeService goodtypeService = new GoodTypeServiceImpl();

		System.out.println("==============");

		String method = request.getParameter("method");

		System.out.println(method);

		// findAllGoodsTypeByNameOrType
		if (method.equals("findCountGoodtypeByTypename")) {

			// typename
			String typename = request.getParameter("typename");
			int firstpage = Integer.parseInt(request.getParameter("firstpage"));
			System.out.println(typename + "======" + firstpage + "========" + firstpage);

			int count = goodtypeService.findCountGoodtypeByTypename(typename);

			int pagenumber = 0;
			if (firstpage == 1 || firstpage == 0) {
				pagenumber = 0;
			} else {
				pagenumber = (firstpage - 1) * 5;
			}
			ArrayList<GoodType> goodtypelist = goodtypeService.findAllGoodtypeByTypename(typename, pagenumber, 5);

			request.setAttribute("maxPageNum", count / 5 + 1);
			request.setAttribute("goodtypelist", goodtypelist);
			request.setAttribute("firstpage", firstpage);

			request.setAttribute("typename", typename);

			request.getRequestDispatcher("/pages/goodtypeshow.jsp").forward(request, response);

			return;

		}

		if (method.equals("addGoodtype")) {

			// typename
			String typename = request.getParameter("typename");
			int firstpage = Integer.parseInt(request.getParameter("firstpage"));
			System.out.println(typename + "======" + firstpage + "========" + firstpage);

			request.setAttribute("typename", typename);

			response.sendRedirect(request.getServletContext().getContextPath() + "/pages/goodtypeadd.jsp");
			return;

		}
		// addGoodTypeSubmit

		if (method.equals("addGoodTypeSubmit")) {

			// typename
			String typename = request.getParameter("typename");

			System.out.println(typename);

			GoodType goodType = new GoodType();

			goodType.setGoodtypecode(getCode());
			goodType.setTypename(typename);

			System.out.println(goodType);

			boolean flag = goodtypeService.addGoodtype(goodType);

			// goodtypecode
			request.getRequestDispatcher(
					"GoodsTypeServlet?method=findCountGoodtypeByTypename&typename=" + typename + "&firstpage=0")
					.forward(request, response);
			return;

		}
		// updateGoodType
		if (method.equals("updateGoodType")) {

			// goodtypecode
			String goodtypecode = request.getParameter("goodtypecode");

			GoodType goodType = goodtypeService.findGoodTypeBygoodtypecode(goodtypecode);

			request.setAttribute("goodType", goodType);

			request.getRequestDispatcher("/pages/goodtypeupdate.jsp").forward(request, response);
			return;

		}
		// updateGoodTypeSubmit
		if (method.equals("updateGoodTypeSubmit")) {

			// typename
			String typename = request.getParameter("typename");
			// goodtypecode
			String goodtypecode = request.getParameter("goodtypecode");

			System.out.println(typename);

			GoodType goodType = new GoodType();

			goodType.setGoodtypecode(goodtypecode);
			goodType.setTypename(typename);

			System.out.println(goodType);

			boolean flag = goodtypeService.updateGoodtype(goodType);

			// goodtypecode
			request.getRequestDispatcher(
					"GoodsTypeServlet?method=findCountGoodtypeByTypename&typename=" + typename + "&firstpage=0")
					.forward(request, response);
			return;

		}
		// deleteGoodsTypeBygoodcode   typename
		if (method.equals("deleteGoodsTypeBygoodcode")) {

			// typename
			String typename = request.getParameter("typename");
			
			// goodtypecode
			String goodtypecode = request.getParameter("goodtypecode");

			System.out.println(typename + "===" + goodtypecode);

			boolean flag = goodtypeService.deleteGoodtypeByTypecode(goodtypecode);
			// goodtypecode
			request.getRequestDispatcher(
					"GoodsTypeServlet?method=findCountGoodtypeByTypename&typename=" + typename + "&firstpage=0")
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
