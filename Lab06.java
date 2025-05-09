/**
 * course: CSC 210
 * project: Lab06
 * date: March 3, 2023
 * author: Vladimir Murray
 * purpose: To print all the permutations of a string using recursive method.
 */
import java.util.Scanner;
public class Lab06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String s = in.next();
        displayPermutation(s);
    }
    public static void displayPermutation(String s){
        for(int x = 0;x<s.length();x++){
            String l = s.substring(0,x)+s.substring(x+1);
            displayPermutation(s.substring(x,x+1),l);
        }
    }
    public static void displayPermutation(String s1, String s2){
        if(s2.length()==0){
            System.out.println(s1);
        }
        for(int x = 0;x<s2.length();x++){
            String a = s1+s2.substring(x,x+1);
            String b = s2.substring(0,x)+s2.substring(x+1);
            displayPermutation(a,b);
        }
    }
}