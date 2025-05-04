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
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	CustomerDAO custDAO;
	
	
	@Test
	void testCustomer() {
		// null값 테스트
		assertNotNull(custService);
		assertNotNull(custDAO);
		//데이터 삽입
//		custService.insertCustomer(new CustomerVO("aaaa@naver.com", "SKShildus", 26));
//		custService.insertCustomer(new CustomerVO("bbbb@naver.com", "SKShildus2", 27));
//		custService.insertCustomer(new CustomerVO("cccc@naver.com", "SKShildus3", 28));
		
		int i = 0;
		for (CustomerVO cust : custService.getAllCustomerList()) {
			i++; // id는 auto_increment여서 1씩 증가하기에 i를 증가시키며 비교
			assertEquals(cust.getId(), i);
			//customer 테이블 레코드 출력
			System.out.println(cust.getId()+"\t"+cust.getEmail()+"\t"+cust.getName()+"\t"+cust.getAge()+"\t"+cust.getEntry_date());
			custService.getCustomerInfo(i);
		}
		
		
	}
	
	
}