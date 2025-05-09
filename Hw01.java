/*
Course: CSC210
Project: Hw01
date: Jan. 22, 2023
author: Vladimir Murray
purpose: Checks the account balance and intrest rates for each individual accounts as well as withdraw and deposit money in those accounts
*/
import java.util.Scanner;
import java.util.Date;
public class Hw01 {
    static int id=0;
    public static void main(String[] args) {
        Account[] ace = new Account[10];
        Scanner in = new Scanner(System.in);
        for(int i=0;i<10;i++){
            ace[i]=new Account();
            ace[i].setID(i);
            ace[i].setBalance(100);
            ace[i].setAnnualInterestRate(4.5);
            
        }
        
        while(true){
            System.out.println("Enter an id: ");
            id = in.nextInt();
            if(id>=0 && id<10){
                break;
            }
            else{
                System.out.println("Invalid id. Please enter a valid ID");
            }
        }
        while(true){
            System.out.println("Main menu\n1: check balance\n2: withdraw\n"
                    + "3: deposit\n4: print summary\n5: exit");
            int x = in.nextInt();
            if (x == 1){
                System.out.println("The balance is " + ace[id].getBalance());
            }
            else if (x == 2){
                System.out.print("Enter an amount to withdraw: ");
                double w = in.nextDouble();
                ace[id].setBalance(ace[id].withdraw(w,ace[id].getBalance()));
            }
            else if (x == 3){
                System.out.print("Enter an amount to deposit: ");
                double d = in.nextDouble();
                ace[id].setBalance(ace[id].deposit(d,ace[id].getBalance()));
            }
            else if (x == 4){
                System.out.println("Account ID is "+ace[id].getID()+"\nBalance is "+
                    ace[id].getBalance()+"\nMonthly interest is "+ace[id].getMonthlyInterest()+
                    "\nThis account was created at "+ ace[id].getDateCreated());
            }
            else if (x == 5){
                break;
            }
            else
                System.out.println("This is not an acceptable option.");
        }
    }
}
class Account{
    Date date = new Date();
    private int id;
    private double balance;
    private double annualInterestRate;
    private String dateCreated= String.format("%tc",date);
    Account(){
        balance = 0;
        annualInterestRate = 0;
        id = 0;
    }
    Account(int a, double bal){
        id = a;
        balance = bal;
    }
    public void setAnnualInterestRate(double newAnnual){
        annualInterestRate = newAnnual;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public void setID(int i){
        id = i;
    }
    public int getID(){
        return id;
    }
    public void setBalance(double b){
        balance = b;
    }
    public double getBalance(){
        return balance;
    }
    public String getDateCreated(){
        return dateCreated;
    }
    public double getMonthlyInterestRate() {
        return ((annualInterestRate/100.0)/12.0);
    }
    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }
    public double withdraw(double with, double ball){
        if (ball < with){
            System.out.println("The amount is too large, ignored.");
            return ball;
        }
        else {
            return (ball - with);
        }
    }
    public double deposit(double dep,double ball){
        if (dep >= 0){
            return (ball + dep);
        }
        else{
            System.out.println("The amount is negative, ignored.");
            return ball;
        }
    }
    
}