/**
 * course: CSC189
 * project: Hw 8
 * date: 10/27/19
 * author: Vladimir Murray
 * purpose: prints out the words onto different lines without the special characters or spaces.
 */
package hw8;

class MyQuote {
    String s="";
    
    void setMyQuote(String str) {//changes the quote
        s = str;
    }
    
    void split(String s){
        String a = s.toLowerCase(); //the entire string is lowercased while the original is still intact.
        String b="";
        
        for(int i=0;i<s.length();i++) { //removes the special characters like !, ?, %, etc.
            if((a.charAt(i)>='a' && a.charAt(i)<='z') || a.charAt(i)==' ')      
            b = b + s.charAt(i);
        }
        
        String w="";
        
        for(int r=0;r<b.length();r++){ //seperates the words onto different lines
            
            if(b.charAt(r)==' ') {
                System.out.println(w);
                w = "";
            }
            else {
                w += b.charAt(r);
            }
            if(r==b.length()-1)
                System.out.println(w);
        }
        
    }
    
}
public class Hw8 {

    public static void main(String[] args) {
        // TODO code application logic here
        MyQuote myQt = new MyQuote();
        myQt.split("Never give up. Today is hard, tomorrow will be worse, but the day after tomorrow will be sunshine!");
        myQt.split("dlfhhl! @dfkjdsdg$ idds&");
        
    }
    
}
