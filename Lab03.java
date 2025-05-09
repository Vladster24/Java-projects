/**
 * course: CSC 210
 * project: Lab03
 * date: Feb. 3, 2023
 * author: Vladimir Murray
 * purpose: To find the rows and columns with the most 1's in it
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Lab03 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the array size n: ");
        int x = s.nextInt();
        
        int[][] a = new int[x][x];
        for(int r=0;r<x;r++){
            for(int c=0;c<x;c++){
                a[r][c] = (int)(Math.random()*2);
            }
        }
        
        System.out.println("The random array is ");
        for(int row=0;row<a.length;row++){
            for(int col=0;col<a[row].length;col++){
                System.out.print(a[row][col]+" ");
            }
            System.out.println();
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        int inamnt=0;
        for(int b=0;b<x;b++){
            int in=0;
            for(int c=0;c<x;c++){
                if(a[b][c]==1)
                    in++;
            }
            
            if(in>inamnt){
                list1.clear();
                list1.add(b);
                inamnt = in;
            }
            else if(in==inamnt){
                list1.add(b);
            }
        }
        System.out.println("The largest row index: "+list1);
        int k=0;
        for(int c=0;c<x;c++){
            int l=0;
            for(int b=0;b<x;b++){
                if(a[b][c]==1)
                    l++;
            }
            
            if(l>k){
                list2.clear();
                list2.add(c);
                k = l;
            }
            else if(l==k){
                list2.add(c);
            }
        }
        System.out.println("The largest column index: "+list2);
        
    }
    
}
