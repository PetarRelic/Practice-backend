package it.eng.petarrelic.vezba;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import it.eng.petarrelic.vezba.web.filter.LoggingFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.addFilterBefore(new LoggingFilter(), ChannelProcessingFilter.class);
		httpSecurity.authorizeRequests()
			.antMatchers("/")
			.permitAll()
			.anyRequest()	
//			.permitAll()
			.fullyAuthenticated()
			.and().httpBasic().and().csrf().disable().cors();
	}
	
}
