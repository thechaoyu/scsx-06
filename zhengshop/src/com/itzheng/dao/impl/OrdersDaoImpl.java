package com.itzheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itzheng.dao.OrdersDao;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Orders;
import com.itzheng.utils.JDBCUtils;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public boolean addOrders(Orders orders) {

		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "insert into orders(ordercode,usercode,state,date,price,receiveraddress) values(?,?,?,?,?,?) ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, orders.getOrdercode());
			ps.setString(2, orders.getUsercode());
			ps.setString(3, orders.getState());
			ps.setString(4, orders.getDate());
			ps.setString(5, orders.getPrice());
			ps.setString(5, orders.getReceiveraddress());

			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return false;
	}

	@Override
	public boolean updateOrderByOrderCode(String ordercode, String state) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "update orders set state = ?  where ordercode = ? ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, state);
			ps.setString(2, ordercode);

			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return false;
	}

	@Override
	public int findAllOrdersCountByOrdercode(String ordercode) {
		String sql = "select count(*) from orders where  ordercode like '%" + ordercode + "%' ";
		Connection con = JDBCUtils.getConn();
		int count = 0;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(con);
		}

		return count;
	}

	@Override
	public ArrayList<Orders> findAllOrdersByOrdercode(String ordercode, int firstpage, int maxpage) {
		ArrayList<Orders> arrayList = new ArrayList<Orders>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from orders where ordercode like '%" + ordercode + "%'  limit " + firstpage + "," + maxpage;
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Orders orders = new Orders();

				orders.setId(rs.getInt(1));
				orders.setOrdercode(rs.getString(2));
				orders.setUsercode(rs.getString(3));
				orders.setState(rs.getString(4));
				orders.setDate(rs.getString(5));
				orders.setPrice(rs.getString(6));
				orders.setReceiveraddress(rs.getString(7));

				arrayList.add(orders);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);

		}
		if (arrayList.size() == 0) {
			return null;
		}
		return arrayList;
	}

	@Override
	public int findAllOrdersCountByOrdercode(String ordercode, String usercode) {
		String sql = "select count(*) from orders where  ordercode like '%" + ordercode + "%' and  usercode like '%" + usercode + "%'";
		Connection con = JDBCUtils.getConn();
		int count = 0;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(con);
		}

		return count;
	}

	@Override
	public ArrayList<Orders> findAllOrdersByOrdercode(String ordercode, String usercode, int firstpage, int maxpage) {
		ArrayList<Orders> arrayList = new ArrayList<Orders>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from orders where ordercode like '%" + ordercode + "%' and usercode like '%" + usercode + "%'  limit " + firstpage + "," + maxpage;
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Orders orders = new Orders();

				orders.setId(rs.getInt(1));
				orders.setOrdercode(rs.getString(2));
				orders.setUsercode(rs.getString(3));
				orders.setState(rs.getString(4));
				orders.setDate(rs.getString(5));
				orders.setPrice(rs.getString(6));
				orders.setReceiveraddress(rs.getString(7));

				arrayList.add(orders);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);

		}
		if (arrayList.size() == 0) {
			return null;
		}
		return arrayList;
	}

	@Override
	public ArrayList<Orders> getOrderGoodListByUsercode(String usercode,String state) {
		ArrayList<Orders> arrayList = new ArrayList<Orders>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from orders where usercode = '" + usercode + " '  and state =  '"+state+"'";
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Orders orders = new Orders();

				orders.setId(rs.getInt(1));
				orders.setOrdercode(rs.getString(2));
				orders.setUsercode(rs.getString(3));
				orders.setState(rs.getString(4));
				orders.setDate(rs.getString(5));
				orders.setPrice(rs.getString(6));
				orders.setReceiveraddress(rs.getString(7));

				arrayList.add(orders);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);

		}
		if (arrayList.size() == 0) {
			return null;
		}
		return arrayList;
	}

}
