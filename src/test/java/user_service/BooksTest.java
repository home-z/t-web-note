package user_service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import note.server.BooksService;
import util.NoteResult;

public class BooksTest {
	@Test
	public void findBooks() {
		String[] configs = {"spring-config/spring-mvc.xml","spring-config/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		BooksService service = ac.getBean("booksService",BooksService.class);
		NoteResult result = service.loadUserBooks("ea09d9b1-ede7-4bd8-b43d-a546680df00b");
		String msg = result.getMessage();
		System.out.println(msg);
		System.out.println(result.getStat());
	}
	
	@Test
	public void findNote() {
		String[] configs = {"spring-config/spring-mvc.xml","spring-config/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		BooksService service = ac.getBean("booksService",BooksService.class);
		NoteResult result = service.findNote("4b86d1f9-6345-4532-bc50-ee86442f004b");
		System.out.println(result.getStat());
		System.out.println(result.getMessage());
		System.out.println(result.getData());
	}
}
