package user_dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import note.dao.NoteBookDao;
import note.entity.Cn_NoteBook;
import note.entity.Note;
import note.server.BooksService;

public class TestFindBooks {
	@Test
	public void books() {
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-config/spring-mybatis.xml");
		NoteBookDao dao = ac.getBean("noteBookDao",NoteBookDao.class);
		List<Cn_NoteBook> list = dao.allNoteBook("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		if (list != null) {
			String name = null;
			int i=0;
			for (Cn_NoteBook book : list) {
				name = book.getCn_notebook_name();
				System.out.println("该用户的笔记:"+name);
				i++;
			}
			System.out.println("此用户有:"+i+"个笔记本");
		}
		
	}
	
	@Test
	public void findAllNote(){
		String config = "spring-config/spring-mybatis.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		NoteBookDao dao = ac.getBean("noteBookDao",NoteBookDao.class);
		List<Note> list = dao.fingByNote("066af16d-183b-41ff-8a7c-8a8bd6bfccb4");
		if (list != null) {
			for (Note note : list) {
				System.out.println("value:"+note.getCn_note_title()+ 
						"body:"+note.getCn_note_body()+"id:" + 
						note.getCn_note_status_id());
			}
		}
	}

}
