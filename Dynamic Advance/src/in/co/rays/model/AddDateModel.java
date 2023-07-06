package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.bean.AddDateBean;
import in.co.rays.util.JDBCDataSource;

public class AddDateModel {
	public static void addDate(AddDateBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert into person values(?)");
		ps.setDate(1,new java.sql.Date(bean.getDob().getTime()));
		int i = ps.executeUpdate();
		conn.commit();
		conn.close();
		System.out.println("Data Inserted =" +i);
		
	}
	

}
