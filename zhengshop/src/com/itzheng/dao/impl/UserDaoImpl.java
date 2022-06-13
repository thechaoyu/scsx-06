package com.itzheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itzheng.dao.UserDao;
import com.itzheng.entity.User;
import com.itzheng.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public int findCountUserByNameOrEmail(String name, String email) {
		String sql = "select count(*) from user where  name like '%" + name + "%' and email like '%" + email + "%'  ";
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
	public ArrayList<User> findAllUserByNameOrEmail(String name, String email, int firstpage, int page) {
		// TODO Auto-generated method stub
		ArrayList<User> arrayList = new ArrayList<User>();

		Connection conn = JDBCUtils.getConn();

		String sql = "select * from user where name like '%" + name + "%' and email like '%" + email + "%' limit "
				+ firstpage + "," + page;
		System.out.println(sql);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				User user = new User();

				user.setId(rs.getInt(1));
				user.setUsercode(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setPhone(rs.getString(7));
				user.setUsertype(rs.getString(8));
				user.setState(rs.getString(9));
				user.setImage(rs.getString(10));
				user.setDate(rs.getString(11));

				arrayList.add(user);
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
	public boolean addUserSubmit(User user) {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtils.getConn();
		String sql = "insert into user(usercode,username,password,name,email,phone,usertype,state,image,date) values(?,?,?,?,?,?,?,?,?,?) ";
		System.out.println(sql);
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsercode());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getName());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getUsertype());
			ps.setString(8, user.getState());
			ps.setString(9, user.getImage());
			ps.setString(10, user.getDate());

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
	public User findUserByusercode(String usercode) {
		String sql = "select * from user where usercode = ?";

		Connection conn = JDBCUtils.getConn();

		User user2 = new User();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usercode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				user2.setId(rs.getInt(1));
				user2.setUsercode(rs.getString(2));
				user2.setUsername(rs.getString(3));
				user2.setPassword(rs.getString(4));
				user2.setName(rs.getString(5));
				user2.setEmail(rs.getString(6));
				user2.setPhone(rs.getString(7));
				user2.setUsertype(rs.getString(8));
				user2.setState(rs.getString(9));
				user2.setImage(rs.getString(10));
				user2.setDate(rs.getString(11));

				System.out.println(user2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.cloConn(conn);
		}
		return user2;
	}

	@Override
	public boolean updateUserSubmit(User user) {
		
		Connection conn = JDBCUtils.getConn();
		String sql = "update user set usercode= ?,username= ?,password= ?,name= ?,email=?,phone= ?,usertype = ?,state= ?,date= ?  where id = ? ";
		System.out.println(sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			

			ps.setString(1, user.getUsercode());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getName());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getUsertype());
			ps.setString(8, user.getState());
			ps.setString(9, user.getDate());
			ps.setInt(10, user.getId() );
			
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
	public boolean updateUserSubmitImg(User user) {
		Connection conn = JDBCUtils.getConn();
		String sql = "update user set usercode= ?,username= ?,password= ?,name= ?,email=?,phone= ?,usertype = ?,state= ?,image = ?,date= ?  where id = ? ";
		System.out.println(sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			

			ps.setString(1, user.getUsercode());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getName());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getUsertype());
			ps.setString(8, user.getState());
			ps.setString(9, user.getImage());
			ps.setString(10, user.getDate());
			ps.setInt(11, user.getId() );
			
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
	public boolean deleteUserBycode(String usercode) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCUtils.getConn();
		String sql = "delete from user where usercode = '" + usercode+"'";
		//String sql = "delete from store where id = " + id;
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
	public User getUserByEmailAndPassword(String email, String password) {
		String sql = "select * from user where email = ? and password = ?";

		Connection conn = JDBCUtils.getConn();

		User user2 = new User();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				user2.setId(rs.getInt(1));
				user2.setUsercode(rs.getString(2));
				user2.setUsername(rs.getString(3));
				user2.setPassword(rs.getString(4));
				user2.setName(rs.getString(5));
				user2.setEmail(rs.getString(6));
				user2.setPhone(rs.getString(7));
				user2.setUsertype(rs.getString(8));
				user2.setState(rs.getString(9));
				user2.setImage(rs.getString(10));
				user2.setDate(rs.getString(11));

				System.out.println(user2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.cloConn(conn);
		}
		return user2;
	}
}
