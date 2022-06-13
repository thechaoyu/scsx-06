package com.itzheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itzheng.dao.OrderDetailDao;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Orderdetail;
import com.itzheng.utils.JDBCUtils;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public boolean addOrderDetail(Orderdetail orderdetail) {

		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "insert into orderdetail(orderdetailcode,usersellercode,userbuyercode,ordercode,goodcode,goodnumber,state,date,price,receiveraddress) values(?,?,?,?,?,?,?,?,?,?) ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, orderdetail.getOrdercode());
			ps.setString(2, orderdetail.getUsersellercode());
			ps.setString(3, orderdetail.getUserbuyercode());
			ps.setString(4, orderdetail.getOrdercode());
			ps.setString(5, orderdetail.getGoodcode());
			ps.setString(6, orderdetail.getGoodnumber());
			ps.setString(7, orderdetail.getState());
			ps.setString(8, orderdetail.getDate());
			ps.setString(9, orderdetail.getPrice());
			ps.setString(9, orderdetail.getReceiveraddress());

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
	public ArrayList<Orderdetail> findOrderDetailListNyOrderCode(String ordercode) {
		
		ArrayList<Orderdetail> arrayList = new ArrayList<Orderdetail>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from orderdetail where ordercode = '" +ordercode+ "'";
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Orderdetail orderdetail = new Orderdetail();

				orderdetail.setId(rs.getInt(1));
				orderdetail.setOrderdetailcode(rs.getString(2));
				orderdetail.setUsersellercode(rs.getString(3));
				orderdetail.setUserbuyercode(rs.getString(4));
				orderdetail.setOrdercode(rs.getString(5));
				orderdetail.setGoodcode(rs.getString(6));
				orderdetail.setGoodnumber(rs.getString(7));
				orderdetail.setState(rs.getString(8));
				orderdetail.setDate(rs.getString(9));
				orderdetail.setPrice(rs.getString(10));
				orderdetail.setPrice(rs.getString(64));

				arrayList.add(orderdetail);
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
	public boolean updateOrderdetailByOrderCode(String ordercode, String state) {
		
		Connection conn = JDBCUtils.getConn();
		String sql = "update orderdetail set state = ?  where ordercode = ? ";
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
}
