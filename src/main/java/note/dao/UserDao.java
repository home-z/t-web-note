package note.dao;

import note.entity.Cn_User;

public interface UserDao {
	
	public Cn_User findByName (String name);
	
	public void  addUser(Cn_User user);
}
