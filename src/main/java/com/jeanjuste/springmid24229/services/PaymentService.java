package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.Payment;
import com.jeanjuste.springmid24229.models.StudentRegistration;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentService {
    List<Payment> findAllPayments();
    Payment savePayment(Payment payment);

}
