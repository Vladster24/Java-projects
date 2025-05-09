/**
 * Course: CSC210
 * Project: Hw06
 * date: March 19, 2023
 * author: Vladimir Murray
 * purpose: To use recursive methods to print a string in reverse, and all of
 * the substrings using only duplicated substrings and only loops.
 */
import java.util.Scanner;
public class Hw06 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input a string: ");
        String i = in.next();
        System.out.print("The reversed string: ");
        reverseS(i);
        System.out.print("\nThe substrings of the input string: ");
        printSub1(i);
        System.out.print("\nThe substrings of the input string: ");
        printSub2(i);
    }
    public static void reverseS(String s){
        System.out.print(s.substring(s.length()-1));
        if(s.length()>1)
            reverseS(s.substring(0,s.length()-1));
    }
    public static void printSub1(String s){
        System.out.print(s+" ");
        if(s.length()>1)
            printSub1(s.substring(0,s.length()-1));
        if(s.length()>1)
            printSub1(s.substring(1));
    }
    public static void printSub2(String s){
        for(int i = 1;i<=s.length();i++)
            System.out.print(s.substring(0,i)+" ");
        if(s.length()>1)
            printSub2(s.substring(1));
    }
    
}
