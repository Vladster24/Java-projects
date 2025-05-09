/**
 * Course: CSC210
 * Project: Lab07
 * date: March 10, 2023
 * author: Vladimir Murray
 * purpose: To check whether if a Java source code file 
 * has a correct pair of grouping symbols.
 */
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
public class Lab07 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        String x = in.next();
        if(symbols(x) == true)
            System.out.println("\n"+x+" is a valid java source code file");
        else
            System.out.println("\n"+x+" is not a valid java source code file");
    }
    public static boolean symbols(String x){
        Stack s = new Stack();
        for(int a = 0;a<x.length();a++){
        try{
            if(x.substring(a,a+1).equals("(") || x.substring(a,a+1).equals("{") || x.substring(a,a+1).equals("["))
                s.push(x.substring(a, a+1));
            if(x.substring(a,a+1).equals(")") || x.substring(a,a+1).equals("}") || x.substring(a,a+1).equals("]")){
                if((s.peek().equals("(") && x.substring(a,a+1).equals(")")) || (s.peek().equals("[") && x.substring(a,a+1).equals("]")) || (s.peek().equals("{") && x.substring(a,a+1).equals("}")))
                    s.pop();
                else
                    return false;
            }
        }
        catch(EmptyStackException ex){
            return false;
        }
        }
        return s.empty();
    }
}
