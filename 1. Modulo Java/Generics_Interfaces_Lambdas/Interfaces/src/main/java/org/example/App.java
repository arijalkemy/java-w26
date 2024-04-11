package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Basic customer1 = new Basic();
        Collector customer2 = new Collector();
        Executive customer3 = new Executive();
        customer1.servicePayment();
        customer2.withdrawal();
        customer3.transferMoney();
        customer1.transferMoney();
        customer2.servicePayment();
        customer3.showBalance();
    }
}
