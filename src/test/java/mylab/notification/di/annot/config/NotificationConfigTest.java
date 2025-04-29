package mylab.notification.di.annot.config;

import javax.management.Notification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import mylab.notification.di.annot.SmsNotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	@Autowired
	@Qualifier("emailNotificationService")
	EmailNotificationService ens;

	
	@Autowired
	@Qualifier("smsNotificationService")
	SmsNotificationService sns;
	
	@Autowired
	@Qualifier("notificationManager")
	NotificationManager nm;
	
	@Test
	void testNotification() {
		// ens null인지 확인하기
		assertNotNull(ens);
		assertNotNull(ens.getPort());
		assertNotNull(ens.getSmtpServer());
		
		// sns null인지 확인하기
		assertNotNull(sns);
		assertNotNull(sns.getProvider());
		
		// nm null인지 확인하기
		assertNotNull(nm);
		assertNotNull(nm.getEmailService());
		assertNotNull(nm.getSmsService());
		
		System.out.println("assertEquals 테스트");
		System.out.println("인스턴스 별 메서드 테스트");
		System.out.println("====================");
		
		System.out.println("sns.getProvider():" + sns.getProvider());
		assertEquals("SKT", sns.getProvider());
		
		sns.sendNotification("=== SNS Test message ===");
		
		System.out.println("--------------------");
		
		System.out.println("ens.getPort(): " + ens.getPort());
		assertEquals(587, ens.getPort());
		
		System.out.println("ens.getSmtpServer(): " + ens.getSmtpServer());
		assertEquals("smtp.gmail.com", ens.getSmtpServer());
		
		System.out.println("--------------------");
		
		ens.sendNotification("=== ENS Test message ===");
		
		System.out.println("--------------------");
		
		System.out.println(nm.getEmailService());
		
		System.out.println("--------------------");
		
		System.out.println(nm.getSmsService());
		
		System.out.println("--------------------");
		
		nm.getEmailService().sendNotification("hello getEmail sendNotification");
		nm.getSmsService().sendNotification("hello getSms sendNotification");
		
		System.out.println("--------------------");
		
		nm.sendNotificationByEmail("hello EMAIL");
		nm.sendNotificationBySms("hello SMS");
		
		
	}
}
