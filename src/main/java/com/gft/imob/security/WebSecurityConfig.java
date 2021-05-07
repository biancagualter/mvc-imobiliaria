package com.gft.imob.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	DataSource dataSource; 
	
	@Autowired
	private UserDetailsServiceClass userDetailsService;
	
	@Autowired 
	private SuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().disable()
			.authorizeRequests()
				.antMatchers("/js/**", "/css/**", "/images/**").permitAll()
				.antMatchers("/home/**").hasRole("ADMIN")
				.antMatchers("/homepage/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/imoveis/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/imoveis/novo/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/imoveis/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE,"/imoveis/**").hasRole("ADMIN")
				.antMatchers("/categorias/**").hasRole("ADMIN")
				.antMatchers("/categorias/novo/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/categorias/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE,"/categorias/**").hasRole("ADMIN")
				.antMatchers("/negocios/**").hasRole("ADMIN")
				.antMatchers("/negocios/novo/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/negocios/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE,"/negocios/**").hasRole("ADMIN")
				.antMatchers("/estados/**").hasRole("ADMIN")
				.antMatchers("/estados/novo/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/estados/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE,"/estados/**").hasRole("ADMIN")
				.antMatchers("/municipios/**").hasRole("ADMIN")
				.antMatchers("/municipios/novo/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/municipios/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE,"/municipios/**").hasRole("ADMIN")
				.antMatchers("/bairros/**").hasRole("ADMIN")
				.antMatchers("/bairros/novo/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/bairros/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE,"/bairros/**").hasRole("ADMIN")
					.anyRequest().fullyAuthenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.successHandler(successHandler)
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll();
			
	}
	
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
}
