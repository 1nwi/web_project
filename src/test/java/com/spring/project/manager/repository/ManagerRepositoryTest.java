package com.spring.project.manager.repository;

import com.spring.project.manager.domain.Auth;
import com.spring.project.manager.domain.Manager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Test
    @DisplayName("아이디, 폰번 중복확인 성공해야 한다.")
    void dupleTest() {
        String inputId = "aaa111";
        int result = managerRepository.isDuplicateId(inputId);
        assertEquals(1, result);

        String inputPhoneNumber = "010-1111-2222";
        int result2 = managerRepository.isDuplicatePhone(inputPhoneNumber);
        assertEquals(1, result2);

    }

    @Test
    @DisplayName("로그인 검증을 수행해야 한다.")
    void loginTest() {
        //로그인 시도 아이디, 비번
        String inputId = "aaa111", inputPw = "aaa1111";
        //아이디를 통해 회원정보조회하고 조회가 안되면 null
        Manager manager = managerRepository.findManager(inputId);

        if (manager != null) {
            //db에 저장된 비밀번호 조회
            String dbPw = manager.getPassword();
            //암호화된 비번을 평문으로 내부적 디코딩후 비교
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(inputPw, dbPw)) {
                System.out.println("로그인 성공");
            } else {
                System.out.println("비밀번호가 틀림");
            }
        } else {
            System.out.println("가입된 아이디가 아닙니다.");
        }
    }



}