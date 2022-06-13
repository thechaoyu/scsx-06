package com.itzheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzheng.entity.Car;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Orderdetail;
import com.itzheng.entity.Orders;
import com.itzheng.service.CarService;
import com.itzheng.service.GoodsService;
import com.itzheng.service.OrdersService;
import com.itzheng.service.impl.CarServiceImpl;
import com.itzheng.service.impl.GoodsServiceImpl;
import com.itzheng.service.impl.OrdersServiceImpl;
import com.itzheng.utils.MyTime;
import com.itzheng.utils.UpdateFile;
import com.mysql.fabric.xmlrpc.base.Array;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class OrderPhoneServlet
 */
public class OrderPhoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("==============");
		CarService carService = new CarServiceImpl();
		String method = request.getParameter("method");

		OrdersService ordersService = new OrdersServiceImpl();

		System.out.println(method);

		if (method.equals("addOrder")) {

			String usercode[] = request.getParameterValues("usercode");
			String goodcode[] = request.getParameterValues("goodcode");
			String goodnumber[] = request.getParameterValues("goodnumber");
			ArrayList<Car> arrayListcar = new ArrayList<Car>();
			for (int i = 0; i < usercode.length; i++) {
				Car car = new Car();
				car.setUsercode(usercode[i]);
				car.setGoodcode(goodcode[i]);
				car.setGoodnumber(goodnumber[i]);
				arrayListcar.add(car);

			}

			String ordercode = ordersService.addOrders(arrayListcar);

			String message = "";

			if (ordercode.length() > 1) {
				message = ordercode;
			}

			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();

			out.print(message);

			out.flush();
			out.close();
			return;

		}
		// addOrderBynow

		if (method.equals("addOrderBynow")) {

			String usercode[] = request.getParameterValues("usercode");
			String goodcode[] = request.getParameterValues("goodcode");
			String goodnumber[] = request.getParameterValues("goodnumber");
			ArrayList<Car> arrayListcar = new ArrayList<Car>();
			for (int i = 0; i < usercode.length; i++) {
				Car car = new Car();
				car.setUsercode(usercode[i]);
				car.setGoodcode(goodcode[i]);
				car.setGoodnumber(goodnumber[i]);
				arrayListcar.add(car);

			}

			String ordercode = ordersService.addOrdersByNow(arrayListcar);

			String message = "";

			if (ordercode.length() > 1) {
				message = ordercode;
			}

			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();

			out.print(message);

			out.flush();
			out.close();
			return;

		}

		// findOrders
		if (method.equals("findOrders")) {

			String ordercode = request.getParameter("ordercode");

			ArrayList<Goods> arrayListgoods = ordersService.getOrderGoodListByOrderCode(ordercode);

			response.setContentType("application/x-json");

			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter();

			JSONArray jsonArray = JSONArray.fromObject(arrayListgoods);

			out.print(jsonArray);

			out.flush();

			out.close();

			return;

		}
		// submitOrders
		if (method.equals("submitOrders")) {

			String ordercode = request.getParameter("ordercode");

			// 同时修改订单和订单详情

			boolean flag = ordersService.updateOrderAndOrderdetail(ordercode);

			String message = "";

			if (flag) {
				message = "成功";

			}

			response.setContentType("application/x-json");

			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter();

			out.print(message);

			out.flush();

			out.close();

			return;
		}
		// findGoodsByUsercode
		if (method.equals("findGoodsByUsercode")) {

			System.out.println("==111111111111111111111111111111111=====");

			String usercode = request.getParameter("usercode");
			String state = request.getParameter("state");

			System.out.println(usercode + "==1111=====" + state);

			ArrayList<Orders> arrayListgoods = ordersService.getOrderGoodListByUsercode(usercode, state);

			
			for (Orders orders : arrayListgoods) {
				System.out.println(orders);
			}

			response.setContentType("application/x-json");

			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter();

			JSONArray jsonArray = JSONArray.fromObject(arrayListgoods);

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
