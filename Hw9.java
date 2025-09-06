/**
 * course: CSC 189
 * project: Hw 9
 * date: 11/1/19
 * author: Vladimir Murray
 * purpose: This program takes the most frequent word in the string and prints it out
 */
package hw9;

class MyString {
    String s = "";
    void setMyString(String str) {
        s = str;
    }
    String getMyString() {return s;}
    
    String getMode(String s) {
        
        String b="";
        
        for(int l=0;l<s.length();l++) {
            if((s.charAt(l)>='a' && s.charAt(l)<='z') || (s.charAt(l)>='A' && s.charAt(l)<='Z') || s.charAt(l)==' ')      
            b = b + s.charAt(l);
        }
        
        s = b;
        String maxWd = "";
        int maxCnt = 0;
    
        for(int i=0;i<s.length();i++){
            int cnt=0;
            String w;
            
            if (s.indexOf(" ",i)!=-1)
                w = s.substring(i,s.indexOf(" ",i));
            else
                w = s.substring(i,s.length());
            
            for(int j=i;j<s.length();j++){
                if(s.indexOf(" ",j)<0) {
                    if(w.equalsIgnoreCase(s.substring(j,s.length())))
                        cnt++;
                }
                else
                    {
                    if(w.equalsIgnoreCase(s.substring(j,s.indexOf(" ",j))))
                        cnt++;
                    }
            }
            if(cnt>maxCnt) {
                maxCnt = cnt;
                maxWd = w;
            }
            if(s.indexOf(" ",i)!=-1)
                i = s.indexOf(" ",i);
        }
        
        return maxWd;
    }
    
    
}
public class Hw9 {

    public static void main(String[] args) {
        // TODO code application logic here
        MyString ms = new MyString();
        System.out.println(ms.getMode("You are braver than you believe, and stronger than you seem, and smarter than you think."));
    }
    
}
