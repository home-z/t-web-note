package note.server;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import note.dao.UserDao;
import note.entity.Cn_User;
import util.NoteResult;
import util.NoteUtil;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	public NoteResult checkLogin(String name, String password) {
		NoteResult result = new NoteResult();
		Cn_User user = userDao.findByName(name);
		if (user == null) {
			result.setStat(1);
			result.setMessage("账号不存在");
			result.setData(null);
			return result;
		}
		String md5Pwd = NoteUtil.md5(password);
		if (user.getCn_user_password().equals(md5Pwd)) {
			result.setStat(2);
//			result.setData("");
			result.setMessage("密码错误");
			return result;
		}
		
		result.setStat(3);
		result.setMessage("登录成功");
		result.setData(user.getCn_user_id());
		
		return result;
	}

}
