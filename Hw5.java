/**
 * course: CSC189
 * project: Hw 5
 * date: 9/20/19
 * author: Vladimir Murray
 * purpose: This program randomly generates 5 numbers and the user will win money 
 * depending on what combinations are made. 
 */
package hw5;

import java.util.Random;
public class Hw5
{
    
    public static void main(String[] args)
    {
        Random rand = new Random();
        
        int r1,r2,r3,r4,r5;//5 digits generated
        double prize;
        
        r1=rand.nextInt(9)+1;//generate an integer between 1 and 9
        r2=rand.nextInt(9)+1;
        r3=rand.nextInt(9)+1;
        r4=rand.nextInt(9)+1;
        r5=rand.nextInt(9)+1;
        System.out.println(r1+","+r2+","+r3+","+r4+","+r5);
        
        int temp;
        if(r1>r2){
            temp = r1;
            r1=r2;
            r2=temp;
        }
        if(r2>r3){
            temp = r2;
            r2=r3;
            r3=temp;
        }
        if(r3>r4){
            temp = r3;
            r3=r4;
            r4=temp;
        }
        if(r4>r5){
            temp = r4;
            r4=r5;
            r5=temp;
        }
        
        if(r1>r2){
            temp = r1;
            r1=r2;
            r2=temp;
        }
        if(r2>r3){
            temp = r2;
            r2=r3;
            r3=temp;
        }
        if(r3>r4){
            temp = r3;
            r3=r4;
            r4=temp;
        }
        
        if(r1>r2){
            temp = r1;
            r1=r2;
            r2=temp;
        }
        if(r2>r3){
            temp = r2;
            r2=r3;
            r3=temp;
        }
        
        if(r1>r2){
            temp = r1;
            r1=r2;
            r2=temp;
        }
        prize=0;
        if(r1==r2 && r1==r3 && r1==r4 && r1==r5)
            prize+=10000;
        else
        {
            if((r1==r2 && r2==r3 && r3==r4) || (r2==r3 && r3==r4 && r4==r5))
                prize+=1000;
            else
            {
                if(((r1==r2 && r1==r3) && r4==r5) || (r1==r2 && (r3==r4 && r3==r5)))
                    prize+=110;
                else if((r1==r2 && r2==r3) || (r2==r3 && r3==r4) || (r3==r4 && r4==r5))
                    prize+=100;
                else
                {
                    if((r1==r2 && (r3==r4 || r4==r5)) || (r2==r3 && r4==r5))
                    prize+=20;
                    else if(r1==r2 || r2==r3 || r3==r4 || r4==r5)
                    prize+=10;
                }
            }
        }
        System.out.println("You won $"+prize+".");
    }
    
}
