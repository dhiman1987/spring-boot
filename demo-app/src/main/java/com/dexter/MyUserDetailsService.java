package com.dexter;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	private Map<String, User> inMomoryUserMap =  new HashMap<>();
	
	/*@PostConstruct
	public void init() {
		inMomoryUserMap.put("jill", new User("jill", "{noop}pswd1"));
		inMomoryUserMap.put("sam", new User("sam", "{noop}pswd2"));
		inMomoryUserMap.put("klaw", new User("klaw", "{noop}pswd3"));
	}
	 @Override
    public UserDetails loadUserByUsername(String username) {
        User user = inMomoryUserMap.get(username);
        if (user == null) {
        	System.out.println("User does not exist");
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
	
	*/
	
	@Autowired
	private UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
        	System.out.println("User does not exist");
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}