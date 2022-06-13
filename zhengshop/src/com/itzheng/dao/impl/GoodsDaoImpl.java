package com.itzheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itzheng.dao.GoodsDao;
import com.itzheng.entity.Goods;
import com.itzheng.entity.User;
import com.itzheng.utils.JDBCUtils;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public int findCountAllGoodsByNameOrType(String goodname, String goodtypecode) {

		String sql = "select count(*) from goods where  goodname like '%" + goodname + "%' and goodtypecode like '%"
				+ goodtypecode + "%'  ";
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
	public ArrayList<Goods> findAllGoodsByNameOrType(String goodname, String goodtypecode, int pagenumber, int page) {
		
		ArrayList<Goods> arrayList = new ArrayList<Goods>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from goods where goodname like '%" + goodname + "%' and goodtypecode like '%"
				+ goodtypecode + "%' limit " + pagenumber + "," + page;
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Goods goods = new Goods();

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
	public boolean addGood(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "insert into goods(goodcode,goodname,gooddetail,goodprice,gooddiscount,goodusercode,goodstate,goodimagecode,gooddate,goodtypecode) values(?,?,?,?,?,?,?,?,?,?) ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, goods.getGoodcode());
			ps.setString(2, goods.getGoodname());
			ps.setString(3, goods.getGooddetail());
			ps.setString(4, goods.getGoodprice());
			ps.setString(5, goods.getGooddiscount());
			ps.setString(6, goods.getGoodusercode());
			ps.setString(7, goods.getGoodstate());
			ps.setString(8, goods.getGoodimagecode());
			ps.setString(9, goods.getGooddate());
			ps.setString(10, goods.getGoodtypecode());

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
	public Goods findGoodBygoodcode(String goodcode) {

		String sql = "select * from goods where goodcode = ?";

		Connection conn = JDBCUtils.getConn();

		Goods goods2 = new Goods();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goodcode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				goods2.setId(rs.getInt(1));
				goods2.setGoodcode(rs.getString(2));
				goods2.setGoodname(rs.getString(3));
				goods2.setGooddetail(rs.getString(4));
				goods2.setGoodprice(rs.getString(5));
				goods2.setGooddiscount(rs.getString(6));
				goods2.setGoodusercode(rs.getString(7));
				goods2.setGoodstate(rs.getString(8));
				goods2.setGoodimagecode(rs.getString(9));
				goods2.setGooddate(rs.getString(10));
				goods2.setGoodtypecode(rs.getString(11));

				System.out.println(goods2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return goods2;
	}

	@Override
	public boolean updateGood(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "update goods set goodcode= ?,goodname= ?,gooddetail= ?,goodprice= ?,gooddiscount=?,goodusercode= ?,goodstate = ?,goodimagecode= ?,gooddate = ?,goodtypecode= ?  where id = ? ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, goods.getGoodcode());
			ps.setString(2, goods.getGoodname());
			ps.setString(3, goods.getGooddetail());
			ps.setString(4, goods.getGoodprice());
			ps.setString(5, goods.getGooddiscount());
			ps.setString(6, goods.getGoodusercode());
			ps.setString(7, goods.getGoodstate());
			ps.setString(8, goods.getGoodimagecode());
			ps.setString(9, goods.getGooddate());
			ps.setString(10, goods.getGoodtypecode());
			ps.setInt(11, goods.getId());

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
	public boolean deleteGoodBygoodcode(String goodcode) {
		// TODO Auto-generated method stub

		Connection conn = JDBCUtils.getConn();
		String sql = "delete from goods where goodcode = '" + goodcode + "'";
		// String sql = "delete from store where id = " + id;
		try {
			Statement st = conn.createStatement();

			int e = st.executeUpdate(sql);
			if (e > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);

		}
		return false;
	}

	@Override
	public boolean approvedGoodBygoodcode(String goodcode, String approved) {
		Connection conn = JDBCUtils.getConn();
		String goodstate = "";
		if (approved.equals("yes")) {
			goodstate = "1";
		}
		if (approved.equals("no")) {
			goodstate = "2";
		}

		String sql = "update goods set goodstate = '" + goodstate + "' where goodcode = '" + goodcode + "'";
		System.out.println(sql);
		// String sql = "delete from store where id = " + id;
		try {
			Statement st = conn.createStatement();

			int e = st.executeUpdate(sql);
			if (e > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);

		}
		return false;
	}

	@Override
	public int findCountAllGoodsByNameOrTypeUser1(String goodname, String goodtypecode, String usercode) {
		String sql = "select count(*) from goods where  goodname like '%" + goodname + "%' and goodtypecode like '%"
				+ goodtypecode + "%' and goodusercode =" + usercode;
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
	public int findCountAllGoodsByNameOrTypePut(String goodname, String goodtypecode) {
		String sql = "select count(*) from goods where  goodname like '%" + goodname + "%' and goodtypecode like '%"
				+ goodtypecode + "%' and goodstate = 1 ";
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
	public ArrayList<Goods> findAllGoodsByNameOrTypePut(String goodname, String goodtypecode, int pagenumber,
			int page) {
		ArrayList<Goods> arrayList = new ArrayList<Goods>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from goods where goodname like '%" + goodname + "%' and goodtypecode like '%"
				+ goodtypecode + "%'  and goodstate = 1  limit " + pagenumber + "," + page  +"";
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Goods goods = new Goods();

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
