/**
 * course: CSC 210
 * project: Lab09
 * date: March 31, 2023
 * author: Vladimir Murray
 * purpose: To find which letters occur most in a sentence.
 */
import java.util.*;
public class Lab09 {
    public static void main(String[] args) {
        Map<Character,Integer> h = new HashMap<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String s = in.nextLine();
        s = s.toLowerCase();
        for(int i = 0;i<s.length();i++){
            char d = s.charAt(i);
            if(d<='z' && d>='a'){
                int a=0;
                if(h.get(d)==null)
                    a = 0;
                else
                    a = h.get(d);
                h.put(d, a+1);
            }
        }
        int quantity = 0;
        String ea = "";
        for(int k = 0;k<s.length();k++){
        if(s.charAt(k)<='z' && s.charAt(k)>='a'){
            
            if(h.get(s.charAt(k)) > quantity){
                ea = s.substring(k,k+1);
                quantity = h.get(s.charAt(k));
            }
            else if(h.get(s.charAt(k)) == quantity){
                
                if(ea.contains(s.substring(k, k+1)) == false)
                    ea += " "+s.substring(k,k+1);
            }
        }
        }
        System.out.println("The following letter(s) occurred most["+quantity+" time(s)]:\n"+ea);
    }
}
