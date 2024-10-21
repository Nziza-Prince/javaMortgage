import javax.swing.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    double principal = 0;
    double annualInterest = 0;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    int period = 0;
        final int percentage = 100;
        final int months = 12;
    while(true){
    System.out.print("Principle ($1K - $1M):");
    principal = scanner.nextDouble();
    if(principal >= 1000 && principal <= 1_000_000){
        break;
    }
        System.out.println("Enter a number between 1,000 and 1,000,000");
    }
    while(true){
    System.out.print("Annual interest Rate:");
     annualInterest = scanner.nextDouble();
    if(annualInterest >= 1 && annualInterest <= 100){
        break;
    }
        System.out.println("Enter a value between 1 and 100");
    }
    while (true){
    System.out.print("Period (Years):");
    period = scanner.nextInt();
    if(period >=1 && period <= 30){
        break;
    }
        System.out.println("Enter a value between 1 and 30");
    }

     double monthlyPayment = calculateMortgage(principal,annualInterest,period);
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println(formatter.format(monthlyPayment));
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
     for (int month = 0;month<=period * months;month++){
         double balance = calcualateBalance(principal,annualInterest,period,month);
         System.out.println(formatter.format(balance));
     }
    }
    public static double calculateMortgage(double principal,double annualInterest,int period){
        final int percentage = 100;
        final int months = 12;
        // Convert annual interest rate from percentage to a decimal and then to a monthly rate
        double monthlyInterestRate = (annualInterest / percentage) / months;
        // Convert years to number of monthly payments
        int numberOfPayments = period* months;
        // Apply the mortgage formula
        double monthlyPayment = (principal * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        return monthlyPayment;
    }
    public static double calcualateBalance(double principal,double annualInterest,int period,float numberOfPaymentsMade){
        final int percentage = 100;
        final int months = 12;
        double monthlyInterestRate = (annualInterest / percentage) / months;
        double numberOfpayments = period * months;
        double balance = principal * (Math.pow(1+monthlyInterestRate,numberOfpayments)-Math.pow(1+monthlyInterestRate,numberOfPaymentsMade)/Math.pow(1+monthlyInterestRate,numberOfpayments)-1);

        return balance;
    }
}