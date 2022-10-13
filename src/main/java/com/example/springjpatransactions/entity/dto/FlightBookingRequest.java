package com.example.springjpatransactions.entity.dto;

import com.example.springjpatransactions.entity.PassengerInfo;
import com.example.springjpatransactions.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;

}
