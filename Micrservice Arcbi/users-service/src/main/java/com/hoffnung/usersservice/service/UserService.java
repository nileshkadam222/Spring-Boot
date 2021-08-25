package com.hoffnung.usersservice.service;

import com.hoffnung.usersservice.VO.Department;
import com.hoffnung.usersservice.VO.ResponseTemplateVo;
import com.hoffnung.usersservice.entity.User;
import com.hoffnung.usersservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside Save Useer of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        log.info("Inside Save getUserWithDepartment of UserService");
        ResponseTemplateVo vo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
