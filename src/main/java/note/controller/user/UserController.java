package note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.server.UserService;
import util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	/**
	 * 登录
	 * @param name 
	 * @param password
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult userLogin(String name,String password) {
		NoteResult result = userService.checkLogin(name, password);
		return result;
	}
	
	/**
	 * 
	 * @param name
	 * @param password
	 * @param nike
	 * @return
	 */
	@RequestMapping("regist.do")
	@ResponseBody
	//从前端以Ajax技术传过来的json数据用其key获得value
	//controller的方法参数是对应前段json传过来的key，否则将无法获取数据
	public NoteResult userAdd(String pwd,String nikename,String name){
		//TODO 注册功能未完成
		//调用业务方法时传入参数的顺序不能乱
		NoteResult result = userService.userRegist(name,nikename, pwd);
		return result;
	}
	
}
