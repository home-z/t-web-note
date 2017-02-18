package user_service;

import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import note.controller.user.UserController;
import note.entity.Cn_User;
import note.server.UserService;
import util.NoteResult;

public class RegistTest {
	@Test
	public void registServer() {
		String[] confing = {"spring-config/spring-mvc.xml","spring-config/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(confing);
		UserService regist = ac.getBean("userService",UserService.class);
		UserController uc = new UserController();
		NoteResult res = uc.userAdd("888", "Sockt", "nicheng");
		Cn_User c = new Cn_User();
		System.out.println(c.getCn_user_name());
		System.out.println(res.getMessage());
		
		}
}
