package mylab.customer.dao;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerDAO{
	public List<CustomerVO> selectAllCustomer();
	
	public CustomerVO selectCustomer(int id);
	
	public void insertCustomer(CustomerVO customer);
}