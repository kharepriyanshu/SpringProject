package com.hystrixproject.user.service;

import com.hystrixproject.user.VO.Department;
import com.hystrixproject.user.VO.ResponseTemplateVO;
import com.hystrixproject.user.entity.User;
import com.hystrixproject.user.repository.UserRepository;
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
        log.info("Inside saveUser method of user Controller");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserwithDepartment(Long userId) {
        log.info("Inside getUserwithDepartment of userService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://localhost:9002/departments/"+ user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;

    }
}
