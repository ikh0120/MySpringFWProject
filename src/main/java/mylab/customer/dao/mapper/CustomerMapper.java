package mylab.customer.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mylab.customer.vo.CustomerVO;

@Mapper
public interface CustomerMapper{
	public List<CustomerVO> selectAllCustomer();
	
	public CustomerVO selectCustomerById(int id);
	
	public void insertCustomer(CustomerVO customer);
	
}