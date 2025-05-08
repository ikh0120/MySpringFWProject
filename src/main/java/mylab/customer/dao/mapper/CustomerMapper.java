package mylab.customer.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mylab.customer.vo.CustomerVO;

/* @Mapper 어노테이션은 보통 XML Mapper 또는 @Select, @Insert 등의 어노테이션과 매핑됨
 지금은 CustomerMapper.xml과 매핑됨*/
//SQL과 VO 매핑을 위한 인터페이스(MyBatis가 구현체를 자동으로 생성)
//SQL을 실행하기 위한 메스드 정의
//MyBatis가 XMl과 자동 연결하여 구현체를 만들어줌
@Mapper 
public interface CustomerMapper{
	public List<CustomerVO> selectAllCustomer();
	
	public CustomerVO selectCustomerById(int id);
	
	public void insertCustomer(CustomerVO customer);
	
}
