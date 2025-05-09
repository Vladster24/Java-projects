/**
 * Course: CSC210
 * Project: Hw07
 * date: March 23, 2023
 * author: Vladimir Murray
 * purpose: To evaluate expressions that do not have parentheses
 */

import java.util.Scanner;
import java.util.Stack;
public class Hw07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        System.out.print("Enter an expression: ");
        String x = in.next();
        for(int i = 0;i<x.length();i++){
            String z = x.substring(i,i+1);
            if(z.equals("+") || z.equals("-") || z.equals("*") || z.equals("/")){
                int b = s.pop();
                int a = s.pop();
                s.push(Evaluation(a,b,z));
            }
            else{
                switch (z){
                    case "0": s.push(0);
                    break;
                    case "1": s.push(1);
                    break;
                    case "2": s.push(2);
                    break;
                    case "3": s.push(3);
                    break;
                    case "4": s.push(4);
                    break;
                    case "5": s.push(5);
                    break;
                    case "6": s.push(6);
                    break;
                    case "7": s.push(7);
                    break;
                    case "8": s.push(8);
                    break;
                    case "9": s.push(9);
                    break;
                    default: System.out.println("Not an acceptable value");
                    System.exit(0);
                }
            }
        }
        System.out.println("The evaluated expression is "+s.peek());
    }
    public static int Evaluation(int x, int y, String z){
        if(z.equals("+")){
            return x+y;
        }
        if(z.equals("-")){
            return x-y;
        }
        if(z.equals("*")){
            return x*y;
        }
        if(z.equals("/")){
            if (y==0)
                return 0;
            return x/y;
        }
        return 0;
    }
}
