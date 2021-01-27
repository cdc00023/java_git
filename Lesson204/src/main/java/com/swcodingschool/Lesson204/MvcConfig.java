package com.swcodingschool.Lesson204;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/* Step. 4
 * addViewControllers는 4개의 view를 추가하는데
 * 앞의 두개는 home.hml에서 정의된 이름을 home으로 가지는 뷰이고
 * 세번째는 hello.html에서 정의된 hello라는 이름을 가진 뷰이며
 * 네번째는 login이라는 이름을 가진 뷰로 다음 단계에서 만들 것이다.
 * 이 파일까지만 구성하더라도 애플리케이션을 실행할 수 있으나, 
 * 로그인 없이 동작할 것이다. 즉, unsecured web application을 
 * 구성 완료하였다.
 * 
 * Step 5. Set up spring security
 * 인증되지 않은 사용자는 /hello의 greeting view를 못보게 할 경우를 가정하자.
 * 인증된 사용자만 보도록 제한하기 위해 Spring Security 환경설정을 하여야 한다.
 * 이를 위해 먼저... pom.xml에 spring-boot-starter-security와 test를 추가하자. 
 * 
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
	}
}
