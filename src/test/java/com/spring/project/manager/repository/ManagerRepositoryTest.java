package com.spring.project.manager.repository;

import com.spring.project.manager.domain.Auth;
import com.spring.project.manager.domain.Manager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ManagerRepositoryTest {
    @Autowired
    ManagerRepository managerRepository;

    @Test
    @DisplayName("회원가입")
    void regTest() {
        Manager manager = new Manager();
        manager.setId("aaa111");

        //암호화
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode("aaa1111");
        manager.setPassword(encodePassword);

        manager.setName("홍길동");
        manager.setPhoneNumber("010-1111-2222");
        manager.setAuth(Auth.ADMIN);

        managerRepository.register(manager);
    }
}