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


}
