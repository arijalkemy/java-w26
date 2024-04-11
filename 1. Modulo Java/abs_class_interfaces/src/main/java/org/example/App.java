package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Executive");
        Executive executive = new Executive();
        executive.makeDeposit();
        executive.makeTransfer();
        System.out.println("Colab");
        Colab colab = new Colab();
        colab.cashWithdraw();
        colab.viewBalance();
        System.out.println("Basic");
        Basic basic = new Basic();
        basic.makePayment();
        basic.cashWithdraw();
        basic.viewBalance();
    }
}
