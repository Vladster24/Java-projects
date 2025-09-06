/**
 * course: CSC189
 * project: Hw 6
 * date: 10/12/19
 * author: Vladimir Murray
 * purpose: This program finds the rank of the poker hand according to the input made by the user
 */
package hw6;
import java.util.Scanner;
public class Hw6 {
    static void handRanking(int n1,int n2,int n3,int n4,int n5){
        int temp;
        //Sorts the integers from smallest to greatest
        if(n1>n2){
            temp = n1;
            n1=n2;
            n2=temp;
        }
        if(n2>n3){
            temp = n2;
            n2=n3;
            n3=temp;
        }
        if(n3>n4){
            temp = n3;
            n3=n4;
            n4=temp;
        }
        if(n4>n5){
            temp = n4;
            n4=n5;
            n5=temp;
        }
        if(n1>n2){
            temp = n1;
            n1=n2;
            n2=temp;
        }
        if(n2>n3){
            temp = n2;
            n2=n3;
            n3=temp;
        }
        if(n3>n4){
            temp = n3;
            n3=n4;
            n4=temp;
        }
        if(n1>n2){
            temp = n1;
            n1=n2;
            n2=temp;
        }
        if(n2>n3){
            temp = n2;
            n2=n3;
            n3=temp;
        }
        if(n1>n2){
            temp = n1;
            n1=n2;
            n2=temp;
        }
        //prints out the rank of the poker hand
        if((n1==n2 && n2==n3 && n3==n4 && n5!=n4)||(n2==n3 && n3==n4 && n4==n5 && n1!=n2))
            System.out.println("Four of a Kind("+n2+")");
        else if((n1==n2 && n2!=n3 && n3==n4 && n4==n5)||(n1==n2 && n2==n3 && n3!=n4 && n4==n5))
            System.out.println("Full House("+n1+", "+n5+")");
        else if(n1==1 && n2==10 && n3==11 && n4==12 && n5==13)
            System.out.println("Straight("+1+")");
        else if(n1+1==n2 && n2+1==n3 && n3+1==n4 && n4+1==n5)
            System.out.println("Straight("+n5+")");
        else if(n1==n2 && n2==n3)
            System.out.println("Three of a Kind("+n1+")");
        else if(n2==n3 && n3==n4)
            System.out.println("Three of a Kind("+n2+")");
        else if(n3==n4 && n4==n5)
            System.out.println("Three of a Kind("+n3+")");
        else if(n1==n2 && n3==n4 && n1!=n3 && n1!=n5 && n3!=n5 && n1==1)
            System.out.println("Two Pair("+1+","+n3+")");
        else if(n1==n2 && n3==n4 && n1!=n3 && n1!=n5 && n3!=n5)
            System.out.println("Two Pair("+n1+","+n3+")");
        else if(n1==n2 && n4==n5 && n1!=n3 && n1!=n5 && n3!=n5)
            System.out.println("Two Pair("+n1+","+n4+")");
        else if(n2==n3 && n4==n5 && n1!=n3 && n1!=n5 && n3!=n5)
            System.out.println("Two Pair("+n2+","+n4+")");
        else if(n1==n2)
            System.out.println("One Pair("+n1+")");
        else if(n2==n3)
            System.out.println("One Pair("+n2+")");
        else if(n3==n4)
            System.out.println("One Pair("+n3+")");
        else if(n4==n5)
            System.out.println("One Pair("+n4+")");
        else if(n1==1)
            System.out.println("High Card("+1+")");
        else
            System.out.println("High Card("+n5+")");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner key = new Scanner(System.in);
        int n1,n2,n3,n4,n5; //input variables
        System.out.print("Enter five integers in a range(1-13): ");
        n1=key.nextInt();
        n2=key.nextInt();
        n3=key.nextInt();
        n4=key.nextInt();
        n5=key.nextInt();
        
        handRanking(n1,n2,n3,n4,n5);
    }
    
}
