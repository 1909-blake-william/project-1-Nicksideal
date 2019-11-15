package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.ConnectionUtil;

public class UserDaoSQL implements UserDao{

	User extractUser(ResultSet rs) throws SQLException {
		int user_id= rs.getInt("user_id");
		String username= rs.getString("username");
		String password= rs.getString("password");
		String race= rs.getString("race");
		String class_type= rs.getString("class_type");
		int req_user_role_id = rs.getInt("req_user_role_id");
		String role_type = rs.getString("role_type");
		return new User(user_id, username, password, race, class_type, 
				new UserRole(req_user_role_id, role_type));
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user_table " + "WHERE username = ? AND password = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			System.out.println(rs + "RS print out");
			if (rs.next()) {
				return extractUser(rs);
				
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findByUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById() {
		// TODO Auto-generated method stub
		return null;
	}

}
