package com.itzheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itzheng.dao.StockDao;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Stock;
import com.itzheng.entity.list.GoodsL;
import com.itzheng.utils.JDBCUtils;

public class StockDaoImpl implements StockDao {

	@Override
	public boolean addStock(Stock stock) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "insert into stock(stockcode,goodcode,goodnumber,usercode) values(?,?,?,?) ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, stock.getStockcode());
			ps.setString(2, stock.getGoodcode());
			ps.setString(3, stock.getGoodnumber());
			ps.setString(4, stock.getUsercode());

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
	public ArrayList<GoodsL> findAllGoodsLByNameOrType(String goodname, String goodtypecode, int firstpage, int page) {
		ArrayList<GoodsL> arrayList = new ArrayList<GoodsL>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from goods where goodname like '%" + goodname + "%' and goodtypecode like '%"
				+ goodtypecode + "%' limit " + firstpage + "," + page;
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				GoodsL goods = new GoodsL();

				goods.setId(rs.getInt(1));
				goods.setGoodcode(rs.getString(2));
				goods.setGoodname(rs.getString(3));
				goods.setGooddetail(rs.getString(4));
				goods.setGoodprice(rs.getString(5));
				goods.setGooddiscount(rs.getString(6));
				goods.setGoodusercode(rs.getString(7));
				goods.setGoodstate(rs.getString(8));
				goods.setGoodimagecode(rs.getString(9));
				goods.setGooddate(rs.getString(10));
				goods.setGoodtypecode(rs.getString(11));

				arrayList.add(goods);
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
	public Stock findstockBygoodCode(String goodcode) {

		String sql = "select * from stock where goodcode = ?";

		Connection conn = JDBCUtils.getConn();

		Stock stock2 = new Stock();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goodcode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				stock2.setId(rs.getInt(1));
				stock2.setStockcode(rs.getString(2));
				stock2.setGoodcode(rs.getString(3));
				stock2.setGoodnumber(rs.getString(4));
				stock2.setUsercode(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return stock2;
	}

	@Override
	public Stock findStockBystockcode(String stockcode) {

		String sql = "select * from stock where stockcode = ?";

		Connection conn = JDBCUtils.getConn();

		Stock stock2 = new Stock();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stockcode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				stock2.setId(rs.getInt(1));
				stock2.setStockcode(rs.getString(2));
				stock2.setGoodcode(rs.getString(3));
				stock2.setGoodnumber(rs.getString(4));
				stock2.setUsercode(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return stock2;
	}

	@Override
	public boolean updateStock(Stock stock) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();

		String sql = "update stock set goodcode = ?,goodnumber= ?,usercode= ?  where stockcode = ? ";

		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, stock.getGoodcode());
			ps.setString(2, stock.getGoodnumber());
			ps.setString(3, stock.getUsercode());
			ps.setString(4, stock.getStockcode());

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
	public ArrayList<GoodsL> findAllGoodsLByNameOrTypeUser1(String goodname, String goodtypecode, int firstpage,
			int page, String usercode) {
		ArrayList<GoodsL> arrayList = new ArrayList<GoodsL>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from goods where goodname like '%" + goodname + "%' and goodtypecode like '%"
				+ goodtypecode + "%' and goodusercode = '"+ usercode +"' limit " + firstpage + "," + page + "" ;
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				GoodsL goods = new GoodsL();
				goods.setId(rs.getInt(1));
				goods.setGoodcode(rs.getString(2));
				goods.setGoodname(rs.getString(3));
				goods.setGooddetail(rs.getString(4));
				goods.setGoodprice(rs.getString(5));
				goods.setGooddiscount(rs.getString(6));
				goods.setGoodusercode(rs.getString(7));
				goods.setGoodstate(rs.getString(8));
				goods.setGoodimagecode(rs.getString(9));
				goods.setGooddate(rs.getString(10));
				goods.setGoodtypecode(rs.getString(11));

				arrayList.add(goods);
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
