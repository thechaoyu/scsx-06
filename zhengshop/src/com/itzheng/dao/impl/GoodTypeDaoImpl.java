package com.itzheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itzheng.dao.GoodTypeDao;
import com.itzheng.entity.GoodType;
import com.itzheng.entity.Goods;
import com.itzheng.entity.User;
import com.itzheng.utils.JDBCUtils;

public class GoodTypeDaoImpl implements GoodTypeDao {

	@Override
	public GoodType findGoodBygoodtypecode(String goodtycode) {

		String sql = "select * from goodtype where goodtypecode = ?";

		Connection conn = JDBCUtils.getConn();

		GoodType goodtype2 = new GoodType();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goodtycode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				goodtype2.setId(rs.getInt(1));
				goodtype2.setGoodtypecode(rs.getString(2));
				goodtype2.setTypename(rs.getString(3));

				System.out.println(goodtype2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return goodtype2;
	}

	@Override
	public ArrayList<GoodType> getAllGoodType() {
		ArrayList<GoodType> arrayList = new ArrayList<GoodType>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from goodtype";
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				GoodType goodtype = new GoodType();

				goodtype.setId(rs.getInt(1));
				goodtype.setGoodtypecode(rs.getString(2));
				goodtype.setTypename(rs.getString(3));

				arrayList.add(goodtype);
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
	public int findCountGoodtypeByTypename(String typename) {

		String sql = "select count(*) from goodtype where  typename like '%" + typename + "%'";
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
	public ArrayList<GoodType> findAllGoodtypeByTypename(String typename, int firstpage, int page) {

		// TODO Auto-generated method stub
		ArrayList<GoodType> arrayList = new ArrayList<GoodType>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from goodtype where typename like '%" + typename + "%'  limit " + firstpage + "," + page;
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				GoodType goodtype = new GoodType();

				goodtype.setId(rs.getInt(1));
				goodtype.setGoodtypecode(rs.getString(2));
				goodtype.setTypename(rs.getString(3));

				arrayList.add(goodtype);
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
	public boolean addGoodtype(GoodType goodType) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "insert into goodtype(goodtypecode,typename) values(?,?) ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, goodType.getGoodtypecode());
			ps.setString(2, goodType.getTypename());

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
	public boolean updateGoodtype(GoodType goodType) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "update goodtype set typename = ? where goodtypecode = ?";

		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, goodType.getTypename());
			ps.setString(2, goodType.getGoodtypecode());

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
	public boolean deleteGoodtypeByTypecode(String goodtypecode) {
		Connection conn = JDBCUtils.getConn();
		String sql = "delete from goodtype where goodtypecode = '" + goodtypecode + "'";
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

}
