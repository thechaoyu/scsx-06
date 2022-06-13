package com.itzheng.service;

import java.util.ArrayList;

import com.itzheng.entity.Car;

public interface CarService {

	boolean addCarByGoodcodeAndusercode(String goodcode, String usercode);

	ArrayList<Car> findCars(String usercode);

}
