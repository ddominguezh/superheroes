package com.ddominguezh.superhero.shared.domain.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan({"com.ddominguezh.superhero.app"})
public class WebMVC implements WebMvcConfigurer {
	
	@Bean
	public FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean() {
		FilterRegistrationBean<CharacterEncodingFilter> registrationBean = new FilterRegistrationBean<CharacterEncodingFilter>();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterEncodingFilter);
		return registrationBean;
	}

}
