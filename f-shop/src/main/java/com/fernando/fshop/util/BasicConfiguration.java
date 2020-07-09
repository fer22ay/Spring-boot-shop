/**
 * 
 */
package com.fernando.fshop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fernando.fshop.negocio.services.UserDetail;

/**
 * Clase para manejar el tema de seguridad
 * 
 * @author Fernando Ambrosio
 * @since 18 de marzo del 2020
 */
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetail userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	/**
	 * Metodo para encripatr password en la base de datos
	 * 
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/app/login")
				.permitAll().failureUrl("/app/login?error=true").defaultSuccessUrl("/app/home", true)
				.usernameParameter("username").passwordParameter("password").and().logout().permitAll()
				.logoutSuccessUrl("/app/login?logout");
	}

	@Override
	public void configure(WebSecurity security) {
		security.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
