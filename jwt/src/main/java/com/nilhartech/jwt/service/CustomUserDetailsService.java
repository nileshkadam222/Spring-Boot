package com.nilhartech.jwt.service;

import com.nilhartech.jwt.entity.User;
import com.nilhartech.jwt.exception.BlogAPIException;
import com.nilhartech.jwt.exception.ResourceNotFoundException;
import com.nilhartech.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findByUserName(usernameOrEmail);
       if(user.isPresent()){
           return new org.springframework.security.core.userdetails.User(user.get().getUserName(),
                   user.get().getPassword(), new ArrayList<>());
       }
        throw new BlogAPIException(HttpStatus.NOT_FOUND,"Not found");
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
