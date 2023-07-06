package in.co.rays.util;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {
	private static JDBCDataSource jds = null;
	private ComboPooledDataSource ds = null;
	private ResourceBundle rs = null;

	private JDBCDataSource() {

		try {
			rs = ResourceBundle.getBundle("in.co.rays.bundle.app");
			ds = new ComboPooledDataSource();
			// ds.setDriverClass("com.mysql.cj.jdbc.Driver");
			// ds.setJdbcUrl("jdbc:mysql://localhost:3306/advance");
			// ds.setUser("root");
			// ds.setPassword("root");
			// ds.setInitialPoolSize(5);
			// ds.setAcquireIncrement(5);
			// ds.setMaxPoolSize(25);
			
			ds.setDriverClass(rs.getString("Driver"));
			ds.setJdbcUrl(rs.getString("url"));

			ds.setUser(rs.getString("user"));

			ds.setPassword(rs.getString("password"));

			ds.setInitialPoolSize(Integer.parseInt(rs.getString("initial")));

			ds.setAcquireIncrement(Integer.parseInt(rs.getString("acquire")));

			ds.setMaxPoolSize(Integer.parseInt(rs.getString("max")));
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static JDBCDataSource getInstance() {
		if (jds == null) {
			jds = new JDBCDataSource();
		}
		return jds;

	}

	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (Exception e) {
			return null;
		}
	}

}
