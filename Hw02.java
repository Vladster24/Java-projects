/**
 * Course: CSC210
 * Project: Hw02
 * date: Jan. 28, 2023
 * author: Vladimir Murray
 * purpose: To measure the time it takes for bubble, insertion,
 * and selection sorting methods to finish sorting an array.
 */

import java.util.Random;
public class Hw02 {

    public static void main(String[] args) {
        int[] list1 = new int[100000];
        int[] list2 = new int[100000];
        int[] list3 = new int[100000];
        Random random1 = new Random();
        for(int i=0;i<100000;i++){
            list1[i] = random1.nextInt(100000);
        }
        for(int i=0;i<100000;i++){
            list2[i] = random1.nextInt(100000);
        }
        for(int i=0;i<100000;i++){
            list3[i] = random1.nextInt(100000);
        }
        
        StopWatch sort = new StopWatch();
        StopWatch sort1 = new StopWatch();
        StopWatch sort2 = new StopWatch();
        sort.start();
        for(int b=1;b<list1.length;b++){
            for(int a=0;a<list1.length-b;a++){
                if (list1[a]>list1[a+1]){
                    int k = list1[a];
                    list1[a] = list1[a+1];
                    list1[a+1] = k;
                }
            }
        }
        sort.stop();
        System.out.println("Time for bubble sort is "+sort.getElapsedTime());
        
        sort1.start();
        for(int i = 0;i<list2.length;i++){
            int currentMin = list2[i];
            int currentMinIndex = i;
            for (int internet = i+1;internet<list2.length;internet++){
                if (currentMin > list2[internet]) {
                    currentMin = list2[internet];
                    currentMinIndex = internet;
                }
            }
            if (currentMinIndex != i){
                list2[currentMinIndex] = list2[i];
                list2[i] = currentMin;
            }
        }
        sort1.stop();
        System.out.println("Time for selection sort is "+sort1.getElapsedTime());

        sort2.start();
        for(int a = 1;a<list3.length;a++){
            int c = list3[a];
            int k;
            for (k = a-1;k>=0 && list3[k] > c;k--){
                list3[k+1] = list3[k];
            }
            list3[k+1] = c;
        }
        sort2.stop();
        System.out.println("Time for insertion sort is "+sort2.getElapsedTime());
    }
}
class StopWatch{
    private long startTime;
    private long endTime;
    java.util.Date date = new java.util.Date();
    java.util.Date end = new java.util.Date();
    public long getstartTime(){
        return startTime;
    }
    public long getendTime(){
        return endTime;
    }
    StopWatch(){
        startTime = 0;
        endTime = 0;
    }
    public void start(){
        date = new java.util.Date();
        startTime = date.getTime();
    }
    public void stop(){
        end = new java.util.Date();
        endTime = end.getTime();
    }
    public long getElapsedTime(){
        return (getendTime() - getstartTime());
    }
}
