package com.itzheng.service.impl;

import java.util.ArrayList;

import com.itzheng.dao.GoodTypeDao;
import com.itzheng.dao.GoodsDao;
import com.itzheng.dao.ImagesDao;
import com.itzheng.dao.StockDao;
import com.itzheng.dao.UserDao;
import com.itzheng.dao.impl.GoodTypeDaoImpl;
import com.itzheng.dao.impl.GoodsDaoImpl;
import com.itzheng.dao.impl.ImagesDaoImpl;
import com.itzheng.dao.impl.StockDaoImpl;
import com.itzheng.dao.impl.UserDaoImpl;
import com.itzheng.entity.GoodType;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Images;
import com.itzheng.entity.Stock;
import com.itzheng.entity.User;
import com.itzheng.entity.list.GoodsL;
import com.itzheng.service.StockService;

public class StockServiceImpl implements StockService {

	GoodsDao gooddao = new GoodsDaoImpl();

	UserDao userdao = new UserDaoImpl();

	GoodTypeDao goodtypedao = new GoodTypeDaoImpl();

	ImagesDao imagesdao = new ImagesDaoImpl();

	StockDao stockDao = new StockDaoImpl();

	@Override
	public boolean addStock(Stock stock) {
		// TODO Auto-generated method stub
		return stockDao.addStock(stock);
	}

	@Override
	public ArrayList<GoodsL> findAllGoodsLByNameOrType(String goodname, String goodtypecode, int firstpage, int page) {

		ArrayList<GoodsL> goodlist = stockDao.findAllGoodsLByNameOrType(goodname, goodtypecode, firstpage, page);

		if (goodlist == null) {
			return null;
		}

		for (GoodsL goodls : goodlist) {
			// 通过用户code查询用户
			String usercode = goodls.getGoodusercode();

			User user1 = userdao.findUserByusercode(usercode);

			// 设置

			String goodtycode1 = goodls.getGoodtypecode();

			GoodType goodtype = goodtypedao.findGoodBygoodtypecode(goodtycode1);

			String imagecode = goodls.getGoodimagecode();

			Images image = imagesdao.findImageBuimagecode(imagecode);

			goodls.setGoodimagecode(image.getImage1());

			goodls.setGoodType(goodtype);

			goodls.setGoodusercode(user1.getName());

			Stock stock1 = stockDao.findstockBygoodCode(goodls.getGoodcode());

			goodls.setStock(stock1);

		}
		return goodlist;
	}

	@Override
	public Stock findStockBystockcode(String stockcode) {
		// TODO Auto-generated method stub
		return stockDao.findStockBystockcode(stockcode);
	}

	@Override
	public boolean updateStock(Stock stock) {
		// TODO Auto-generated method stub
		return stockDao.updateStock(stock);
	}

	@Override
	public ArrayList<GoodsL> findAllGoodsLByNameOrTypeUser1(String goodname, String goodtypecode, int firstpage,
			int page, String usercodeup) {
		// TODO Auto-generated method stub
		
		ArrayList<GoodsL> goodlist = stockDao.findAllGoodsLByNameOrTypeUser1(goodname, goodtypecode, firstpage, page,usercodeup);

		if (goodlist == null) {
			return null;
		}

		for (GoodsL goodls : goodlist) {
			// 通过用户code查询用户
			String usercode = goodls.getGoodusercode();

			User user1 = userdao.findUserByusercode(usercode);

			// 设置

			String goodtycode1 = goodls.getGoodtypecode();

			GoodType goodtype = goodtypedao.findGoodBygoodtypecode(goodtycode1);

			String imagecode = goodls.getGoodimagecode();

			Images image = imagesdao.findImageBuimagecode(imagecode);

			goodls.setGoodimagecode(image.getImage1());

			goodls.setGoodType(goodtype);

			goodls.setGoodusercode(user1.getName());

			Stock stock1 = stockDao.findstockBygoodCode(goodls.getGoodcode());

			goodls.setStock(stock1);

		}
		return goodlist;
	}

	

}
