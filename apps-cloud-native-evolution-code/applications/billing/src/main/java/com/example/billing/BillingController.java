package com.example.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {


    @Autowired
    private com.example.payments.Gateway paymentGateway;


    @RequestMapping(value = "/reocurringPayment", method = RequestMethod.POST)
    public ResponseEntity<String> reoccurringPayment(@RequestBody int amount) {


        ResponseEntity<String> response;
        if (paymentGateway.createReocurringPayment(amount)) {
            response = new ResponseEntity<>("{errors: []}", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("{errors: [\"error1\", \"error2\"]}", HttpStatus.BAD_REQUEST);
        }

        return response;

    }

    @RequestMapping("/")
    public String index() {
        return "Hello";
    }

}