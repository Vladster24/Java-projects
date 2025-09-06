/**
 * course: CSC189
 * project: Hw 3
 * date: 9/7/2019
 * author: Vladimir Murray
 * purpose: The purpose of this program is to create a java program that reads all the substrings of a string or number that is 5 characters long
 */
package hw3;

import java.util.Scanner;
public class Hw3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sent,a,b,c,d,e;
        int f,o,tw,th,fr,fi;
        System.out.println("Enter in five letters: ");
        sent=in.nextLine();
        a=sent.substring(0,1);
        b=sent.substring(1,2);
        c=sent.substring(2,3);
        d=sent.substring(3,4);
        e=sent.substring(4,5);
        System.out.println(a);
        System.out.println(a+b);
        System.out.println(a+b+c);
        System.out.println(a+b+c+d);
        System.out.println(a+b+c+d+e);
        System.out.println(b);
        System.out.println(b+c);
        System.out.println(b+c+d);
        System.out.println(b+c+d+e);
        System.out.println(c);
        System.out.println(c+d);
        System.out.println(c+d+e);
        System.out.println(d);
        System.out.println(d+e);
        System.out.println(e);
        System.out.println("Enter five digits: ");
        f=in.nextInt();
        o=f/10000;
        tw=(f%10000)/1000;
        th=((f%10000)%1000)/100;
        fr=(((f%10000)%1000)%100)/10;
        fi=((((f%10000)%1000)%100)%10);
        System.out.println(o);
        System.out.println(o+""+tw);
        System.out.println(o+""+tw+""+th);
        System.out.println(o+""+tw+""+th+""+fr);
        System.out.println(o+""+tw+""+th+""+fr+""+fi);
        System.out.println(tw);
        System.out.println(tw+""+th);
        System.out.println(tw+""+th+""+fr);
        System.out.println(tw+""+th+""+fr+""+fi);
        System.out.println(th);
        System.out.println(th+""+fr);
        System.out.println(th+""+fr+""+fi);
        System.out.println(fr);
        System.out.println(fr+""+fi);
        System.out.println(fi);
        
        
        
    }
    
}
