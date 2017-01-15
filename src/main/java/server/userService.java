package server;

import util.NoteUtil;

public interface userService {
	public NoteUtil checkLogin(String name,String password);
	
//	NoteUtil registUser(Integer id,String name);
}
