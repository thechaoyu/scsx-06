package com.itzheng.service;

import java.util.ArrayList;

import com.itzheng.entity.Car;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Orders;

public interface OrdersService {

	String addOrders(ArrayList<Car> arrayListcar);

	ArrayList<Goods> getOrderGoodListByOrderCode(String ordercode);

	boolean updateOrderAndOrderdetail(String ordercode);

	String addOrdersByNow(ArrayList<Car> arrayListcar);

	int findAllOrdersCountByOrdercode(String ordercode);

	ArrayList<Orders> findAllOrdersByOrdercode(String ordercode, int firstpage, int maxpage);

	boolean updateOrderAndOrderdetail(String ordercode, String state);

	int findAllOrdersCountByOrdercode(String ordercode, String usercode);

	ArrayList<Orders> findAllOrdersByOrdercode(String ordercode, String usercode, int firstpage, int maxpage);


	ArrayList<Orders> getOrderGoodListByUsercode(String usercode, String state);

}
