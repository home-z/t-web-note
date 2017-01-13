package db_connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConnection {
	@Test
	public void xmlTest() throws SQLException {
		ApplicationContext ac = new 
		ClassPathXmlApplicationContext("spring-config/spring-mybatis.xml");
		DataSource ds = ac.getBean("dbcp",DataSource.class);
		System.out.println("success:"+ds.getConnection());
	}
}
