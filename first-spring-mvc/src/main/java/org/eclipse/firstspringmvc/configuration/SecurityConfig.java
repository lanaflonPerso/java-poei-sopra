package org.eclipse.firstspringmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
// authentification statique :
//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		String password = passwordEncoder().encode("user"); // mdp
//		System.out.print("password " + password);
//		manager.createUser(User.withUsername("user").password(password).roles("USER").build()); // login, le rôle (ici
//																								// USER, mais c'est à
//																								// nous de les définir)
//																								// doivent être écrits
//																								// en majuscule
//		return manager;
//		// solution statique, on donne les valeurs de login et de mdp en dur, dans le
//		// codeSource (InMemory)
//	}

//authentification dynamique:
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance(); // NoOpPasswordEncoder : pas dl'ago de cryptage
																		// du mdp
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll(); // on autorise tlm à entrer sur la page de connexion
																	// (login)
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").and().logout()
				.permitAll();
		http.csrf().disable();
		// pour toutes les autres requêtes il faut être authentifié, on précise le
		// chemin du login et on autorise la sortie à tous les users connectés
	}
}
