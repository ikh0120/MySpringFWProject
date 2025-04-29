package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration // 스프링이 객체를 생성하고 의존성 주입(DI:Dependency Injection)
public class NotificationConfig {
	@Bean
	public EmailNotificationService emailNotificationService() {
		return new EmailNotificationService("smtp.gmail.com", 587);
	}

	@Bean
	public SmsNotificationService smsNotificationService() {
		return new SmsNotificationService("SKT");
	}

	
	@Bean
	public NotificationManager notificationManager() {
		return new NotificationManager(emailNotificationService(), smsNotificationService());
	}
}
