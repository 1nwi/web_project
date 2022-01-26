package com.spring.project.store.controller;

import com.spring.project.store.domain.Product;
import com.spring.project.store.service.StoreService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Log4j2
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    //제품 등록화면
    @GetMapping("/store/insert")
    public String insert() {
        return "store/store-list";
    }

    //제품 전체조회
    @GetMapping("/store/list")
    public String list(Model model) {
        List<Product> productList = storeService.findAll();
        model.addAttribute("products",productList);
        return "store/store-list";
    }

    //제품 등록 요청
    @PostMapping("/store/register")
    public String register(Product product) {
        storeService.save(product);
        return "redirect:/store/list";
    }

    //제품 상세보기 요청
    @GetMapping("/store/detail")
    public String detail(int productNo, Model model) {
        Product product = storeService.findOne(productNo);
        model.addAttribute("product",product);
        return "store/detail";
    }

    //제품 삭제 처리
    @GetMapping("store/delete")
    public String delete(int productNo) {
        storeService.remove(productNo);
        return "redirect:/store/list";
    }

}
