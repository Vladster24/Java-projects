/**
 * course: CSC 210
 * project: Hw05
 * date: March 3, 2023
 * author: Vladimir Murray
 * purpose: To generate a file with top five baby names for 
 * each year or to find where a name is ranked in a specific year.
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Hw05 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        while(true){
        System.out.println("a. Generate a file containing top five names\nb.Search a name ranking in a specific year\nq. quit\nSelect: ");
        String c = in.next();
        if(c.equals("a")){
            topFiveNames();
        }
        else if (c.equals("b")){
            searchRanking();
        }
        else if (c.equals("q")){
            System.exit(0);
        }
        }
            
    }
    static void topFiveNames() throws IOException {
        Scanner in = new Scanner(System.in);
        File p = new File("topFiveBabyNames.txt");
        
        PrintWriter output = new PrintWriter(p);
        int l = 2001;
        output.printf("%-15s","Year");
        output.printf("%-15s","Rank 1");
        output.printf("%-15s","Rank 2");
        output.printf("%-15s","Rank 3");
        output.printf("%-15s","Rank 4");
        output.printf("%-15s","Rank 5");
        output.printf("%-15s","Rank 1");
        output.printf("%-15s","Rank 2");
        output.printf("%-15s","Rank 3");
        output.printf("%-15s","Rank 4");
        output.printf("%-15s","Rank 5");
        for(int i=1;i<=10;i++){
            String year = "babynamesranking"+l+".txt";
            File fac = new File(year);
            if (fac.exists()==false){
                throw new IOException("This year is not included.");
            }
            Scanner sc = new Scanner(fac);
            
            
            
            String a = "";
            String b = "";
            String c = "";
            String d = "";
            String e = "";
            String f = "";
            String g = "";
            String h = "";
            String j = "";
            String k = "";
            
            ArrayList<String> all = new ArrayList<>();
        for(int cue = 0;cue<5;cue++){    
            sc.nextInt();
            all.add(sc.next());
            sc.nextInt();
            all.add(sc.next());
            sc.nextLine();
        }  
            a = all.get(0);
            b = all.get(1);
            c = all.get(2);
            d = all.get(3);
            e = all.get(4);
            f = all.get(5);
            g = all.get(6);
            h = all.get(7);
            j = all.get(8);
            k = all.get(9);
            
            output.println("");
            output.printf("%-15s",l);
            output.printf("%-15s",a);
            output.printf("%-15s",c);
            output.printf("%-15s",e);
            output.printf("%-15s",g);
            output.printf("%-15s",j);
            output.printf("%-15s",b);
            output.printf("%-15s",d);
            output.printf("%-15s",f);
            output.printf("%-15s",h);
            output.printf("%-15s",k);
            l++;
            
            sc.close();
        }
        
        output.close();
    }
    static void searchRanking() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nPlease enter a name: ");
        String x = in.next();
        System.out.print("\nPlease enter a year: ");
        String y = in.next();
        String year = "babynamesranking"+y+".txt";
        File f = new File(year);
        if(f.exists()==false){
            throw new IOException("The name "+x+" is not ranked");
        }
        Scanner i = new Scanner(f);
        int a = 1;
        while(i.hasNext()){
            if(i.nextLine().contains(x)){
                break;
            }
            a++;
        }
        System.out.println("The name "+x+" is ranked #"+a+" in the year "+y);
        i.close();
    }
    
}