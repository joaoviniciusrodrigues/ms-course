package com.devsuperior.hrpayroll.resources;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long wordkerId, @PathVariable("days") Integer days) {
        Payment payment = service.getPayment(wordkerId, days);
        return ResponseEntity.ok(payment);
    }
}
