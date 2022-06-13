package com.itzheng.dao;

import java.util.ArrayList;

import com.itzheng.entity.Goods;

public interface GoodsDao {

	int findCountAllGoodsByNameOrType(String goodname, String goodtypecode);

	ArrayList<Goods> findAllGoodsByNameOrType(String goodname, String goodtypecode, int pagenumber, int page);

	boolean addGood(Goods goods);

	Goods findGoodBygoodcode(String goodcode);

	boolean updateGood(Goods goods);

	boolean deleteGoodBygoodcode(String goodcode);

	boolean approvedGoodBygoodcode(String goodcode, String approved);


	int findCountAllGoodsByNameOrTypeUser1(String goodname, String goodtypecode, String usercode);

	int findCountAllGoodsByNameOrTypePut(String goodname, String goodtypecode);

	ArrayList<Goods> findAllGoodsByNameOrTypePut(String goodname, String goodtypecode, int pagenumber, int page);


}
