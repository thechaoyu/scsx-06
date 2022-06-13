package com.itzheng.dao;

import java.util.ArrayList;

import com.itzheng.entity.GoodType;

public interface GoodTypeDao {

	GoodType findGoodBygoodtypecode(String goodtycode);

	ArrayList<GoodType> getAllGoodType();


	ArrayList<GoodType> findAllGoodtypeByTypename(String typename, int pagenumber, int page);

	int findCountGoodtypeByTypename(String typename);

	boolean addGoodtype(GoodType goodType);

	boolean updateGoodtype(GoodType goodType);

	boolean deleteGoodtypeByTypecode(String goodtypecode);



}
