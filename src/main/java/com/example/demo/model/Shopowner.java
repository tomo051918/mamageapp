package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "shop_owner")
public class Shopowner {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    // 店舗のidを保持するフィールド
    private Integer id;
	
    @Column(name="shop_name")
    // 店舗の店舗IDを保持するフィールド
    private String shop_name;
	
}
