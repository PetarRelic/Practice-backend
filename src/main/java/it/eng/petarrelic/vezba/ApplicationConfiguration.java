package it.eng.petarrelic.vezba;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import it.eng.petarrelic.vezba.web.filter.LoggingFilter;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public LoggingFilter loggingFiler() {
		return new LoggingFilter();
	}
	
	@Bean
	public FilterRegistrationBean<LoggingFilter> loggingFilterRegistration(){
		
		FilterRegistrationBean<LoggingFilter> filterRegistrationBean = new FilterRegistrationBean<LoggingFilter>();
		
		filterRegistrationBean.setFilter(loggingFiler());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return filterRegistrationBean;
	}
}
