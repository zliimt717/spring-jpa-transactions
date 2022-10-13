package com.example.springjpatransactions.service;

import com.example.springjpatransactions.entity.PassengerInfo;
import com.example.springjpatransactions.entity.PaymentInfo;
import com.example.springjpatransactions.entity.dto.FlightBookingAcknowledgement;
import com.example.springjpatransactions.entity.dto.FlightBookingRequest;
import com.example.springjpatransactions.entity.repository.PassengerInfoRepository;
import com.example.springjpatransactions.entity.repository.PaymentInfoRepository;
import com.example.springjpatransactions.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){

        PassengerInfo passengerInfo=request.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo=request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0],passengerInfo);

    }

}
