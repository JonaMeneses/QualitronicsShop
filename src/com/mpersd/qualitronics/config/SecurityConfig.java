package com.mpersd.qualitronics.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{

		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select sEmail as username, sPassword as password, bActivo as enabled from usuarios where sEmail = ?")
			.authoritiesByUsernameQuery("select t1.sEmail as username, t2.sNombre as authority from usuarios t1 inner join roles t2 on t2.nIdUsuario = t1.nId where sEmail = ?")
			.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().and()
			.authorizeRequests()
			.antMatchers("/","/content/**","/tienda").permitAll()
			.antMatchers(HttpMethod.GET,"/api/**").permitAll()
			.antMatchers(HttpMethod.POST,"/api/**").permitAll()
			.antMatchers(HttpMethod.PUT,"/api/**").permitAll()
			.antMatchers(HttpMethod.DELETE,"/api/**").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
			//Restricciones de ACL acces control list
			.antMatchers("/angular","checkout").hasRole("MEMBER")
			.antMatchers("/admin/**").hasRole("ADMIN")
			//default cualquier otra liga requiere autorizacion
			.anyRequest().authenticated()
			.and()
			//login con formulario
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout();
			
	}
	
	
}
