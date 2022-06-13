package com.itzheng.dao;

import java.util.ArrayList;

import com.itzheng.entity.Car;

public interface CarDao {

	Car findCarByGoodcodeAndusercode(String goodcode, String usercode);

	boolean updateCarGoodcodeAndusercode(Car car);

	boolean addCarGoodcodeAndusercode(Car car);

	ArrayList<Car> findCars(String usercode);

	Car findCarByGoodcodeAndusercodeAndState(String goodcode, String usercode, String state);

	

}
