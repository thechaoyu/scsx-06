package com.itzheng.service;

import java.util.ArrayList;

import com.itzheng.entity.Goods;
import com.itzheng.entity.list.GoodsL;

public interface GoodsService {

	ArrayList<Goods> findAllGoodsByNameOrType(String goodname, String goodtypecode, int pagenumber, int page);

	int findCountAllGoodsByNameOrType(String goodname, String goodtypecode);

	boolean addGood(Goods goods);

	Goods findGoodDetailBygoodcode(String goodcode);

	Goods findGoodDetailBygoodcodegoodtypecode(String goodcode);

	boolean updateGood(Goods goods);

	boolean deleteGoodBygoodcode(String goodcode);

	boolean approvedGoodBygoodcode(String goodcode, String approved);

	int findCountAllGoodsByNameOrTypeUser1(String goodname, String goodtypecode, String usercode);

	ArrayList<Goods> findAllGoodsByNameOrTypePut(String string, String string2, int pagenumber, int page);

	int findCountAllGoodsByNameOrTypePut(String goodname, String goodtypecode);




}
