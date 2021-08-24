package com.flipkart.service;

public interface paymentInterface {

    boolean makePayment(String studentId);

    boolean verifyPayment(String studentId);

    int calculateFee(String studentId);

}
