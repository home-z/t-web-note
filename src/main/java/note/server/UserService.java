package note.server;


import util.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name,String password);
	
	public NoteResult userRegist(String name,String password,String nike);
}
