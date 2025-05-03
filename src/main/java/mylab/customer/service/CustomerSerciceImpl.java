package mylab.customer.service;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public class CustomerSerciceImpl {
	List<CustomerVO> getAllCustomerList(){
		return null;
	}
	
	CustomerVO getCustomerInfo(int id) {
		CustomerVO cvo = new CustomerVO(id);
		return cvo;
	}
}
