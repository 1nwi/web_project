package com.spring.project.manager.repository;

import com.spring.project.manager.domain.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerRepository {
    //회원가입 기능
    boolean register(Manager manager);

    //단일 회원정보 조회 기능
    Manager findManager(String id);

    //아이디 중복체크
    int isDuplicateId(String inputKeyword);

    //이메일 중복체크
    int isDuplicatePhone(String inputKeyword);
}
