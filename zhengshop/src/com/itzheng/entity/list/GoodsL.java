package com.itzheng.entity.list;

import java.util.Arrays;
import java.util.List;

import com.itzheng.entity.GoodType;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Images;
import com.itzheng.entity.Stock;
import com.itzheng.entity.User;

public class GoodsL extends Goods {

	private Stock stock;

	public GoodsL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsL(int id, String goodcode, String goodname, String gooddetail, String goodprice, String gooddiscount,
			String goodusercode, User user, String goodstate, String goodimagecode, String gooddate,
			String goodtypecode, GoodType goodType, Stock stock) {
		super(id, goodcode, goodname, gooddetail, goodprice, gooddiscount, goodusercode, user, goodstate, goodimagecode,
				gooddate, goodtypecode, goodType);

		this.stock = stock;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "GoodsL [stock=" + stock + "]";
	}

}
