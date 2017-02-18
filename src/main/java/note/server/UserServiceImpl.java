package note.server;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import note.dao.UserDao;
import note.entity.Cn_User;
import util.NoteResult;
import util.NoteUtil;
@Service("userService")//service 接口
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
		//数据库中的密码多数已经过加密处理，这里无需再做加密，否则密码会不一致
		String md5Pwd = NoteUtil.md5(password);
		if (!user.getCn_user_password().equals(md5Pwd)) {
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

	//注册
	public NoteResult userRegist(String name, String nike, String password) {
		NoteResult result = new NoteResult();
		Cn_User exist =  userDao.findByName(name);
		if (exist != null) {
			result.setMessage("该用户名已存在");
			result.setStat(1);
			return result;
		} else {
				Cn_User user = new Cn_User();
				String id = NoteUtil.createId();
				user.setCn_user_id(id);
				user.setCn_user_name(name);
				String md5Pwd = NoteUtil.md5(password);
				user.setCn_user_password(md5Pwd);
				user.setCn_user_nick(nike);
				userDao.addUser(user);
	//			result.setData(data);
				result.setMessage("注册成功");
				result.setStat(0);
				return result;
			}
		}
	}
