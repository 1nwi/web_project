package com.spring.project.store.repository;

import com.spring.project.store.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreMapperTest {

    @Autowired
    StoreMapper storeMapper;

    @Test
    @DisplayName("제품 등록과 조회 성공해야 한다.")
    void saveTest() {

        storeMapper.save(new Product("에어컨",1825000, 16));

        List<Product> productList = storeMapper.findAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    @DisplayName("제품정보를 개별조회 한다.")
    void findOneInfoTest() {

        Product product = storeMapper.findOne(3);
        System.out.println(product == null);
        System.out.println(product);
//        Assertions.assertNull(product);
    }

    @Test
    @DisplayName("제품 정보를 삭제한다.")
    void removeTest() {
        storeMapper.remove(1);
    }


}