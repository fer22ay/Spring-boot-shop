/**
 * 
 */
package com.fernando.fshop.negocio.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.fshop.model.Role;
import com.fernando.fshop.model.Users;
import com.fernando.fshop.negocio.repository.UserRepository;

/**
 * Clase que contiene metodo para autenticar usuario en la aplicacion
 * 
 * @author : Fernando Ambrosio
 * @since : 05/04/2020
 *
 */
@Service
@Transactional(readOnly = true)
public class UserDetail implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Users users = userRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido."));

		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
		for (Role role : users.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescripcionRol());
			grantList.add(grantedAuthority);
		}

		UserDetails userDet = new User(userName, users.getPasswordUser(), grantList);
		return userDet;
	}

}
