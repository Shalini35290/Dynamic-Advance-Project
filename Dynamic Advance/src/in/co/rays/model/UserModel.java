package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {
	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getAddress());
		int i = ps.executeUpdate();
		conn.commit();
		conn.close();

		System.out.println("Data Inserted : " + i);

	}

	public void update(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(
				"update user set first_Name = ?, last_Name = ?,login_Id = ?,password = ?,address = ? where id = ?");
		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getAddress());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();
		conn.commit();
		conn.close();
		System.out.println("Data Updated: " + i);

	}

	public void delete(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
		ps.setInt(1, bean.getId());

		int i = ps.executeUpdate();
		conn.close();

		System.out.println("data deleted" + i);
	}

	public UserBean authenticate(String loginId, String password) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from User where login_id = ? and password = ?");
		ps.setString(1, loginId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
		}
		return bean;

	}

	public UserBean Search(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sbf = new StringBuffer("select * from user where 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sbf.append("and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sbf.append("and name like ' " + bean.getFirstName() + " % '");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sbf.append("and lastName like ' " + bean.getLastName() + " % '");
			}
		}

		PreparedStatement ps = conn.prepareStatement(sbf.toString());
		ResultSet rs = ps.executeQuery();

		ArrayList list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
		}

		return bean;

	}

	public List Search() throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		ArrayList list = new ArrayList();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			list.add(bean);
		}
		return list;
	}

	public UserBean findByPk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
		}

		return bean;

	}

}
