package com.itzheng.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzheng.entity.GoodType;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Images;
import com.itzheng.entity.Stock;
import com.itzheng.entity.User;
import com.itzheng.service.GoodTypeService;
import com.itzheng.service.GoodsService;
import com.itzheng.service.ImagesService;
import com.itzheng.service.StockService;
import com.itzheng.service.impl.GoodTypeServiceImpl;
import com.itzheng.service.impl.GoodsServiceImpl;
import com.itzheng.service.impl.ImagesServiceImpl;
import com.itzheng.service.impl.StockServiceImpl;
import com.itzheng.utils.MyTime;
import com.itzheng.utils.UpdateFile;

/**
 * Servlet implementation class GoodsServlet
 */
public class GoodsServlet extends HttpServlet {

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

		if (method.equals("findAllGoodsByNameOrType")) {
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

			ArrayList<Goods> goodlist = goodsService.findAllGoodsByNameOrType(goodname, goodtypecode, pagenumber, 5);

			System.out.println(goodlist);
			request.setAttribute("maxPageNum", count / 5 + 1);
			request.setAttribute("goodlist", goodlist);
			request.setAttribute("firstpage", firstpage);

			request.setAttribute("goodname", goodname);
			request.setAttribute("goodtypecode", goodtypecode);
			// GoodsServlet?method=findAllGoodsByNameOrType&goodname=&goodtypecode=&firstpage=0
			request.getRequestDispatcher("/pages/goodshow.jsp").forward(request, response);

			return;
		}
		if (method.equals("addGood")) {
			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");

			request.setAttribute("goodtypecode", goodtypecode);
			request.setAttribute("goodname", goodname);

			response.sendRedirect(request.getServletContext().getContextPath() + "/pages/goodadd.jsp");
			return;
		}
		if (method.equals("addGoodSunmit")) {
			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");
			User user = (User) request.getSession().getAttribute("user");

			StockService stockService = new StockServiceImpl();

			String usercode = user.getUsercode();

			UpdateFile file = new UpdateFile();

			Goods goods = file.uploadFileGood(request, response, this);

			goods.setGoodcode(file.getCode());

			goods.setGoodusercode(usercode);

			goods.setGoodstate("0");

			goods.setGooddate(MyTime.getTime());

			goods.setGoodimagecode(file.getCode());

			// 添加商品，先将商品添加到商品的数据库当中。
			boolean addGoodflag = goodsService.addGood(goods);

			// 将当前商品添加到库存表当中

			boolean addStock = false;

			if (addGoodflag) {

				Stock stock = new Stock();

				stock.setStockcode(file.getCode());

				stock.setGoodcode(goods.getGoodcode());

				stock.setGoodnumber("1");

				stock.setUsercode(usercode);

				addStock = stockService.addStock(stock);

			}

			System.out.println(goods);
			request.setAttribute("goodtypecode", goodtypecode);
			request.setAttribute("goodname", goodname);
			/*
			 * ${pageContext.request.contextPath}/GoodsServlet?method=
			 * findAllGoodsByNameOrType&firstpage=0" method="post"
			 */
			request.getRequestDispatcher("GoodsServlet?method=findAllGoodsByNameOrType&goodname=" + goods.getGoodname()
					+ "&goodtypecode=" + goods.getGoodtypecode() + "&firstpage=0").forward(request, response);
			return;
		}
		// 根据goodcode查询对应的方法
		if (method.equals("findGoodDetailBygoodcode")) {
			String goodcode = request.getParameter("goodcode");

			Goods goods = goodsService.findGoodDetailBygoodcode(goodcode);

			Images images = imagesService.getImageByImageCode(goods.getGoodimagecode());

			System.out.println(goods + "==" + images);
			request.setAttribute("goods", goods);
			request.setAttribute("images", images);
			request.getRequestDispatcher("/pages/goodshow-detail.jsp").forward(request, response);
			return;
		}
		if (method.equals("updateGood")) {
			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");
			String goodcode = request.getParameter("goodcode");
			
			int firstpage =0;
			try {
				firstpage = Integer.parseInt(request.getParameter("firstpage"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			

			Goods goods = goodsService.findGoodDetailBygoodcodegoodtypecode(goodcode);

			Images images = imagesService.getImageByImageCode(goods.getGoodimagecode());
			
			
			System.out.println(goods + "==" + images);
			request.setAttribute("goods", goods);
			request.setAttribute("images", images);

			request.setAttribute("goodtypecode", goodtypecode);
			request.setAttribute("goodname", goodname);
			request.setAttribute("firstpage", firstpage);

			request.getRequestDispatcher("/pages/goodupdate.jsp").forward(request, response);
			return;
		}
		//updateGoodSunmit
		if (method.equals("updateGoodSubmit")) {
			
			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");
			User user = (User) request.getSession().getAttribute("user");


			String usercode = user.getUsercode();

			UpdateFile file = new UpdateFile();

			//更新商品
			Goods goods = file.uploadFileOneGoodUpdate(request, response, this);


			goods.setGoodusercode(usercode);

			goods.setGoodstate("0");

			goods.setGooddate(MyTime.getTime());

			// 更新商品，先将商品添加到商品的数据库当中。


			System.out.println(goods);
			
			boolean flag = goodsService.updateGood(goods);
			
			
			request.setAttribute("goodtypecode", goodtypecode);
			request.setAttribute("goodname", goodname);
			/*
			 * ${pageContext.request.contextPath}/GoodsServlet?method=
			 * findAllGoodsByNameOrType&firstpage=0" method="post"
			 */
			request.getRequestDispatcher("GoodsServlet?method=findAllGoodsByNameOrType&goodname=" + goods.getGoodname()
					+ "&goodtypecode=" + goods.getGoodtypecode() + "&firstpage=0").forward(request, response);
			
			return;
			
		}
		//deleteGoodBygoodcode
		if (method.equals("deleteGoodBygoodcode")) {
			String goodname = request.getParameter("goodname");
			String goodtypecode = request.getParameter("goodtypecode");
			String goodcode = request.getParameter("goodcode");

			Goods goods = goodsService.findGoodDetailBygoodcode(goodcode);
			
			boolean flagimage = imagesService.deleteImageByimagecode(goods.getGoodimagecode());
			
			boolean flaggood = goodsService.deleteGoodBygoodcode(goodcode);

			//System.out.println(goods + "==" + images);
			request.setAttribute("goodname", goodname);
			request.setAttribute("goodtypecode", goodtypecode);
			request.setAttribute("goodcode", goodcode);
			request.getRequestDispatcher("GoodsServlet?method=findAllGoodsByNameOrType&goodname=" + goods.getGoodname()
			+ "&goodtypecode=" + goods.getGoodtypecode() + "&firstpage=0").forward(request, response);
			return;
		}
		
		
		//findAllGoodsByNameOrTypeExamine
		if (method.equals("findAllGoodsByNameOrTypeExamine")) {
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

			ArrayList<Goods> goodlist = goodsService.findAllGoodsByNameOrType(goodname, goodtypecode, pagenumber, 5);

			System.out.println(goodlist);
			request.setAttribute("maxPageNum", count / 5 + 1);
			request.setAttribute("goodlist", goodlist);
			request.setAttribute("firstpage", firstpage);

			request.setAttribute("goodname", goodname);
			request.setAttribute("goodtypecode", goodtypecode);
			// GoodsServlet?method=findAllGoodsByNameOrType&goodname=&goodtypecode=&firstpage=0
			request.getRequestDispatcher("/pages/goodshowexamine.jsp").forward(request, response);

			return;
		}
		//approvedGood
		if (method.equals("approvedGood")) {
			String goodname = request.getParameter("goodname");
			String goodtypecode = request.getParameter("goodtypecode");
			String goodcode = request.getParameter("goodcode");

			Goods goods = goodsService.findGoodDetailBygoodcode(goodcode);
			
			boolean flaggood = goodsService.approvedGoodBygoodcode(goodcode,"yes");
			
			//System.out.println(goods + "==" + images);
			request.setAttribute("goodname", goodname);
			request.setAttribute("goodtypecode", goodtypecode);
			request.setAttribute("goodcode", goodcode);
			request.getRequestDispatcher("GoodsServlet?method=findAllGoodsByNameOrTypeExamine&goodname=" + goods.getGoodname()
			+ "&goodtypecode=" + goodtypecode + "&firstpage=0").forward(request, response);
			return;
		}
		//noapprovedGood
		if (method.equals("noapprovedGood")) {
			String goodname = request.getParameter("goodname");
			String goodtypecode = request.getParameter("goodtypecode");
			String goodcode = request.getParameter("goodcode");
			Goods goods = goodsService.findGoodDetailBygoodcode(goodcode);
			
			boolean flaggood = goodsService.approvedGoodBygoodcode(goodcode,"no");
			
			//System.out.println(goods + "==" + images);
			request.setAttribute("goodname", goodname);
			request.setAttribute("goodtypecode", goodtypecode);
			request.setAttribute("goodcode", goodcode);
			request.getRequestDispatcher("GoodsServlet?method=findAllGoodsByNameOrTypeExamine&goodname=" + goods.getGoodname()
			+ "&goodtypecode=" + goodtypecode + "&firstpage=0").forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
