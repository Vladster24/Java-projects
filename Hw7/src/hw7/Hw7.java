/**
 * course: CSC189
 * project: Hw 7
 * date: 10/19/19
 * author: Vladimir Murray
 * purpose: uses the different points on the program to determine
 * what type of triangle it is if it is a triangle
 */
package hw7;

public class Hw7 {

    public static int formTriangle(double x1, double y1, double x2, double y2, double x3, double y3){
        double a,b,c;
        //side lengths of the triangle
        a = Math.sqrt((y1-y2)*(y1-y2)+(x1-x2)*(x1-x2));
        b = Math.sqrt((y2-y3)*(y2-y3)+(x2-x3)*(x2-x3));
        c = Math.sqrt((y3-y1)*(y3-y1)+(x3-x1)*(x3-x1));
        //determines the type of triangle the points make
        if(  ((y1-y2)/(x1-x2)) == ((y2-y3)/(x2-x3))  )
            return 0;
        else if(  Math.round((a*a)+(b*b))==Math.round(c*c) || Math.round((c*c)+(b*b))==Math.round(a*a) || Math.round((a*a)+(c*c))==Math.round(b*b)  )
            return 1;
        else if(  Math.round((a*a)+(b*b))<Math.round(c*c) || Math.round((a*a)+(c*c))<Math.round(b*b) || Math.round((c*c)+(b*b))<Math.round(a*a)  )
            return 3;
        else
            return 2;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(formTriangle(0,0,0,3,3,0)); 
        System.out.println(formTriangle(0,0,1,1,2,2)); 
        System.out.println(formTriangle(1,1,0,0,0,2)); 
        System.out.println(formTriangle(1,1,5,1,6,4)); 
        System.out.println(formTriangle(1,1,3,1,2,3)); 
        System.out.println(formTriangle(0,0,5,0,3,10)); 
        System.out.println(formTriangle(4,5,8,10,12,15)); 
        System.out.println(formTriangle(1,1,0,0,2,2));
        System.out.println(formTriangle(2,2,1,1,0,0));
        System.out.println(formTriangle(2,2,0,0,1,1));
        System.out.println(formTriangle(0,0,2,2,1,1));
        System.out.println(formTriangle(1,1,2,2,0,0));
    }
    
}
