package com.itzheng.dao;

import java.util.ArrayList;

import com.itzheng.entity.Orders;

public interface OrdersDao {

	boolean addOrders(Orders orders);

	boolean updateOrderByOrderCode(String ordercode, String state);

	int findAllOrdersCountByOrdercode(String ordercode);

	ArrayList<Orders> findAllOrdersByOrdercode(String ordercode, int firstpage, int maxpage);

	int findAllOrdersCountByOrdercode(String ordercode, String usercode);

	ArrayList<Orders> findAllOrdersByOrdercode(String ordercode, String usercode, int firstpage, int maxpage);


	ArrayList<Orders> getOrderGoodListByUsercode(String usercode, String state);

}
