package mylab.customer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.vo.CustomerVO;

//DB 접근 로직을 처리하는 클래스(Mapper 호출 등)
//DB 접근을 담당
//MyBatis의 SqlSession을 직접 사용하여 SQL 실행 가능
@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	CustomerMapper customerMapper;
	
	
	@Override
	public List<CustomerVO> selectAllCustomer(){
		return customerMapper.selectAllCustomer();
	}
	
	
	@Override
	public void insertCustomer(CustomerVO customer) {
		customerMapper.insertCustomer(customer);
	}

	@Override
	public CustomerVO selectCustomer(int id) {
		return customerMapper.selectCustomerById(id);
	}

}