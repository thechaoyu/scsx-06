package com.itzheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzheng.entity.Car;
import com.itzheng.service.CarService;
import com.itzheng.service.GoodsService;
import com.itzheng.service.ImagesService;
import com.itzheng.service.impl.CarServiceImpl;
import com.itzheng.service.impl.GoodsServiceImpl;
import com.itzheng.service.impl.ImagesServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CarPhoneServlet
 */
public class CarPhoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("==============");

		String method = request.getParameter("method");

		System.out.println(method);

		CarService carService = new CarServiceImpl();

		if (method.equals("addCarByGoodcodeAndusercode")) {

			String goodcode = request.getParameter("goodcode");
			String usercode = request.getParameter("usercode");

			boolean flag = carService.addCarByGoodcodeAndusercode(goodcode, usercode);

			response.setContentType("application/x-json");

			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter();
			
			String f = "";
			
			if(flag) {
				f = "成功";
			}

			out.print(f);

			out.flush();

			out.close();
			
			return;
		}
		if (method.equals("findCars")) {
			
			
			String usercode = request.getParameter("usercode");
			
			
			ArrayList<Car> carlist = carService.findCars(usercode);
			
			
			
			response.setContentType("application/x-json");
			
			response.setCharacterEncoding("utf-8");
			
			PrintWriter out = response.getWriter();
			
			JSONArray jsonArray = JSONArray.fromObject(carlist);
			
			System.out.println(jsonArray);
			out.print(jsonArray);

			out.flush();
			
			out.close();
			
			return;
			
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
