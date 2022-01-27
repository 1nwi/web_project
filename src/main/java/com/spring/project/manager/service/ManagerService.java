package com.spring.project.manager.service;

import com.spring.project.manager.domain.Manager;
import com.spring.project.manager.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;

    //회원가입 중간처리
    public void sign(Manager manager) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePw = encoder.encode(manager.getPassword());
        manager.setPassword(encodePw);

        managerRepository.register(manager);
    }

    //아이디 중복확인
    public boolean isDuplicateId(String id) {
        return managerRepository.isDuplicateId(id) == 1;
    }
    public boolean isDuplicatePhone(String phoneNum) {
        return managerRepository.isDuplicatePhone(phoneNum) == 1;
    }

    //로그인 중간처리
    public LoginFlag login(String inputId, String inputPw) {
        Manager manager = managerRepository.findManager(inputId);
        if(manager != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.matches(inputPw, manager.getPassword()) ? LoginFlag.SUCCESS : LoginFlag.NO_PW;
        } else {
            return LoginFlag.NO_ID;
        }
    }

    //회원정보 가져오기
    public Manager getManager(String id) {
        return managerRepository.findManager(id);
    }


}
