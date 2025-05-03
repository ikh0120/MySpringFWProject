package mylab.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mylab.customer.vo.CustomerVO;


public interface CustomerService{
	public List<CustomerVO> getAllCustomerList();
	
	public CustomerVO getCustomerInfo(int id);
	
	public void insertCustomer(CustomerVO customer);
}