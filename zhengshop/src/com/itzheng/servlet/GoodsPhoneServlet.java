package com.itzheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzheng.entity.Goods;
import com.itzheng.entity.Images;
import com.itzheng.service.GoodTypeService;
import com.itzheng.service.GoodsService;
import com.itzheng.service.ImagesService;
import com.itzheng.service.UserService;
import com.itzheng.service.impl.GoodTypeServiceImpl;
import com.itzheng.service.impl.GoodsServiceImpl;
import com.itzheng.service.impl.ImagesServiceImpl;
import com.itzheng.service.impl.UserServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GoodsPhoneServlet
 */
public class GoodsPhoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("==============");

		String method = request.getParameter("method");

		System.out.println(method);

		GoodsService goodService = new GoodsServiceImpl();
		

		ImagesService imagesService = new ImagesServiceImpl();


		if (method.equals("findGoods")) {

			int count = goodService.findCountAllGoodsByNameOrType("", "");

			Random random = new Random();
			int a = 0;
			try {
				 a = random.nextInt(count/10);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			ArrayList<Goods> goodlist = goodService.findAllGoodsByNameOrTypePut("", "", a, 10);
			
			response.setContentType("application/x-json");
			
			response.setCharacterEncoding("utf-8");
			
			PrintWriter out = response.getWriter();
			
			JSONArray jsonArray = JSONArray.fromObject(goodlist);
			
			out.print(jsonArray);

			out.flush();
			
			out.close();
			
			return;
		}
		//findGoodsByGoodNameOrTypeId
		if (method.equals("findGoodsByGoodNameOrTypeId")) {
			
			
			String goodtypecode = request.getParameter("goodtypecode");
			String goodname = request.getParameter("goodname");
			

			int count = goodService.findCountAllGoodsByNameOrTypePut(goodname, goodtypecode);

			Random random = new Random();
			int a = 0;
			try {
				 a = random.nextInt(count/20);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			ArrayList<Goods> goodlist = goodService.findAllGoodsByNameOrType(goodname, goodtypecode, a, 20);
			
			response.setContentType("application/x-json");
			
			response.setCharacterEncoding("utf-8");
			
			PrintWriter out = response.getWriter();
			
			JSONArray jsonArray = JSONArray.fromObject(goodlist);
			
			out.print(jsonArray);

			out.flush();
			
			out.close();
			
			return;
		}
		if (method.equals("findGoodDetailBygoodcode")) {
			String goodcode = request.getParameter("goodcode");

			Goods goods = goodService.findGoodDetailBygoodcode(goodcode);

			Images images = imagesService.getImageByImageCode(goods.getGoodimagecode());
			
			String[] goodiamgecodearray = new String[5];
			
			goodiamgecodearray[0] = images.getImage1();
			goodiamgecodearray[1] = images.getImage2();
			goodiamgecodearray[2] = images.getImage3();
			goodiamgecodearray[3] = images.getImage4();
			goodiamgecodearray[4] = images.getImage5();
			
			goods.setGoodiamgecodearray(goodiamgecodearray);

			response.setContentType("application/x-json");
			
			response.setCharacterEncoding("utf-8");
			
			PrintWriter out = response.getWriter();
			
			JSONArray jsonArray = JSONArray.fromObject(goods);
			
			out.print(jsonArray);

			out.flush();
			
			out.close();
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
