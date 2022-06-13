package com.itzheng.service.impl;

import java.util.ArrayList;

import com.itzheng.dao.CarDao;
import com.itzheng.dao.GoodsDao;
import com.itzheng.dao.ImagesDao;
import com.itzheng.dao.OrderDetailDao;
import com.itzheng.dao.OrdersDao;
import com.itzheng.dao.UserDao;
import com.itzheng.dao.impl.CarDaoImpl;
import com.itzheng.dao.impl.GoodsDaoImpl;
import com.itzheng.dao.impl.ImagesDaoImpl;
import com.itzheng.dao.impl.OrderDetailDaoImpl;
import com.itzheng.dao.impl.OrdersDaoImpl;
import com.itzheng.dao.impl.UserDaoImpl;
import com.itzheng.entity.Car;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Images;
import com.itzheng.entity.Orderdetail;
import com.itzheng.entity.Orders;
import com.itzheng.entity.User;
import com.itzheng.service.OrdersService;
import com.itzheng.utils.MyTime;
import com.itzheng.utils.UpdateFile;

public class OrdersServiceImpl implements OrdersService {

	OrdersDao orderdao = new OrdersDaoImpl();

	GoodsDao gooddao = new GoodsDaoImpl();

	OrderDetailDao Orderdetaildao = new OrderDetailDaoImpl();

	CarDao cardao = new CarDaoImpl();

	ImagesDao imagesdao = new ImagesDaoImpl();

	UserDao userdao = new UserDaoImpl();

	@Override
	public int findAllOrdersCountByOrdercode(String ordercode, String usercode) {
		// TODO Auto-generated method stub
		return orderdao.findAllOrdersCountByOrdercode(ordercode, usercode);
	}

