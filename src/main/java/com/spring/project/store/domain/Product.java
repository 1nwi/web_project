package com.spring.project.store.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString
@AllArgsConstructor
public class Product {

    private static int sequence;

    private int productNo;       //제품 번호
    private String productName;  //제품 이름
    private int price;           //제품 가격
    private int amount;          //제품 수량
    private int total;           //제품 총 가격

    public Product() {
        this.productNo = ++sequence;
    }

    public Product(String productName, int price, int amount) {
        this();
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        calcTotal();
    }

    //DB조회 데이터 처리 생성자
    public Product(ResultSet rs) throws SQLException {
        this.productNo = rs.getInt("product_no");
        this.productName = rs.getString("product_name");
        this.price = rs.getInt("price");
        this.amount = rs.getInt("amount");
        this.total = rs.getInt("total");
    }

    // 제품 총 가격 메서드
    public void calcTotal() {
        this.total = this.price * this.amount;
    }
}
