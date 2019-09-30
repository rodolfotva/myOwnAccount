package com.tva.myownaccount.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.myownaccount.model.SpringUserDetails;
import com.tva.myownaccount.model.User;
import com.tva.myownaccount.repositorie.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    
	private static final Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class.getName());
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        
        logger.info("loadUserByUsername() : {}", username);
        return new SpringUserDetails(user);
    }
}
