package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	@Test
	public void UserServiceTest() {
		assertNotNull(userService);
		
//		assertNotNull(userService.getUserRepository());
//		assertEquals("MySQL", userService.getUserRepository().getDbType());
		
//		assertNotNull(userService.getSecurityService());
		
		assertTrue(userService.registerUser("IDID", "NAMENAME", "PASSWDPASSWD"));
	}
	
}
