package com.example.springboot.Lesson202;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/* @SpringBootAplication은 다음의 세가지 에노테이션을 모두 추가하는 에노테이션이다.
 * 
 * 1) @Configuration : 클래스를 애플리케이션 컨텍스트에 대한 Bean정의 소스 태그로 지정
 * 
 * 2) @EnableAotoConfigration : SpringBoot에 클래스 경로 설정, 기타 Bean 및 다양한
 * 속성 설정을 기반으로 Bean추가를 시작하도록 지시하는 에노테이션,
 * 예를 들어 spring-MVC가 클래스 경로에 있는경우, 애플리케이션을 우베 애플리케이션으로
 * 플래그를 지정하고 DispatcherServlet 설정과 같은 주요 동작들을 활성화 시킨다.
 * 
 * 3) @ComfonentScan : Spring의 com.example.springboot 패키지에서 다른 구성요소,
 * 구성 및 서비스를 찾는역할을 함
 */


@SpringBootApplication
public class Lesson202Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson202Application.class, args);
	}
	
	//Step3. application class를 수정.
	/* @Bean으로 표시된 CommandLineRunner매서드는 시작할 때 실행된다.
	 * 애플리케이션에서 생성했거나, Spring Boot에 의해 자동으로 추가된
	 * 모든 Bean을 검색하고, 정렬하여 출력한다.
	 */
	@Bean
	public CommandLineRunner comandLineRunner(ApplicationContext ctx) {
		return args->{
			System.out.println("Let's instpect the beans provided by Spring boot");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for(String beanName : beanNames) {
				System.out.println(beanName);
				
			}
		};
	}
	
	
}
