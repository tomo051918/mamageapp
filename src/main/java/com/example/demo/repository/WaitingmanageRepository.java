package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Waitingmanage;

public interface WaitingmanageRepository extends JpaRepository<Waitingmanage, Integer> {
    List<Waitingmanage> findAllByShopId(Integer shopId);

    @Query("SELECT MAX(w.waitingNumber) FROM Waitingmanage w WHERE w.shopId = :shopId")
    Integer findMaxWaitingNumberByShopId(@Param("shopId") Integer shopId);

    @Query("SELECT COUNT(w.waitingNumber) FROM Waitingmanage w WHERE w.shopId = :shopId AND w.status = 0 AND w.waitingNumber < :waitingNumber")
    Integer findCountWaitingNumber(@Param("shopId") Integer shopId, @Param("waitingNumber") Integer waitingNumber);

    @Query("SELECT w FROM Waitingmanage w WHERE w.shopId = :shopId AND w.status != :status ORDER BY w.waitingNumber ASC")
    List<Waitingmanage> findByShopIdAndStatusNotOrderByWaitingNumberAsc(@Param("shopId") Integer shopId, @Param("status") Integer status);
}