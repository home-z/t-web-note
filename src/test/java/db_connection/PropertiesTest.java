package db_connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class PropertiesTest {
	//读取并测试 连接db参数
	@Test
	public void propertie() throws IOException {
	Properties pro = new Properties();
	InputStream is = 
			//获取指向类路径中属性文件的输入流
		PropertiesTest.class.getClassLoader() 
		.getResourceAsStream("mysql-db.properties");
	pro.load(is);
	
	String connection = pro.getProperty("jdbc.url");
	System.out.println("db-url"+connection);
	}
}
