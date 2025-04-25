package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {
	@Autowired // bean class가 Course인건 하나여서 오류가 안남 //두개 이상이면 @Qualifier() 안에 id를 넣어야 함
	Course course; // class가 Course인 bean은 하나여서 이름도 안맞춰도 됨 //여러개면 이름을 맞춰야 함 

	@Resource(name = "gradeService")
	GradeService service;
	
	@Test
	void testService() {
		assertNotNull(service);
		
		assertEquals("C001",service.getCourse().getCourseId());
		
		assertEquals("A", service.calculateGrade("S001"));
		
		assertEquals(2, service.getHighScoreStudents(80).size());
		
		for (Student student : service.getHighScoreStudents(80)) {
			System.out.println(student);
		}
	}
	
	
	@Test @Disabled 
	void testCource() {
		assertNotNull(course);
		
		// 값 비교를 콘솔로 출력하면 애매해서 잘 안보일 때도 많은데 assertEquals()는 다 잡아 냄
		assertEquals("Java Programming", course.getCourseName());
		
		assertEquals(3, course.getStudents().size());
		
		/*
		 * course => Course => 클래스 인스턴스
		 * course.getStudents() => List<Student> 학생목록
		 * course.getStudents().get(0) => 첫번째 학생
		 * course.getStudents().get(0).getName() => 첫번째 학생 이름
		 */
		assertEquals("엠마", course.getStudents().get(0).getName());
		
		System.out.println(course.getAverageScore()); //출력: 83.33333333333333
		assertEquals(83.333, course.getAverageScore(), 0.001);
		
		
	}
	
}
