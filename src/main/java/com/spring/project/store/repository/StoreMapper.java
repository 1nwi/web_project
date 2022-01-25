package com.spring.project.store.repository;


import com.spring.project.store.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    //제품 저장
    boolean save(Product product);

    //전체 제품 정보 조회
    List<Product> findAll();

    //제품 정보 조회
    Product findOne(int productNo);

    //제품 삭제
    boolean remove(int productNo);
}
