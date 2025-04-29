package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class UserMyBatisTest {
	protected static final Logger logger = LogManager.getLogger();
	
	@Autowired
	DataSource dataSource;  //DB 연결 객체
	
	@Autowired
	SqlSessionFactory sessionFactory; //MyBatis SQL 세션 팩토리
	
	@Autowired
	SqlSession sqlSession; //SQL을 실행할 수 있는 객체
	
	@Test
	void userMapper() {
		System.out.println("=================");
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly"); // 공백이나 오타 실수나면 무조건 오류
		logger.debug(user);
	}
	
	@Test 
	void sqlSession() {
		// 잘 나오면 spring-beans-mybatis.xml의 SqlSessionFactoryBean 설정이 잘 된 것
		System.out.println("=================");
		System.out.println(sessionFactory.getClass().getName());
		
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly"); // 공백이나 오타 실수나면 무조건 오류
		logger.debug(user);
		
		//Anonymous Inner Class(익명의 내부 클래스) 
		System.out.println("=================");
		List<UserVO> userList = sqlSession.selectList("userNS.selectUserList"); // Return type: List<UserVO>
		//기존의 For Loop
		for (UserVO userVO : userList) {
			logger.debug(userVO);
		}
		
		//.forEach(Consumer)에서 Consumer를 Anonymous Inner Class 형태로 선언한느 방식
		/*
		.forEach(Consumer con)
		list.forEach(new MyConsumer());
		class MyConsumer implements Consumer{
			void accept(Stirng str){
				// 메모리 낭비가 있음
			}
		}
		//그래서 밑의 방법을 씀
		*/
		System.out.println("=================");
		userList.forEach(new Consumer<UserVO>() {
			@Override
			public void accept(UserVO t) {
				logger.debug(user);
			}
		});
		
		
		//Consumer의 추상 메서드는 void accept(T t)이다
		//.forEach(Consumer)에서 Consumer를 Lambda Expression(람다식)으로 선언하는 방식
		// 인터페이스인데 추상 메서드가 하나만 있을 때 람다식을 써야 됨
		System.out.println("========->->->->=========");
//		for (UserVO user1111 : userList) { logger.debug(user1111); } 
		//userList.forEach(user1111 -> logger.debug(user1111));
		userList.forEach(user1111 -> System.out.println(user1111));
		
		//.forEach(Consumer)에서 Consumer를 Method Reference로 선언하는 방식
		System.out.println("========:::::::::=========");
		userList.forEach(System.out::println);
	}
	
	
	@Test @Disabled
	void connection() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			
			logger.debug("DB URL = " + metaData.getURL());
			logger.debug("DB Username = " + metaData.getUserName());
			logger.debug("DB Vendor Name = " + metaData.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}