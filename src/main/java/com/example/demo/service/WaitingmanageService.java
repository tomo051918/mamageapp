package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Waitingmanage;
import com.example.demo.repository.WaitingmanageRepository;

@Service
@Transactional
public class WaitingmanageService {
	
	@Autowired
    WaitingmanageRepository repository;
	
    /**
     * データベースから来店情報の一覧を取得する
     * @return
     */
    public List<Waitingmanage> findAll() {
        return repository.findAll();
    }
    
    /**
     * データベースからshopidに紐づく来店情報を取得する
     * @return
     */
    public List<Waitingmanage> findAllByShopId(Integer shopId) {
        return repository.findAllByShopId(shopId);
    }
    
    /**
     * データベースからshopidに紐づく番号の最大値を取得する
     * @return
     */
    public Integer findMaxWaitingNumberByShopId(Integer shopId) {
        return repository.findMaxWaitingNumberByShopId(shopId);
    }
    
    /**
     * データベースからshopidに紐づく番号の最大値を取得する
     * @return
     */
    public Integer findCountWaitingNumber(Integer shopId,Integer waitingNumber) {
        return repository.findCountWaitingNumber(shopId,waitingNumber);
    }
    
    public List<Waitingmanage> findByStatusIsNotAndShopIdOrderByWaitingNumberAsc(Integer shopId) {
        return repository.findByShopIdAndStatusNotOrderByWaitingNumberAsc(shopId, 2); 
    }
    
    public void updateStatus(Integer id, Integer status) {
        Waitingmanage waitingManage = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid waitingManage Id:" + id));
        waitingManage.setStatus(status);
        repository.save(waitingManage);
    }

}
