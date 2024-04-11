package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        transactions();
        documents();
    }

    public static void transactions() {
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

    public static void documents() {
        Curriculum curriculum = new Curriculum();
        Pdf pdf = new Pdf();
        Report report = new Report();

        System.out.println(curriculum.printDoc());
        System.out.println(pdf.printDoc());
        System.out.println(report.printDoc());
    }
}
