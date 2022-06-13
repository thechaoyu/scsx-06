package com.itzheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itzheng.dao.CarDao;
import com.itzheng.entity.Car;
import com.itzheng.entity.Goods;
import com.itzheng.utils.JDBCUtils;

public class CarDaoImpl implements CarDao {

	@Override
	public Car findCarByGoodcodeAndusercode(String goodcode, String usercode) {

		String sql = "select * from car where goodcode = ? and usercode = ?";

		Connection conn = JDBCUtils.getConn();

		Car car2 = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, goodcode);
			ps.setString(2, usercode);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				car2 = new Car();
				car2.setId(rs.getInt(1));
				car2.setCarcode(rs.getString(2));
				car2.setUsercode(rs.getString(3));
				car2.setGoodcode(rs.getString(4));
				car2.setGoodnumber(rs.getString(5));
				car2.setState(rs.getString(6));
				car2.setDate(rs.getString(7));
				System.out.println(car2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return car2;
	}

	@Override
	public boolean updateCarGoodcodeAndusercode(Car car) {

		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "update car set carcode= ?,usercode= ?,goodcode= ?,goodnumber= ?,state=?,date= ?  where id = ? ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, car.getCarcode());
			ps.setString(2, car.getUsercode());
			ps.setString(3, car.getGoodcode());
			ps.setString(4, car.getGoodnumber());
			ps.setString(5, car.getState());
			ps.setString(6, car.getDate());
			ps.setInt(7, car.getId());

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
	public boolean addCarGoodcodeAndusercode(Car car) {

		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "insert into car(carcode,usercode,goodcode,goodnumber,state,date) values(?,?,?,?,?,?) ";
		System.out.println(sql);
		System.out.println(car);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, car.getCarcode());
			ps.setString(2, car.getUsercode());
			ps.setString(3, car.getGoodcode());
			ps.setString(4, car.getGoodnumber());
			ps.setString(5, car.getState());
			ps.setString(6, car.getDate());

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
	public ArrayList<Car> findCars(String usercode) {
		ArrayList<Car> arrayList = new ArrayList<Car>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from car where  usercode =  '"+usercode+"'  and state = '0'  ";
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Car car = new Car();

				car.setId(rs.getInt(1));
				car.setCarcode(rs.getString(2));
				car.setUsercode(rs.getString(3));
				car.setGoodcode(rs.getString(4));
				car.setGoodnumber(rs.getString(5));
				car.setState(rs.getString(6));
				car.setDate(rs.getString(7));
				arrayList.add(car);
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
	public Car findCarByGoodcodeAndusercodeAndState(String goodcode, String usercode, String state) {
		String sql = "select * from car where goodcode = ? and usercode = ? and state = ? ";

		Connection conn = JDBCUtils.getConn();

		Car car2 = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, goodcode);
			ps.setString(2, usercode);
			ps.setString(3, state);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				car2 = new Car();
				car2.setId(rs.getInt(1));
				car2.setCarcode(rs.getString(2));
				car2.setUsercode(rs.getString(3));
				car2.setGoodcode(rs.getString(4));
				car2.setGoodnumber(rs.getString(5));
				car2.setState(rs.getString(6));
				car2.setDate(rs.getString(7));
				System.out.println(car2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return car2;
	}

}
