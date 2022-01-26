package com.spring.project.store.service;

import com.spring.project.store.domain.Product;
import com.spring.project.store.repository.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreMapper storeMapper;

    @Autowired
    public StoreService(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    //제품 전체조회 중간척리
    public List<Product> findAll() {
        List<Product> productList = storeMapper.findAll();

        return productList;
    }

    //제품 등록 중간처리
    public void save(Product product) {
        product.calcTotal();
        storeMapper.save(product);
    }

    //제품 삭제 중간처리
    public void remove(int productNo) {
        storeMapper.remove(productNo);
    }

    //제품 조회 중간처리
    public Product findOne(int productNo) {
        Product product = storeMapper.findOne(productNo);

        return product;
    }

}
