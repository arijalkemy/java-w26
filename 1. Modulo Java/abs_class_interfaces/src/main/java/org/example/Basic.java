package org.example;

public class Basic extends NormalUser {
    public Basic() {
    }

    public void makePayment() {
        ServicePayment payment = new ServicePayment();
        payment.transactionOk();
    }
}
