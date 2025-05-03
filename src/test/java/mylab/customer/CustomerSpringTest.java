package mylab.customer;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.customer.dao.CustomerDAO;
import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class CustomerSpringTest{
	
	SqlSession sqlSession;
	
	SqlSessionFactory sqlSessionFactory;
	
	DataSource datasource;
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	CustomerDAO custDAO;
	
	@Autowired
	CustomerMapper custMapper;
	
	@Test
	void testCustomer() {
		custService.insertCustomer(new CustomerVO("aaaa@naver.com", "SKShildus", 26));
		
		
		
		
	}
	
	
}