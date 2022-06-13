package com.itzheng.service;

import java.util.ArrayList;

import com.itzheng.entity.GoodType;

public interface GoodTypeService {

	ArrayList<GoodType> getAllGoodType();

	int findCountGoodtypeByTypename(String typename);

	ArrayList<GoodType> findAllGoodtypeByTypename(String typename, int pagenumber, int i);

	boolean addGoodtype(GoodType goodType);

	GoodType findGoodTypeBygoodtypecode(String goodtypecode);

	boolean updateGoodtype(GoodType goodType);

	boolean deleteGoodtypeByTypecode(String goodtypecode);


	
}
