package training.example.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentWiredBean {
	
	private StudentBean student;

	@Autowired
	public StudentWiredBean(StudentBean student) {
		super();
		this.student = student;
	}
	
	public void test(){
		student.setAge(1);
		student.setName("ea");
		System.out.println(student);
	}
	
	public static void main(String[] args) {
		
	}
}
