package com.skillstorm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// this class can also declare/instatiate Beans
// this annotation is required for this
@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// this disables Cross-Site Resource Forgery
		// we'd ultimately want to deal with this, but not today!
		http.csrf().disable();
		
		// setting up basic auth
		// if you wanted to customize aspects of basic auth, you could do so here
		http.httpBasic(Customizer.withDefaults());
		
		// here, we can lay out which requests need authentication and which don't
		http.authorizeHttpRequests(requests -> {
			
			// matching particular endpoints
			// you can match by URL suffix or HTTP method or both
			// we used to use Ant matchers (from Apache Ant), but they were way too specific and didn't allow wildcarding
			// now, we use MVC matching, which can be more general (/main and /main/ are thought of as the same thing) and use wildcards
			
			// ORDER MATTERS!!
			// from top to bottom, when a request matches one of these, that behavior will be applied
			// regardless of whether a later match would reverse it
			requests.requestMatchers(HttpMethod.GET, "/main/secure/**").authenticated();
			
			requests.requestMatchers(HttpMethod.GET, "/main/**").permitAll();
			
			// we can make blanket statements, then use more specific statements prior to these to allow certain requests
			requests.requestMatchers(HttpMethod.POST, "/**").authenticated();
			requests.requestMatchers(HttpMethod.PUT, "/**").authenticated();
			requests.requestMatchers(HttpMethod.DELETE, "/**").authenticated();
			
			// this allows all requests to be let through with either no auth or correct basic auth
			// if you submit incorrect basic auth, you'll still get a 401 Unauthorized
//			requests.anyRequest().permitAll();
			
			// this requires correct auth for all requests
			requests.anyRequest().authenticated();
			
		});
		
		// eventually, we return the SecurityFilterChain as built from the HttpSecurity object we took in
		return http.build();
	}

}
