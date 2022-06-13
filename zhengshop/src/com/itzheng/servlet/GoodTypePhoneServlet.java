package com.itzheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzheng.entity.GoodType;
import com.itzheng.service.GoodTypeService;
import com.itzheng.service.impl.GoodTypeServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GoodTypePhoneServlet
 */
public class GoodTypePhoneServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		GoodTypeService goodtypeService = new GoodTypeServiceImpl();

		System.out.println("==============");

		String method = request.getParameter("method");

		System.out.println(method);


		if (method.equals("findGoodType")) {

			
			ArrayList<GoodType> goodtypelist = goodtypeService.findAllGoodtypeByTypename("", 0, 100);
			
			response.setContentType("application/x-json");
			
			response.setCharacterEncoding("utf-8");
			
			PrintWriter out = response.getWriter();
			
			JSONArray jsonArray = JSONArray.fromObject(goodtypelist);
			
			out.print(jsonArray);

			out.flush();
			
			out.close();
			
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
