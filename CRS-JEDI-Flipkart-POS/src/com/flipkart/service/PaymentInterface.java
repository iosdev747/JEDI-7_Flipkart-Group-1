package com.flipkart.service;

public interface PaymentInterface {

    boolean makePayment(String studentId);

    boolean verifyPayment(String studentId);

    int calculateFee(String studentId);

}
