package user_dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import note.dao.UserDao;
import note.entity.Cn_User;
import note.server.UserService;
import util.NoteResult;
import util.NoteUtil;

public class TestUserDaoAndUserServer {
	@Test
	public void testUserDao() {
		String config = "spring-config/spring-mybatis.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		UserDao dao = ac.getBean("userDao",UserDao.class);
		Cn_User user = dao.findByName("demo");
		if (user == null) {
			System.out.println("not find userName");
		} else {
			System.out.println("user:"+user);
			System.out.println("pwd:"+user.getCn_user_password());
		}
}

	/**
	 * 测试登录功能
	 */
	@Test
	public void testUserServer() {
		String[] config = {"spring-config/spring-mybatis.xml","spring-config/spring-mvc.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		UserService service = ac.getBean("userService",UserService.class);
		NoteResult result = service.checkLogin("demo", "123456");
		System.out.println(result.getData());
		System.out.println(result.getStat());
		System.out.println(result.getMessage());
	}
}
