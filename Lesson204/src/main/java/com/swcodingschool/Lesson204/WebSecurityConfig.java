package com.swcodingschool.Lesson204;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*Step 6. WebSecurityConfig class 구성 작업 진행
 * 이 클래스는 Spring Security의 web security 지원과 spring mvc 통합을 제공하기 위하여
 * @EnableWebSecurity 어노테이션으로 구성함.
 * 
 * configure 메서드는 보안처리하거나 하지 않을 URL path를 정의한다.
 * /와  /home path는 보안처리하고 나머지는 모두 보안처리한다.
 * 
 * 사용자가 성공적으로 로그인하면 앞서요구된 페이지로 리다이렉트된다.
 * login 페이지가 있고, 볼 수 있도록 허용된다.
 * 
 * userDetailService() 메서도는 메모리에 사용자를 저장하는 메서드.
 * 
 * 다음 단계는 Step 7. login 페이지를 구성할 단계이다. 
*/


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http  
					.authorizeRequests()
					.antMatchers("/", "/home").permitAll()
					.anyRequest().authenticated()
					.and()
					.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
					.logout()
					.permitAll();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = 
				User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

}
