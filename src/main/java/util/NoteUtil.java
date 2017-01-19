package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
public class NoteUtil {
	public static String createId() {
		//号称能生成具有全球唯一性的id...来用作表的主键
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id;
	}
	
	/**
	 * 将msg采用MD5算法处理,返回一个String结果
	 * @param msg 明文
	 * @return 密文
	 */
	public static String md5(String msg) {
		try {
			//getInstance参数为所请求算法的名称
			MessageDigest md = MessageDigest.getInstance("MD5");
			//传入要加密的数据
			byte[] input = msg.getBytes();
			//加密数据
			byte[] output = md.digest(input);
			//采用Base64将加密内容output转成String字符串
			String s = Base64.encodeBase64String(output);
			return s;
		} catch (NoSuchAlgorithmException e) {
			System.out.println("md5加密失败");
			return null;
		}
	}
	
	public static void main(String[] args) {
//		for (int i = 0; i < 8; i++) {
//			System.out.println(createId());
//		}
		String pwd = NoteUtil.md5("123456");
		System.out.println("加密后:"+pwd);
	}
}
