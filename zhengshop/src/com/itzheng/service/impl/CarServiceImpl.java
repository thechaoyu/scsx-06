package com.itzheng.service.impl;

import java.util.ArrayList;

import com.itzheng.dao.CarDao;
import com.itzheng.dao.GoodsDao;
import com.itzheng.dao.ImagesDao;
import com.itzheng.dao.impl.CarDaoImpl;
import com.itzheng.dao.impl.GoodsDaoImpl;
import com.itzheng.dao.impl.ImagesDaoImpl;
import com.itzheng.entity.Car;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Images;
import com.itzheng.service.CarService;
import com.itzheng.utils.MyTime;
import com.itzheng.utils.UpdateFile;

public class CarServiceImpl implements CarService {
	
	CarDao cardao = new CarDaoImpl();
	
	GoodsDao goodsdao = new GoodsDaoImpl();
	
	ImagesDao imagesdao = new ImagesDaoImpl();

	@Override
	public boolean addCarByGoodcodeAndusercode(String goodcode, String usercode) {
		
		boolean flag = true;
		
		//先查询购物车当中有没有当前商品
		
		Car car = cardao.findCarByGoodcodeAndusercodeAndState(goodcode,usercode,"0");
		
		
		if(car != null && car.getCarcode().length() > 0) {
			
			//如果有商品则更新数量使其加1
			int num = Integer.parseInt(car.getGoodnumber());
			
			num = num + 1;
			car.setGoodnumber(num+"");
			
			flag &= cardao.updateCarGoodcodeAndusercode(car);
			
		}else {
			//如果没有则将商品加入到购物车当中
			Car car2 = new Car();
			UpdateFile file = new UpdateFile();
			car2.setCarcode(file.getCode());
			car2.setUsercode(usercode);
			car2.setGoodcode(goodcode);
			car2.setGoodnumber("1");
			car2.setState("0");
			car2.setDate(MyTime.getTime());
			
			flag &= cardao.addCarGoodcodeAndusercode(car2);
		}
		
		return flag;
	}

	@Override
	public ArrayList<Car> findCars(String usercode) {
		// TODO Auto-generated method stub
		
		ArrayList<Car> carlist = cardao.findCars(usercode);
		
		
		
		for (Car car : carlist) {
			
			Goods goods = goodsdao.findGoodBygoodcode(car.getGoodcode());
			
			Images image = imagesdao.findImageBuimagecode(goods.getGoodimagecode());

			goods.setGoodimagecode(image.getImage1());
			
			
			car.setGoods(goods);
		}
		
		return carlist;
	}

}
