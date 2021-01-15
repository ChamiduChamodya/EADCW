package com.nibm.EADCW.paymentandnotify.payment;

import com.nibm.EADCW.paymentandnotify.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("select p from Payment p where p.email=?1")
    List<Payment> findPaymentByEmail(String email);

}