	@Override
	public ArrayList<Orders> findAllOrdersByOrdercode(String ordercode, String usercode, int firstpage, int maxpage) {
		ArrayList<Orders> orderlist = orderdao.findAllOrdersByOrdercode(ordercode, usercode, firstpage, maxpage);

		try {
			for (Orders orders : orderlist) {

				String usercode11 = orders.getUsercode();

				User user = userdao.findUserByusercode(usercode11);

				orders.setUsercode(user.getName());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return orderlist;
	}

	@Override
	public int findAllOrdersCountByOrdercode(String ordercode) {
		// TODO Auto-generated method stub
		return orderdao.findAllOrdersCountByOrdercode(ordercode);
	}

	@Override
	public ArrayList<Orders> findAllOrdersByOrdercode(String ordercode, int firstpage, int maxpage) {

		ArrayList<Orders> orderlist = orderdao.findAllOrdersByOrdercode(ordercode, firstpage, maxpage);

		for (Orders orders : orderlist) {

			String usercode = orders.getUsercode();

			User user = userdao.findUserByusercode(usercode);

			orders.setUsercode(user.getName());
		}

		return orderlist;
	}

	@Override
	public String addOrdersByNow(ArrayList<Car> arrayListcar) {

		// 鍚戝姞鍏ュ埌璁㈠崟褰撲腑

		// 鍒涘缓璁㈠崟
		Orders orders = new Orders();

		String ordercode = UpdateFile.getCodeUtils();
		orders.setOrdercode(ordercode);
		orders.setUsercode(arrayListcar.get(0).getUsercode());
		orders.setState("0");

		double total = 0;
		for (Car car : arrayListcar) {

			String goodcode = car.getGoodcode();
			System.out.println(goodcode);
			Goods goods = gooddao.findGoodBygoodcode(goodcode);

			System.out.println(goods);

			double price = Double.parseDouble(goods.getGoodprice());
			double number = Double.parseDouble(car.getGoodnumber());
			System.out.println(number);
			total += price * number;
		}
		orders.setDate(MyTime.getTime());
		orders.setPrice(total + "");
		orders.setReceiveraddress("郑州大学");

		System.out.println(orders);

		// 娣诲姞鍒拌鍗曡鎯呭綋涓�

		ArrayList<Orderdetail> arrayListdeDetails = new ArrayList<Orderdetail>();

		for (Car car : arrayListcar) {
			String goodcode = car.getGoodcode();
			System.out.println(goodcode);
			Goods goods = gooddao.findGoodBygoodcode(goodcode);

			Orderdetail orderdetail = new Orderdetail();
			orderdetail.setOrderdetailcode(UpdateFile.getCodeUtils());
			orderdetail.setUsersellercode(goods.getGoodusercode());
			orderdetail.setUserbuyercode(arrayListcar.get(0).getUsercode());// sellercode(arrayListcar.get(0).getUsercode());
			orderdetail.setOrdercode(ordercode);
			orderdetail.setGoodcode(goods.getGoodcode());
			orderdetail.setGoodnumber(car.getGoodnumber());
			orderdetail.setState("0");
			orderdetail.setDate(MyTime.getTime());
			double price = Double.parseDouble(goods.getGoodprice());
			double number = Double.parseDouble(car.getGoodnumber());
			orderdetail.setPrice(price * number + "");

			orderdetail.setReceiveraddress("郑州大学");
			arrayListdeDetails.add(orderdetail);


		}
		System.out.println("===============================");
		boolean flag = orderdao.addOrders(orders);
		for (Orderdetail orderdetail : arrayListdeDetails) {
			flag &= Orderdetaildao.addOrderDetail(orderdetail);
		}

		if (flag) {

			return ordercode;
		}

		return "";
	}

	@Override
	public String addOrders(ArrayList<Car> arrayListcar) {
		boolean flag2 = true;
		// 鍒犻櫎璐墿杞﹀綋涓搴旂殑鍟嗗搧
		for (Car car : arrayListcar) {

			Car car2 = cardao.findCarByGoodcodeAndusercodeAndState(car.getGoodcode(), car.getUsercode(), "0");

			car2.setState("1");

			flag2 &= cardao.updateCarGoodcodeAndusercode(car2);

		}

		// 鍚戝姞鍏ュ埌璁㈠崟褰撲腑

		// 鍒涘缓璁㈠崟
		Orders orders = new Orders();

		String ordercode = UpdateFile.getCodeUtils();
		orders.setOrdercode(ordercode);
		orders.setUsercode(arrayListcar.get(0).getUsercode());
		orders.setState("0");

		double total = 0;
		for (Car car : arrayListcar) {

			String goodcode = car.getGoodcode();
			System.out.println(goodcode);
			Goods goods = gooddao.findGoodBygoodcode(goodcode);

			System.out.println(goods);

			double price = Double.parseDouble(goods.getGoodprice());
			double number = Double.parseDouble(car.getGoodnumber());
			System.out.println(number);
			total += price * number;
		}
		orders.setDate(MyTime.getTime());
		orders.setPrice(total + "");
		orders.setReceiveraddress("郑州大学");


		System.out.println(orders);

		// 娣诲姞鍒拌鍗曡鎯呭綋涓�

		ArrayList<Orderdetail> arrayListdeDetails = new ArrayList<Orderdetail>();

		for (Car car : arrayListcar) {
			String goodcode = car.getGoodcode();
			System.out.println(goodcode);
			Goods goods = gooddao.findGoodBygoodcode(goodcode);

			Orderdetail orderdetail = new Orderdetail();
			orderdetail.setOrderdetailcode(UpdateFile.getCodeUtils());
			orderdetail.setUsersellercode(goods.getGoodusercode());
			orderdetail.setUserbuyercode(arrayListcar.get(0).getUsercode());// sellercode(arrayListcar.get(0).getUsercode());
			orderdetail.setOrdercode(ordercode);
			orderdetail.setGoodcode(goods.getGoodcode());
			orderdetail.setGoodnumber(car.getGoodnumber());
			orderdetail.setState("0");
			orderdetail.setDate(MyTime.getTime());
			double price = Double.parseDouble(goods.getGoodprice());
			double number = Double.parseDouble(car.getGoodnumber());
			orderdetail.setPrice(price * number + "");
			
			orderdetail.setReceiveraddress("郑州大学");
			arrayListdeDetails.add(orderdetail);

		}
		System.out.println("===============================");
		boolean flag = orderdao.addOrders(orders);
		for (Orderdetail orderdetail : arrayListdeDetails) {
			flag &= Orderdetaildao.addOrderDetail(orderdetail);
		}

		if (flag && flag2) {

			return ordercode;
		}

		return "";
	}

	@Override
	public ArrayList<Goods> getOrderGoodListByOrderCode(String ordercode) {

		// 鍏堜粠璁㈠崟璇︽儏褰撲腑鏌ヨ鍑哄搴旀墍鏈夌殑鍟嗗搧缂栧彿

		ArrayList<Orderdetail> arrayListOrderdetail = Orderdetaildao.findOrderDetailListNyOrderCode(ordercode);

		ArrayList<Goods> arrayListGoods = new ArrayList<Goods>();

		for (Orderdetail orderdetail : arrayListOrderdetail) {

			String goodcode = orderdetail.getGoodcode();

			Goods goods = gooddao.findGoodBygoodcode(goodcode);

			goods.setGoodstate(orderdetail.getGoodnumber());

			String imagecode = goods.getGoodimagecode();

			Images image = imagesdao.findImageBuimagecode(imagecode);

			goods.setGoodimagecode(image.getImage1());

			arrayListGoods.add(goods);
		}

		return arrayListGoods;
	}

	@Override
	public boolean updateOrderAndOrderdetail(String ordercode) {

		boolean flag2 = orderdao.updateOrderByOrderCode(ordercode, "1");

		boolean flag1 = Orderdetaildao.updateOrderdetailByOrderCode(ordercode, "1");

		return flag1 && flag2;
	}

	@Override
	public boolean updateOrderAndOrderdetail(String ordercode, String state) {
		// TODO Auto-generated method stub

		boolean flag2 = orderdao.updateOrderByOrderCode(ordercode, state);

		boolean flag1 = Orderdetaildao.updateOrderdetailByOrderCode(ordercode, state);

		return flag1 && flag2;

	}

	@Override
	public ArrayList<Orders> getOrderGoodListByUsercode(String usercode,String state1) {
		
		
		ArrayList<Orders> arrayListOrders = orderdao.getOrderGoodListByUsercode(usercode,state1);
		if(arrayListOrders.size() ==0) {
			return null;
		}
		
		for (Orders orders : arrayListOrders) {
			
			User user = userdao.findUserByusercode(orders.getUsercode());
			
			orders.setUsercode(user.getUsername());
			
			String state =  orders.getState();
			
			if(state.equals("0")) {
				orders.setState("鏈敮浠�");
			}
			if(state.equals("1")) {
				orders.setState("宸叉敮浠�");
			}
			if(state.equals("2")) {
				orders.setState("宸插彇娑�");
			}
			if(state.equals("3")) {
				orders.setState("鏈彂璐�");
			}
			if(state.equals("4")) {
				orders.setState("宸插彂璐�");
			}
			if(state.equals("5")) {
				orders.setState("宸茬鏀�");
			}
			
			
		}
		
		return arrayListOrders;
	}

}
