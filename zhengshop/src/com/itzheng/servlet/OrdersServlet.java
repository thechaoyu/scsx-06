package com.itzheng.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzheng.entity.GoodType;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Orders;
import com.itzheng.entity.User;
import com.itzheng.service.GoodTypeService;
import com.itzheng.service.GoodsService;
import com.itzheng.service.ImagesService;
import com.itzheng.service.OrdersService;
import com.itzheng.service.impl.GoodTypeServiceImpl;
import com.itzheng.service.impl.GoodsServiceImpl;
import com.itzheng.service.impl.ImagesServiceImpl;
import com.itzheng.service.impl.OrdersServiceImpl;

/**
 * Servlet implementation class OrdersServlet
 */
public class OrdersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String method = request.getParameter("method");

		System.out.println(method);

		OrdersService ordersService = new OrdersServiceImpl();

		if (method.equals("findAllOrdersByOrdercode")) {
			String ordercode = request.getParameter("ordercode");
			int firstpage = Integer.parseInt(request.getParameter("firstpage"));

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(ordercode + "==============" + firstpage);

			int count = ordersService.findAllOrdersCountByOrdercode(ordercode);

			int pagenumber = 0;
			if (firstpage == 1 || firstpage == 0) {
				pagenumber = 0;
			} else {
				pagenumber = (firstpage - 1) * 5;
			}

			ArrayList<Orders> orderslist = ordersService.findAllOrdersByOrdercode(ordercode, pagenumber, 5);
			System.out.println(orderslist);
			request.setAttribute("maxPageNum", count / 5 + 1);
			request.setAttribute("orderslist", orderslist);
			request.setAttribute("firstpage", firstpage);
			request.setAttribute("ordercode", ordercode);
			// GoodsServlet?method=findAllGoodsByNameOrType&goodname=&goodtypecode=&firstpage=0
			request.getRequestDispatcher("/pages/ordershow.jsp").forward(request, response);

			return;
		}

		// deliverGoods 
		if (method.equals("confirmGoodsuser")) {

			String ordercode = request.getParameter("ordercode");

			boolean flag = ordersService.updateOrderAndOrderdetail(ordercode, "3");

			request.getRequestDispatcher(
					"OrdersServlet?method=findAllOrdersByOrdercodeAndUsercode=" + ordercode + "&firstpage=0")
					.forward(request, response);
			return;
		}
		// confirmGoods
		if (method.equals("deliverGoodsuser")) {

			String ordercode = request.getParameter("ordercode");

			boolean flag = ordersService.updateOrderAndOrderdetail(ordercode, "4");

			request.getRequestDispatcher(
					"OrdersServlet?method=findAllOrdersByOrdercodeAndUsercode=" + ordercode + "&firstpage=0")
					.forward(request, response);
			return;
		}

		// deliverGoods
		if (method.equals("confirmGoods")) {

			String ordercode = request.getParameter("ordercode");

			boolean flag = ordersService.updateOrderAndOrderdetail(ordercode, "3");

			request.getRequestDispatcher(
					"OrdersServlet?method=findAllOrdersByOrdercode&ordercode=" + ordercode + "&firstpage=0")
					.forward(request, response);
			return;
		}
		// confirmGoods
		if (method.equals("deliverGoods")) {

			String ordercode = request.getParameter("ordercode");

			boolean flag = ordersService.updateOrderAndOrderdetail(ordercode, "4");

			request.getRequestDispatcher(
					"OrdersServlet?method=findAllOrdersByOrdercode&ordercode=" + ordercode + "&firstpage=0")
					.forward(request, response);
			return;
		}
		// findAllOrdersByOrdercodeAndUsercode
		if (method.equals("findAllOrdersByOrdercodeAndUsercode")) {
			String ordercode = request.getParameter("ordercode");
			int firstpage = Integer.parseInt(request.getParameter("firstpage"));

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(ordercode + "==============" + firstpage);

			User user = (User) request.getSession().getAttribute("user");

			int count = ordersService.findAllOrdersCountByOrdercode(ordercode, user.getUsercode());

			int pagenumber = 0;
			if (firstpage == 1 || firstpage == 0) {
				pagenumber = 0;
			} else {
				pagenumber = (firstpage - 1) * 5;
			}

			ArrayList<Orders> orderslist = ordersService.findAllOrdersByOrdercode(ordercode, user.getUsercode(),
					pagenumber, 5);
			System.out.println(orderslist);
			request.setAttribute("maxPageNum", count / 5 + 1);
			request.setAttribute("orderslist", orderslist);
			request.setAttribute("firstpage", firstpage);
			request.setAttribute("ordercode", ordercode);
			// GoodsServlet?method=findAllGoodsByNameOrType&goodname=&goodtypecode=&firstpage=0
			request.getRequestDispatcher("/pages/ordershowuser.jsp").forward(request, response);

			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
