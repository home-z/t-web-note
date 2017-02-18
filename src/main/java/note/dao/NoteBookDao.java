package note.dao;

import java.util.List;

import note.entity.Cn_NoteBook;
import note.entity.Note;

public interface NoteBookDao {
	public List<Cn_NoteBook> allNoteBook(String userId);
	
	List<Note> fingByNote(String noteId);
}
