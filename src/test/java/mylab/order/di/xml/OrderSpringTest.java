package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
	@Qualifier("shoppingCart")
	ShoppingCart shoppingCart;
	
	
	@Autowired
	@Qualifier("orderService")
	OrderService orderService;
	
	
	
	@Test
	void OrderSTest() {
		System.out.println(shoppingCart.toString()); //ShoppingCart [products=[Product [id=P-001, name=콜라, price=1500.0], Product [id=P-002, name=빵, price=2000.0]]]
		
		assertEquals(3500.0, shoppingCart.getTotalPrice());
		
		System.out.println(orderService.toString()); //OrderService [shoppingCart=ShoppingCart [products=[Product [id=P-001, name=콜라, price=1500.0], Product [id=P-002, name=빵, price=2000.0]]]]

	}
	

}
