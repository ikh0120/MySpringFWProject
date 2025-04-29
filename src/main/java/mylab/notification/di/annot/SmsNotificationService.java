//구현 클래스
package mylab.notification.di.annot;

public class SmsNotificationService implements NotificationService {
    private String provider; //SMS 제공업체
    
    public SmsNotificationService(String provider) { //SMS 제공업체 주입(생성자 사용)
        this.provider = provider;
    }
    
    public String getProvider() { return provider; } // SMS 제공업체 반환
    
    @Override
    public void sendNotification(String message) { // SMS 알람 전송 기능
    	System.out.println("SMS 알림 전송: " + message + " (제공업체: " + provider + ")");
    }
}