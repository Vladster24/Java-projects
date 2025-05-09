/**
 * course: CSC 210
 * project: Lab08
 * date: March 24, 2023
 * author: Vladimir Murray
 * purpose: To find the size of a file or directory in bytes using a
 * queue and stack
 */
import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Lab08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a directory or a file: ");
        String direct = in.nextLine();
        System.out.println("Size according to queue: "+getSize_Queue(new File(direct))+" bytes");
        System.out.println("Size according to stack: "+getSize_Stack(new File(direct))+" bytes");
    }
    public static long getSize_Queue(File directory){
        long size = 0;
        Queue<File> queue1 = new LinkedList<>();
        queue1.add(directory);
        while(!queue1.isEmpty()){
            File t = queue1.remove();
            if(t.isFile())
                size+=t.length();
            else{
                File[] files = t.listFiles();
                if(files != null){
                    for(File file :files) {
                        queue1.add(file);
                    }
                }
            }
        }
        return size;
    }
    public static long getSize_Stack(File directory){
        long size = 0;
        Stack<File> s = new Stack<>();
        s.push(directory);
        while(!s.empty()){
            File t = s.pop();
            if(t.isFile())
                size+=t.length();
            else{
                File[] files = t.listFiles();
                if(files != null){
                    for(File file: files){
                        s.push(file);
                    }
                }
            }
        }
        return size;
    }
}
