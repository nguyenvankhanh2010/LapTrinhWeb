package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import config.DBConnectionSQL;
import dao.IUserDao;
import models.UserModel;

public class UserDaoImpl implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> list = new ArrayList<UserModel>();

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getString("username"), rs.getString("password"), rs.getString("image"),
						rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getInt("roleid"),
						rs.getDate("createdate")));
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createdate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertregister(UserModel user) {
		String sql = "INSERT INTO users(id, roleid, password,username, fullname, phone, email, createdate, images) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setInt(2, user.getRoleid());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getFullname());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getEmail());
			ps.setDate(8, user.getCreatedate());
			ps.setString(9, user.getImages());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				// user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("image"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createdate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String sql = "Select *From users where username = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}

	public void insert(UserModel user) {
		String sql = "INSERT INTO [users](roleid, password,username, fullname ,phone, email,createdate,image) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getRoleid());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getEmail());
			ps.setDate(7, user.getCreatedate());
			ps.setString(8, user.getImages());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			IUserDao userDao = new UserDaoImpl();
//			System.out.print(userDao.findByUserName("khanh"));
			UserModel user = new UserModel("kiki", "12223", "", "kiki", "", "", 1, null);
			userDao.insert(user);
			System.out.print("sdsd");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean changePassword(String email, String newEncodedPassword) {
		String sql = "UPDATE users SET password = ? WHERE email = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newEncodedPassword);
			ps.setString(2, email);
			int rowsUpdated = ps.executeUpdate();
			return rowsUpdated > 0;
		} catch (Exception exception) {
			return false;
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		String query = "SELECT 1 FROM users WHERE email = ?";
		try  {
			 conn =new  DBConnectionSQL().getConnection(); 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
