/**
 * course: CSC 210
 * project: Hw09
 * date: April 13, 2023
 * author: Vladimir Murray
 * purpose: To find how many baby names are used by both genders in a year
 * as well as how many babies of a certain gender use that name in ascending 
 * order.
 */

import java.util.*;
import java.io.*;
public class Hw09 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the year: ");
        String x = in.nextLine();
        year(x);
        
        while(true){
            System.out.print("\nEnter another inquiry? (y/n) ");
            String y = in.nextLine();
            if("y".equals(y)){
                System.out.print("\nEnter the year: ");
                String xa = in.nextLine();
                year(xa);
            }
            else if (y.equals("n")){
                System.out.println("Thanks for using my program!");
                System.exit(0);
            }
            else
                System.out.println("Enter either y or n please");
        }
    }
    public static void year(String n) throws IOException{
        try{
            
            Set<String> sbegin = new TreeSet<>();
            Set<String> sfinal = new TreeSet<>();
            Map<String,Integer> b = new TreeMap<>();
            Map<String,Integer> g = new TreeMap<>();
            File f = new File("babynamesranking"+n+".txt");
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                sc.nextInt();
                String q = sc.next();
                int qp = sc.nextInt();
                sbegin.add(q);
                b.put(q,qp);
                String w = sc.next();
                int wl = sc.nextInt();
                sfinal.add(w);
                g.put(w,wl);
            }
            sc.close();
            sfinal.retainAll(sbegin);
            
            int x = sfinal.size();
            System.out.println("\n"+x+" names were used in both genders in year "+n);
            ArrayList<String> all = new ArrayList<>();
            all.addAll(sfinal);
            
            
            for(int i = 0;i<all.size();i++){
                
                String a = all.get(i);
                System.out.println(a+": boy("+b.get(a)+") girl("+g.get(a)+")");
            }
            
        }
        catch(Exception ex){
            System.out.println("This file does not exist.");
        }
    }
    
}
