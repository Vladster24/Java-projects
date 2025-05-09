/**
 * course: CSC189
 * project: Homework 11
 * date: 11/22/19
 * author: Vladimir Murray
 * purpose: This program either increases the binary code by one, 
 * decreases the binary code by one, 
 * or prints out the binary codes that go from 0 to n
 */
package hw11;
import java.util.Scanner;

class BinaryStrings {
    String incBinary(String b){
        int a=b.length();
        String s="";
        if(b.lastIndexOf('0')==-1){
            s+='1';
            for(int i=0;i<a;i++)
                s+='0';
        }
        else if(b.lastIndexOf('0')==a-1){
            s = b.substring(0,a-1);
            s+='1';
        }
        else{
            s = b.substring(0,b.lastIndexOf('0'));
            s+='1';
            for(int i=0;i<a-(b.lastIndexOf('0')+1);i++)
                s+='0';
        }
        return s;
    }
    String decBinary(String b){
        int a=b.length();
        String s="";
        if(b.lastIndexOf('1')==a-1){
            s = b.substring(0,a-1);
            s += '0';
        }
        else if(b.lastIndexOf('1')==0){
            for(int i=0;i<a-1;i++)
                s += '1';
        }
        else{
            s = b.substring(0,b.lastIndexOf('1'));
            s+='0';
            for(int i=0;i<a-(b.lastIndexOf('1')+1);i++)
                s+='1';
        }
        return s;
    }
    void printBinary(int n){
        String b="0";
        String s="";
        for(int i=0;i<=n;i++){
            s += " "+b+",";
            b = incBinary(b);
        }
        System.out.println(s.substring(1,s.length()-1));
    }
}
public class Hw11 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        BinaryStrings BinStr = new BinaryStrings();
        String res,bin;
        int n;
        
        do{
            System.out.println("i: increase binary");
            System.out.println("d: decrease binary");
            System.out.println("p: print binary");
            System.out.println("q: Quit");
            System.out.println("Select: ");
            res = in.next();
            switch(res.charAt(0)){
                case 'i':
                case 'I':
                    System.out.println("Enter a binary number: ");
                    bin = in.next();
                    System.out.println(BinStr.incBinary(bin));
                    break;
                case 'd':
                case 'D':
                    System.out.println("Enter a binary number: ");
                    bin = in.next();
                    System.out.println(BinStr.decBinary(bin));
                    break;
                case 'p':
                case 'P':
                    System.out.println("Enter a number: ");
                    n = in.nextInt();
                    BinStr.printBinary(n);
                    break;
                case 'q':
                case 'Q':
                    System.out.println("bye!");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }while(res.charAt(0)!='q' && res.charAt(0)!='Q');
    }
    
}
