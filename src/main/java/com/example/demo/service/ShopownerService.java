package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Shopowner;
import com.example.demo.repository.ShopownerRepository;



@Service
@Transactional
public class ShopownerService {

	@Autowired
    ShopownerRepository repository;
	
    /**
     * データベースから店舗の一覧を取得する
     * @return
     */
    public List<Shopowner> findAll() {
        return repository.findAll();
    }
    
    public Shopowner findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shopowner not found with id: " + id));
    }
    
}
