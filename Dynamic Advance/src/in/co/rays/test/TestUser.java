package in.co.rays.test;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {
		 testAdd();
		// testUpdate();
		// testdelete();
		//testSearch();

	}

	

	private static void testdelete() throws Exception {
		UserBean bean = new UserBean();
		bean.setId(2);
		UserModel model = new UserModel();
		model.delete(bean);

	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		bean.setFirstName("vaishali");
		bean.setLastName("Gour");
		bean.setLoginId("gddfh");
		bean.setPassword("gsdgsfj");
		bean.setAddress("indore");
		bean.setId(15);

		UserModel um = new UserModel();
		um.update(bean);

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("ritu");
		bean.setLastName("rajput");
		bean.setLoginId("sonali@rajput");
		bean.setPassword("abcdef");
		bean.setAddress("Hoshangabad");

		UserModel model = new UserModel();
		model.add(bean);

	}
}
