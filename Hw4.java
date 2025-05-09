/**
 * course: CSC189
 * project: Hw4
 * date: 9/14/19
 * author: Vladimir Murray
 * purpose: This program takes a sentence that has 5 words and organizes the words by length
 */
package hw4;

import java.util.Scanner;
public class Hw4 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        String a,b,c,d,e,s,r,tmp;
        
        System.out.println("Enter a sentance that has 5 words.");
        s = in.nextLine();
        
        a = s.substring(0,s.indexOf(" "));
        b = s.substring(a.length()+1,s.indexOf(" ",a.length()+1));
        c = s.substring(a.length()+b.length()+2,s.indexOf(" ",a.length()+b.length()+2));
        d = s.substring(a.length()+b.length()+c.length()+3,s.indexOf(" ",a.length()+b.length()+c.length()+3));
        e = s.substring(a.length()+b.length()+c.length()+d.length()+4,s.length());
        
        
        // pass 1
        if (a.length()>b.length()){
            tmp = a;
            a = b;
            b = tmp;
        }
        if (b.length()>c.length()){
            tmp = b;
            b = c;
            c = tmp;
        }
        if (c.length()>d.length()){
            tmp = c;
            c = d;
            d = tmp;
        }
        if (d.length()>e.length()){
            tmp = d;
            d = e;
            e = tmp;
        }
        
        // pass 2
        if (a.length()>b.length()){
            tmp = a;
            a = b;
            b = tmp;
        }
        if (b.length()>c.length()){
            tmp = b;
            b = c;
            c = tmp;
        }
        if (c.length()>d.length()){
            tmp = c;
            c = d;
            d = tmp;
        }
        
        // pass 3
        if (a.length()>b.length()){
            tmp = a;
            a = b;
            b = tmp;
        }
        if (b.length()>c.length()){
            tmp = b;
            b = c;
            c = tmp;
        }
        
        // pass 4
        if (a.length()>b.length()){
            tmp = a;
            a = b;
            b = tmp;
        }
        
        r = a+" "+b+" "+c+" "+d+" "+e;
        
        
        System.out.println(r);
        
    }
    
}
