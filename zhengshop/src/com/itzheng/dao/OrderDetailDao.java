package com.itzheng.dao;

import java.util.ArrayList;

import com.itzheng.entity.Orderdetail;

public interface OrderDetailDao {

	boolean addOrderDetail(Orderdetail orderdetail);

	ArrayList<Orderdetail> findOrderDetailListNyOrderCode(String ordercode);

	boolean updateOrderdetailByOrderCode(String ordercode, String state);
	
	
	

}
