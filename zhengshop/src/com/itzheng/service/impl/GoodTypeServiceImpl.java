package com.itzheng.service.impl;

import java.util.ArrayList;

import com.itzheng.dao.GoodTypeDao;
import com.itzheng.dao.impl.GoodTypeDaoImpl;
import com.itzheng.entity.GoodType;
import com.itzheng.service.GoodTypeService;

public class GoodTypeServiceImpl implements GoodTypeService {
	
	
	GoodTypeDao goodTypeDao = new GoodTypeDaoImpl();

	@Override
	public ArrayList<GoodType> getAllGoodType() {
		// TODO Auto-generated method stub
		return goodTypeDao.getAllGoodType();
	}

	@Override
	public int findCountGoodtypeByTypename(String typename) {
		// TODO Auto-generated method stub
		return goodTypeDao.findCountGoodtypeByTypename(typename);
	}

	@Override
	public ArrayList<GoodType> findAllGoodtypeByTypename(String typename, int pagenumber, int page) {
		// TODO Auto-generated method stub
		return goodTypeDao.findAllGoodtypeByTypename(typename,pagenumber,page);
	}

	@Override
	public boolean addGoodtype(GoodType goodType) {
		// TODO Auto-generated method stub
		return goodTypeDao.addGoodtype(goodType);
	}

	@Override
	public GoodType findGoodTypeBygoodtypecode(String goodtypecode) {
		// TODO Auto-generated method stub
		return goodTypeDao.findGoodBygoodtypecode(goodtypecode);
	}

	@Override
	public boolean updateGoodtype(GoodType goodType) {
		// TODO Auto-generated method stub
		return goodTypeDao.updateGoodtype(goodType);
	}

	@Override
	public boolean deleteGoodtypeByTypecode(String goodtypecode) {
		// TODO Auto-generated method stub
		return goodTypeDao.deleteGoodtypeByTypecode(goodtypecode);
	}


}
