package com.nibm.EADCW.paymentandnotify.payment;

import com.nibm.EADCW.paymentandnotify.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/payment/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/payment/{email}")
    public List<Payment> getPaymentrById(@PathVariable String email) {
        try {
            List<Payment> payment = paymentRepository.findPaymentByEmail(email);
            if (!payment.isEmpty()) {
                return payment;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(path = "/payment")
    public String createPayment(@RequestBody Payment payment) {
        try {
            paymentRepository.save(payment);
            return "successful";
        } catch (Exception e) {
            return "unsuccessful";
        }
    }
}
