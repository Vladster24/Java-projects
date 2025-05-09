/*
Course: CSC210
Project: Lab01
date: Jan. 20, 2023
author: Vladimir Murray
purpose: Determine if a credit card number is valid or not
 */

import java.util.Scanner;
public class Lab01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer:");
        long x = in.nextLong();
        if (isValid(x) == true){
            System.out.println(x + " is valid");
        }
        else{
            System.out.println(x + " is invalid");
        }
    }
    public static boolean isValid(long number) {
        if ( ( (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) && (prefixMatched(number,4)||prefixMatched(number,5)||prefixMatched(number,6)||prefixMatched(number,37)) ){
            return true;
        }
         return false;
    }
    public static int sumOfDoubleEvenPlace(long number) {
        int even = 0;
        number /= 10;
        int d;
        while (number>0) {
            d=(int)(number%10);
            even += getDigit(d*2);
            number /= 100;
        }
        return even;
    }
    public static int getDigit(int number) {
        if (number/10 == 0){
            return number;
        }
        else{
            return (1+(number%10));
        }
    }
    public static int sumOfOddPlace(long number) {
        int odd = 0;
        while (number>0) {
            odd += ((int)(number % 10));
            number /= 100;
        }
        return odd;
    }
    public static boolean prefixMatched(long number, int d) {
        if(getPrefix(number,getSize(d)) == d){
            return true;
        }
        else{
            return false;
        }
    }
    public static int getSize(long d) {
        int s = 0;
        while (d>0){
            s++;
            d /= 10;
        }
        return s;
    }
    public static long getPrefix(long number, int k) {
        return (number /(long)Math.pow(10,getSize(number)-k));
    }
    
}
