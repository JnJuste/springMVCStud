package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.Payment;
import com.jeanjuste.springmid24229.models.StudentRegistration;
import com.jeanjuste.springmid24229.repositories.PaymentRepository;
import com.jeanjuste.springmid24229.repositories.StudentRegistrationRepository;
import com.jeanjuste.springmid24229.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    private StudentRegistrationRepository studentRegistrationRepository;
    @Autowired
    public PaymentServiceImpl(StudentRegistrationRepository studentRegistrationRepository, PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
        this.studentRegistrationRepository = studentRegistrationRepository;
    }
    @Override
    public List<Payment> findAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
