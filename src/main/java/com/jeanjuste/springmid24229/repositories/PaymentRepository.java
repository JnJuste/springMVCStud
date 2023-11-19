package com.jeanjuste.springmid24229.repositories;

import com.jeanjuste.springmid24229.models.Payment;
import com.jeanjuste.springmid24229.models.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,UUID> {

}
