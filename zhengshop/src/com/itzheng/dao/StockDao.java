package com.itzheng.dao;

import java.util.ArrayList;

import com.itzheng.entity.Stock;
import com.itzheng.entity.list.GoodsL;

public interface StockDao {

	boolean addStock(Stock stock);

	ArrayList<GoodsL> findAllGoodsLByNameOrType(String goodname, String goodtypecode, int firstpage, int page);

	Stock findstockBygoodCode(String goodcode);

	Stock findStockBystockcode(String stockcode);

	boolean updateStock(Stock stock);

	ArrayList<GoodsL> findAllGoodsLByNameOrTypeUser1(String goodname, String goodtypecode, int firstpage, int page,
			String usercodeup);

}
