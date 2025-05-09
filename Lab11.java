/**
 * course: CSC 210
 * project: Lab 11
 * date: April 24, 2023
 * author: Vladimir Murray
 * purpose: To use a merge sort to sort a random list from low to high values.
 */
import java.util.*;
public class Lab11 {
    public static void mergeSort(int[] list,int lower,int upper) {
    if (upper>lower) {
        
      int mid = (lower + upper) / 2;
      mergeSort(list, lower, mid);
      mergeSort(list, mid+1, upper);
      merge(list, lower, upper);
    }
  }
  public static void merge(int[] list, int lower, int upper) {
      int l = upper-lower+1;
      int temp[]= new int [l];
      System.arraycopy(list, lower, temp, 0, l);
      int w = 0;
      for(int q = 0; q < l-1; q++){
          
          int s = temp[q];
          int sindex = q;
          
          for(int e = q+1;e < l;e++){
              if (temp[e] < s){
                  s = temp[e];
                  sindex = e;
              }
          }
          
          if(sindex != q){
              temp[sindex] = temp[q];
              temp[q] = s;
          }
      }
      int r = 0;
      for(int i = lower; i < l; i++){
          list[i] = temp[r++];
      }
  }

  public static void main(String[] args) {
    int[] list = new int [10];
    Random r = new Random();
    for(int i = 0;i<list.length;i++)
        list[i] = r.nextInt(100);
    
    mergeSort(list,0,list.length-1);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
}