package ex2.task4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FindKingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FindKingApplication.class, args);
		// URL: http://localhost:8080/index.html
	}
}
