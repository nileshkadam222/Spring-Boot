package com.nilhartech.jwt;

import com.nilhartech.jwt.entity.User;
import com.nilhartech.jwt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public JwtApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostConstruct
	public void initUser(){
		List<User> users = Stream.of(
				new User(1,"nileshK",passwordEncoder.encode("123"),"nilesh.kadam222@gmail.com"),
				new User(2,"harshuK",passwordEncoder.encode("12345"),"harshu.kadam222@gmail.com"))
				.collect(Collectors.toList());
		userRepository.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
