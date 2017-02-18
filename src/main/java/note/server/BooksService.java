package note.server;

import util.NoteResult;

public interface BooksService {
	/**
	 * 加载用户笔记本列表
	 * load UserAll NoteBook
	 * @param userId 用户id
	 * @return
	 */
	NoteResult loadUserBooks(String userId);
	
	/**
	 * 加载笔记本中的笔记list
	 * @param bookId 笔记本id
	 * @return
	 */
	NoteResult findNote(String noteId);

}
