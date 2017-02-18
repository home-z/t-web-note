package note.server;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import note.dao.NoteBookDao;
import note.entity.Cn_NoteBook;
import note.entity.Note;
import util.NoteResult;

@Service("booksService")
public class BooksServicImp implements BooksService {
	
	@Resource
	private NoteBookDao noteBookDao;
	
	/*
	 *(non-Javadoc)
	 * @see note.server.BooksService#loadUserBooks(java.lang.String)
	 */
	public NoteResult loadUserBooks(String userId) {
		NoteResult res = new NoteResult();
		List<Cn_NoteBook> books = noteBookDao.allNoteBook(userId);
		if (books != null) {
			res.setStat(0);
			res.setData(books);
			res.setMessage("查询用户全部笔记本完成");
			return res;
		}
		return null;
	}

	/**
	 * 
	 */
	public NoteResult findNote(String noteId) {
		NoteResult result = new NoteResult();
		List<Note> books = noteBookDao.fingByNote(noteId);
		if (books != null) {
			result.setStat(0);
			result.setMessage("success!");
			result.setData(books);
			return result;
		}
		return null;
	}

}
