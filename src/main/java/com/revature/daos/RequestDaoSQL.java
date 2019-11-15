package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoSQL implements RequestDao {

	private UserDao userDao = UserDao.currentImplementation;

	Request extractRequest(ResultSet rs) throws SQLException {
		int req_id = rs.getInt(8);
		String req_name = rs.getString(9);
		int req_value = rs.getInt(10);
		Timestamp req_submitted = rs.getTimestamp(11);
		Timestamp req_approved = rs.getTimestamp(12);
		String req_memo = rs.getString(13);
		int req_author_id = rs.getInt(14);
		String req_author_name = rs.getString(4);
		int req_resolver_id = 1;
		String req_resolver_name = "DM";
		int req_status_id = rs.getInt(1);
		String req_status_id_name = rs.getString(18);
		int req_type_id = rs.getInt(2);
		String req_type_id_name = rs.getString(17);
		
		return new Request(req_id, req_name, req_value, req_submitted, req_approved, req_memo, req_author_id, req_author_name,
				req_resolver_id, req_resolver_name, req_status_id, req_status_id_name, req_type_id, req_type_id_name);

	}


	@Override
	public int save(Request r) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO request_table (req_id, req_name, req_value, req_submitted, req_approved, req_memo, req_author, req_resolver, req_status_id, req_type_id)"
					+ "    VALUES (req_id_seq.nextval, ?, ?, TO_TIMESTAMP(LOCALTIMESTAMP, 'DD-MON-RR HH.MI.SSXFF PM') ,NULL, ?,?, 1, 2, ?)";
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, r.getReq_name());
			ps.setInt(2, r.getReq_value());
			ps.setInt(3, r.getReq_id());
			ps.setInt(4, r.getReq_author());
			ps.setInt(5, r.getReq_type_id());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	@Override
	public List<Request> findAll() {

		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = " SELECT * " + 
					"    FROM user_table " + 
					"    LEFT JOIN request_table ON (req_author = user_id )" + 
					"    Left JOIN req_type USING (req_type_id)" + 
					"    LEFT JOIN req_status USING (req_status_id);";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Request> request = new ArrayList<Request>();
			while (rs.next()) {
				Request it = new Request(rs.getInt(8), rs.getString(9), rs.getInt(10),
						rs.getTimestamp(11), rs.getTimestamp(12), rs.getString(13),
						rs.getInt(14), rs.getString(4), 1, "DM",  rs.getInt(1), rs.getString(18),
						 rs.getInt(2), rs.getString(17));
				request.add(it);
				System.out.println(request);
			}

			return request;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Request> findByUsername(String userName) {

		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * " + 
					"    FROM user_table " + 
					"    LEFT JOIN request_table ON (req_author = user_id )" + 
					"    Left JOIN req_type USING (req_type_id)" + 
					"    LEFT JOIN req_status USING (req_status_id)" + 
					"    WHERE username = ? ;";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			List<Request> request = new ArrayList<Request>();
			while (rs.next()) {
				Request it = new Request(rs.getInt(8), rs.getString(9), rs.getInt(10),
						rs.getTimestamp(11), rs.getTimestamp(12), rs.getString(13),
						rs.getInt(14), rs.getString(4), 1, "DM",  rs.getInt(1), rs.getString(18),
						 rs.getInt(2), rs.getString(17));
				request.add(it);
			}

			return request;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Request> findByStatus() {

		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM request_table WHERE req_status_id = ?";

			PreparedStatement ps = c.prepareStatement(sql);

			// ps.setInt(1, x);find the req_status_ID from the request.

			ResultSet rs = ps.executeQuery();

			List<Request> request = new ArrayList<Request>();
			while (rs.next()) {
				Request it = new Request(rs.getInt(8), rs.getString(9), rs.getInt(10),
						rs.getTimestamp(11), rs.getTimestamp(12), rs.getString(13),
						rs.getInt(14), rs.getString(4), 1, "DM",  rs.getInt(1), rs.getString(18),
						 rs.getInt(2), rs.getString(17));
				request.add(it);
			}

			return request;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void evaluateRequest(int req_id, int req_status_id) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "UPDATE request_table SET (req_status_id = ?,req_approved = TO_TIMESTAMP(LOCALTIMESTAMP, 'DD-MON-RR HH.MI.SSXFF PM'),  )"
					+ "    WHERE (req_id = ?)";
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, req_status_id);
			ps.setInt(2, req_id);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}
}
