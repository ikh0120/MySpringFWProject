package mylab.customer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.vo.CustomerVO;

public class CustomerDAOImpl implements CustomerDAO, CustomerMapper{

	@Autowired
	CustomerMapper customerMapper;
	
	
	@Override
	public List<CustomerVO> selectAllCustomer(){
		return customerMapper.selectAllCustomer();
	}
	
	@Override
	public CustomerVO selectCustomerById(int id) {
		return customerMapper.selectCustomerById(id);
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