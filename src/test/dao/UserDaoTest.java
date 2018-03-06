package test.dao;

import org.junit.Test;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

/**
 * UserDao的测试
 * @author cxf
 *
 */
public class UserDaoTest {
	@Test
	public void testFindByUsername() {
		UserDao userDao = new UserDao();
		User user = userDao.findByUsername("赵六");
		System.out.println(user);
	}
	
	@Test
	public void testAdd() {
		UserDao userDao = new UserDao();
		
		User user = new User();
		user.setUsername("李四");
		user.setPassword("liSi");
		userDao.add(user);
	}
}
