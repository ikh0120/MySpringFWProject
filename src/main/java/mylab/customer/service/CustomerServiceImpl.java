//CustomerService 인터페이스를 구현한 구현체
//@Service 어노테이션으로 스프링 빈으로 등록
//DAO에 의존성 주입(@Autowired)를 통해 데이터 엑세스 기능 사용
package mylab.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mylab.customer.dao.CustomerDAO;
import mylab.customer.vo.CustomerVO;

@Service 
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<CustomerVO> getAllCustomerList(){
		return customerDAO.selectAllCustomer(); 
	}
	
	@Override
	public CustomerVO getCustomerInfo(int id) {
		return customerDAO.selectCustomer(id);
	}
	
	@Override 
	public void insertCustomer(CustomerVO customer) {
		customerDAO.insertCustomer(customer);
	}
	
}