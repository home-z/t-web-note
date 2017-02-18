package note.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.entity.Cn_NoteBook;
import note.server.BooksService;
import util.NoteResult;

@Controller
@RequestMapping("/book")
public class BooksController {
	
	@Resource
	private BooksService booksService;
	
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult findBooks(String userId) {
		NoteResult result = booksService.loadUserBooks(userId);
		return result;
	}
	
	@RequestMapping("/allNote.do")
	@ResponseBody
	public NoteResult allBook(String noteId) {
		NoteResult result = booksService.findNote(noteId);
		return result;
	}
}
