package mylab.customer.dao.mapper;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerMapper{
	public List<CustomerVO> selectAllCustomer();
	
	public CustomerVO selectCustomerById(int id);
	
	public void insertCustomer(CustomerVO customer);
	
}