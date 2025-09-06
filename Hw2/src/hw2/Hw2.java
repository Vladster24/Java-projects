/*
 * course: CSC189
 * project: Hw 2
 * date: 8/30/2019
 * author: Vladimir Murray
 * purpose: This program reads a length in(km,m,cm,mm) and converts it to
 * (miles, yards, feet, inches).
 */
package hw2;

import java.util.Scanner;
public class Hw2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int km,m,cm,mm; //input variables
        int miles,yards,feet,inches; //output variables
        
        System.out.print("Enter kilometer part of input: ");
        km=in.nextInt();
        System.out.print("Enter meter part of input: ");
        m=in.nextInt();
        System.out.print("Enter centimeter part of input: ");
        cm=in.nextInt();
        System.out.print("Enter millimeter part of input: ");
        mm=in.nextInt();
        
        int totalmm = (km*1000*100*10)+(m*100*10)+(cm*10)+mm;
        int totalin = (int) (totalmm*0.0393701);
        
        miles = totalin/63360;
        yards = (totalin%63360)/36;
        feet = ((totalin%63360)%36)/12;
        inches = (((totalin%63360)%36)%12);
        
        System.out.println("("+km+" km, "+m+" m, "+cm+" cm, "+mm+" mm)="+
        "("+miles+" miles, "+yards+" yards, "+feet+" feet, "+inches+" inches)");
    }
    
}
