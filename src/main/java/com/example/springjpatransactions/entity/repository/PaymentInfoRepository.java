package com.example.springjpatransactions.entity.repository;

import com.example.springjpatransactions.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {

}
