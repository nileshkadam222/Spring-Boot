package com.nilhartech.jwt.controller;

import com.nilhartech.jwt.config.JwtTokenProvider;
import com.nilhartech.jwt.dto.AuthenticationResponse;
import com.nilhartech.jwt.dto.LoginDto;
import com.nilhartech.jwt.dto.UpdateEmailRequest;
import com.nilhartech.jwt.entity.User;
import com.nilhartech.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody LoginDto loginDto){
        {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(), loginDto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // get token form tokenProvider
            String token = tokenProvider.generateToken(authentication);

            return ResponseEntity.ok(new AuthenticationResponse(token));
        }
    }


    @GetMapping("/welcome")
    public String  authenticateUser(){
        {
            return "Hi my Name is nilesh";
        }
    }

    @PostMapping("/updateEmail")
    public String updateEmail(@RequestBody UpdateEmailRequest updateEmailRequest){
        User u = new User(5,"pooja","123","test.com");
        userRepository.save(u);
        userRepository.updateEmailById("test22.com",5);
        userRepository.delete(u);
        return "done";
    }
}