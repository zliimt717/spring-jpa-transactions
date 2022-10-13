package com.example.springjpatransactions.entity.repository;

import com.example.springjpatransactions.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {

}
