package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class TestJDBCDataSource {
public static void main(String[] args) throws Exception {
	testDcp();
}

private static void testDcp() throws Exception {
	Connection conn = JDBCDataSource.getConnection();
PreparedStatement ps =	conn.prepareStatement("select * from user where id = 1");
ResultSet rs = ps.executeQuery();
UserBean bean = null;
while(rs.next()) {
	bean = new UserBean();
	System.out.println("\t=" +rs.getInt(1));
	System.out.println("\t=" +rs.getString(2));
	System.out.println("\t=" +rs.getString(3));
	System.out.println("\t=" +rs.getString(4));
	System.out.println("\t=" +rs.getString(5));
	System.out.println("\t=" +rs.getString(6));
}

	
}
}
