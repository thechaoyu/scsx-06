package com.itzheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itzheng.dao.ImagesDao;
import com.itzheng.entity.Images;
import com.itzheng.entity.User;
import com.itzheng.utils.JDBCUtils;

public class ImagesDaoImpl implements ImagesDao {

	@Override
	public Images findImageBuimagecode(String imagecode) {
		// TODO Auto-generated method stub

		String sql = "select * from images where imagecode = ?";

		Connection conn = JDBCUtils.getConn();

		Images Images2 = new Images();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, imagecode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Images2.setId(rs.getInt(1));
				Images2.setImagecode(rs.getString(2));
				Images2.setUsercodecode(rs.getString(3));
				Images2.setImage1(rs.getString(4));
				Images2.setImage2(rs.getString(5));
				Images2.setImage3(rs.getString(6));
				Images2.setImage4(rs.getString(7));
				Images2.setImage5(rs.getString(8));

				System.out.println(Images2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return Images2;

	}

	@Override
	public boolean addImages(Images images) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "insert into images(imagecode,imageusercode,image1,image2,image3,image4,image5) values(?,?,?,?,?,?,?) ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, images.getImagecode());
			ps.setString(2, images.getUsercodecode());
			ps.setString(3, images.getImage1());
			ps.setString(4, images.getImage2());
			ps.setString(5, images.getImage3());
			ps.setString(6, images.getImage4());
			ps.setString(7, images.getImage5());

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
	public Images getImageByImageCode(String goodimagecode) {

		String sql = "select * from images where imagecode = ?";

		Connection conn = JDBCUtils.getConn();

		Images images2 = new Images();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goodimagecode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				images2.setId(rs.getInt(1));
				images2.setImagecode(rs.getString(2));
				images2.setUsercodecode(rs.getString(3));
				images2.setImage1(rs.getString(4));
				images2.setImage2(rs.getString(5));
				images2.setImage3(rs.getString(6));
				images2.setImage4(rs.getString(7));
				images2.setImage5(rs.getString(8));

				System.out.println(images2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.cloConn(conn);
		}
		return images2;
	}

	@Override
	public boolean updateImage(Images images) {
		System.out.println("DAO-----------------"+images);
		Connection conn = JDBCUtils.getConn();
		String sql = "update images set imageusercode= ?,image1= ?,image2= ?,image3=?,image4= ?,image5 = ? where imagecode = ? ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			
			ps.setString(1, images.getUsercodecode() );
			ps.setString(2, images.getImage1());
			ps.setString(3, images.getImage2());
			ps.setString(4, images.getImage3());
			ps.setString(5, images.getImage4());
			ps.setString(6, images.getImage5());
			ps.setString(7, images.getImagecode());

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
	public boolean deleteImageByimagecode(String goodimagecode) {

		Connection conn = JDBCUtils.getConn();
		String sql = "delete from images where imagecode = '" + goodimagecode + "'";
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
