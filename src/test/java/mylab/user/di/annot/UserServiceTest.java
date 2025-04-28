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
		
        // UserRepository 확인
        assertNotNull(userService.getUserRepository());
        assertEquals("MySQL", userService.getUserRepository().getDbType());
        
        // SecurityService(어노테이션으로 주입) 확인
        assertNotNull(userService.getSecurityService());
        
        // 기능 테스트
        assertTrue(userService.registerUser("user1", "홍길동", "password123"));
        assertFalse(userService.registerUser("user2", "김철수", ""));	
	}
	
}
