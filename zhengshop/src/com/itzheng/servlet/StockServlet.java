package com.itzheng.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzheng.entity.GoodType;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Stock;
import com.itzheng.entity.User;
import com.itzheng.entity.list.GoodsL;
import com.itzheng.service.GoodTypeService;
import com.itzheng.service.GoodsService;
import com.itzheng.service.ImagesService;
import com.itzheng.service.StockService;
import com.itzheng.service.impl.GoodTypeServiceImpl;
import com.itzheng.service.impl.GoodsServiceImpl;
import com.itzheng.service.impl.ImagesServiceImpl;
import com.itzheng.service.impl.StockServiceImpl;

/**
 * Servlet implementation class StockServlet
 */
public class StockServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GoodsService goodsService = new GoodsServiceImpl();

		GoodTypeService goodTypeService = new GoodTypeServiceImpl();

		ImagesService imagesService = new ImagesServiceImpl();

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		ArrayList<GoodType> goodtypearrayList = goodTypeService.getAllGoodType();

		request.getSession().setAttribute("goodtypearrayList", goodtypearrayList);

		System.out.println("==============");

		String method = request.getParameter("method");

		System.out.println(method);

		StockService stockService = new StockServiceImpl();

		if (method.equals("findAllStock")) {

			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");
			int firstpage = Integer.parseInt(request.getParameter("firstpage"));

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(goodname + "======" + goodtypecode + "========" + firstpage);

			int count = goodsService.findCountAllGoodsByNameOrType(goodname, goodtypecode);

			int pagenumber = 0;
			if (firstpage == 1 || firstpage == 0) {
				pagenumber = 0;
			} else {
				pagenumber = (firstpage - 1) * 5;
			}

			ArrayList<GoodsL> goodlist = stockService.findAllGoodsLByNameOrType(goodname, goodtypecode, pagenumber, 5);

			System.out.println(goodlist);

			// 查询出了对应的商品，根据商品

			request.setAttribute("maxPageNum", count / 5 + 1);
			request.setAttribute("goodlist", goodlist);
			request.setAttribute("firstpage", firstpage);

			request.setAttribute("goodname", goodname);
			request.setAttribute("goodtypecode", goodtypecode);
			request.getRequestDispatcher("/pages/stockshow.jsp").forward(request, response);

			return;
		}
		// addStock
		if (method.equals("addStock")) {

			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");

			int firstpage = 0;

			try {
				firstpage = Integer.parseInt(request.getParameter("firstpage"));
			} catch (Exception e) {
				// TODO: handle exception
			}

			// stockcode
			String stockcode = request.getParameter("stockcode");

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(goodname + "======" + goodtypecode + "========" + firstpage);

			Stock stock = stockService.findStockBystockcode(stockcode);

			int goodnumber = Integer.parseInt(stock.getGoodnumber());

			goodnumber = goodnumber + 1;

			stock.setGoodnumber(goodnumber + "");

			// 更新数据库
			boolean flag = stockService.updateStock(stock);

			// StockServlet?method=findAllStock
			/*
			 * href=
			 * "${pageContext.request.contextPath}/StockServlet?method=findAllStock&goodname=&goodtypecode=&firstpage=0"
			 * class="nav-link">
			 * 
			 */
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("StockServlet?method=findAllStock&name&goodname=&" + goodname + "goodtypecode="
					+ goodtypecode + "&firstpage=" + firstpage).forward(request, response);

			return;
		}

		// deleteStock
		if (method.equals("deleteStock")) {

			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");

			int firstpage = 0;

			try {
				firstpage = Integer.parseInt(request.getParameter("firstpage"));
			} catch (Exception e) {
				// TODO: handle exception
			}

			// stockcode
			String stockcode = request.getParameter("stockcode");

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(goodname + "======" + goodtypecode + "========" + firstpage);

			Stock stock = stockService.findStockBystockcode(stockcode);

			int goodnumber = Integer.parseInt(stock.getGoodnumber());

			goodnumber = goodnumber - 1;

			stock.setGoodnumber(goodnumber + "");

			// 更新数据库
			boolean flag = stockService.updateStock(stock);

			// StockServlet?method=findAllStock
			/*
			 * href=
			 * "${pageContext.request.contextPath}/StockServlet?method=findAllStock&goodname=&goodtypecode=&firstpage=0"
			 * class="nav-link">
			 * 
			 */
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("StockServlet?method=findAllStock&name&goodname=&" + goodname + "goodtypecode="
					+ goodtypecode + "&firstpage=" + firstpage).forward(request, response);

			return;
		}

		if (method.equals("findAllStockByUser1")) {

			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");
			int firstpage = Integer.parseInt(request.getParameter("firstpage"));

			User user = (User) request.getSession().getAttribute("user");

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(goodname + "======" + goodtypecode + "========" + firstpage);

			int count = goodsService.findCountAllGoodsByNameOrTypeUser1(goodname, goodtypecode, user.getUsercode());

			int pagenumber = 0;

			if (firstpage == 1 || firstpage == 0) {
				pagenumber = 0;
			} else {
				pagenumber = (firstpage - 1) * 5;
			}

			ArrayList<GoodsL> goodlist = stockService.findAllGoodsLByNameOrTypeUser1(goodname, goodtypecode, pagenumber,
					5, user.getUsercode());

			System.out.println(goodlist);

			// 查询出了对应的商品，根据商品

			request.setAttribute("maxPageNum", count / 5 + 1);
			request.setAttribute("goodlist", goodlist);
			request.setAttribute("firstpage", firstpage);

			request.setAttribute("goodname", goodname);
			request.setAttribute("goodtypecode", goodtypecode);
			request.getRequestDispatcher("/pages/stockshowuser.jsp").forward(request, response);

			return;
		}

		// addStockUser1
		if (method.equals("addStockUser1")) {

			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");

			int firstpage = 0;

			try {
				firstpage = Integer.parseInt(request.getParameter("firstpage"));
			} catch (Exception e) {
				// TODO: handle exception
			}

			// stockcode
			String stockcode = request.getParameter("stockcode");

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(goodname + "======" + goodtypecode + "========" + firstpage);

			Stock stock = stockService.findStockBystockcode(stockcode);

			int goodnumber = Integer.parseInt(stock.getGoodnumber());

			goodnumber = goodnumber + 1;

			stock.setGoodnumber(goodnumber + "");

			// 更新数据库
			boolean flag = stockService.updateStock(stock);

			// StockServlet?method=findAllStock
			/*
			 * href=
			 * "${pageContext.request.contextPath}/StockServlet?method=findAllStock&goodname=&goodtypecode=&firstpage=0"
			 * class="nav-link">
			 * 
			 */
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("StockServlet?method=findAllStockByUser1&name&goodname=&" + goodname + "goodtypecode="
					+ goodtypecode + "&firstpage=" + firstpage).forward(request, response);

			return;
		}

		// deleteStockUser1
		if (method.equals("deleteStockUser1")) {

			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");

			int firstpage = 0;

			try {
				firstpage = Integer.parseInt(request.getParameter("firstpage"));
			} catch (Exception e) {
				// TODO: handle exception
			}

			// stockcode
			String stockcode = request.getParameter("stockcode");

			// 先查询当前条件下所有的数据的条数，除以每页的数据条数就是，最大分页数量

			System.out.println(goodname + "======" + goodtypecode + "========" + firstpage);

			Stock stock = stockService.findStockBystockcode(stockcode);

			int goodnumber = Integer.parseInt(stock.getGoodnumber());

			goodnumber = goodnumber - 1;

			stock.setGoodnumber(goodnumber + "");

			// 更新数据库
			boolean flag = stockService.updateStock(stock);

			// StockServlet?method=findAllStock
			/*
			 * href=
			 * "${pageContext.request.contextPath}/StockServlet?method=findAllStock&goodname=&goodtypecode=&firstpage=0"
			 * class="nav-link">
			 * 
			 */
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("StockServlet?method=findAllStockByUser1&name&goodname=&" + goodname + "goodtypecode="
					+ goodtypecode + "&firstpage=" + firstpage).forward(request, response);

			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
