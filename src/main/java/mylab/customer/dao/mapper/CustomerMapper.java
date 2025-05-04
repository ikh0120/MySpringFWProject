package mylab.customer.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mylab.customer.vo.CustomerVO;

/* @Mapper 어노테이션은 보통 XML Mapper 또는 @Select, @Insert 등의 어노테이션과 매핑됨
 지금은 CustomerMapper.xml과 매핑됨*/
@Mapper 
public interface CustomerMapper{
	public List<CustomerVO> selectAllCustomer();
	
	public CustomerVO selectCustomerById(int id);
	
	public void insertCustomer(CustomerVO customer);
	
}
