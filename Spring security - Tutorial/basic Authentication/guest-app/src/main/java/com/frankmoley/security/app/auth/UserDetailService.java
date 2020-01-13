package com.frankmoley.security.app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepositoty userRepositoty;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepositoty.findByUserName(s);
        if(user == null){
            throw new UsernameNotFoundException("User Name Not Found");
        }
        return new UserPrincipal(user);
    }
}
