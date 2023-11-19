package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.Payment;
import com.jeanjuste.springmid24229.models.StudentRegistration;
import com.jeanjuste.springmid24229.services.PaymentService;
import com.jeanjuste.springmid24229.services.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PaymentController {
    private StudentRegistrationService studentRegistrationService;
    private PaymentService paymentService;


    @Autowired
    public PaymentController(PaymentService paymentService, StudentRegistrationService studentRegistrationService) {
        this.paymentService = paymentService;
        this.studentRegistrationService = studentRegistrationService;
    }

    @GetMapping("/payments")
    public String createPaymentForm(Model model){
        Payment payment = new Payment();
        List<Payment> payments = paymentService.findAllPayments();
        List<StudentRegistration> studentRegistrations = studentRegistrationService.findAllStudentRegistrations();
        model.addAttribute("payments", payments);
        model.addAttribute("payment", payment);
        model.addAttribute("studentRegistrations", studentRegistrations);
        return "Payment";
    }

    @PostMapping("/payments/new")
    public String savePayment(@ModelAttribute("payment") Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }
}
