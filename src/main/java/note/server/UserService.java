package note.server;


import util.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name,String password);
	
//	NoteUtil registUser(Integer id,String name);
}
