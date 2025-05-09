/**
 * course: CSC 210
 * project: Hw10
 * date: April 29, 2023
 * author: Vladimir Murray
 * purpose: To find out how long it takes for each sorting method to
 * sort out each list at different array sizes.
 */
import java.util.*;
public class Hw10 {

    public static void main(String[] args) {
        
        
        System.out.printf("%-15s","Array size");
        System.out.printf("%-15s","Selection sort");
        System.out.printf("%-15s","Merge sort");
        System.out.printf("%-15s","Quick sort");
        System.out.printf("%-15s","Heap sort");
        System.out.printf("%-15s","Radix sort");
        System.out.println("");
        
        for(int i = 1;i<=10;i++){
            int x = i*10000;
            int[] list = new int[x];
            for(int o = 0;o<list.length;o++){
                list[o] = (int)(Math.random()*100000);
            }
            
            System.out.printf("%-15s",x);
            
            
            int[] l = new int[x];
            System.arraycopy(list,0,l,0,x);
            long start = System.currentTimeMillis();
            selectionSort(l);
            long stop = System.currentTimeMillis();
            long elapsed = stop - start;
            System.out.printf("%-15s",elapsed);
            
            
            l = new int[x];
            System.arraycopy(list,0,l,0,x);
            start = System.currentTimeMillis();
            mergeSort(l,0,l.length-1);
            stop = System.currentTimeMillis();
            elapsed = stop - start;
            System.out.printf("%-15s",elapsed);
            
            
            l = new int[x];
            System.arraycopy(list,0,l,0,x);
            start = System.currentTimeMillis();
            quickSort(l);
            stop = System.currentTimeMillis();
            elapsed = stop - start;
            System.out.printf("%-15s",elapsed);
            
            
            l = new int[x];
            System.arraycopy(list,0,l,0,x);
            start = System.currentTimeMillis();
            heapSort(l);
            stop = System.currentTimeMillis();
            elapsed = stop - start;
            System.out.printf("%-15s",elapsed);
            
            
            l = new int[x];
            System.arraycopy(list,0,l,0,x);
            start = System.currentTimeMillis();
            radixSort(l,100000);
            stop = System.currentTimeMillis();
            elapsed = stop - start;
            System.out.printf("%-15s",elapsed);
            System.out.println("");
        }
    }
    
    
    static void radixSort(int[] list, int o) {
        for (int or = 1; or < o; or *= 10) {
            //@SuppressWarnings("unchecked")
            ArrayList<Integer>[] bucket = new ArrayList[10];
   
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new java.util.ArrayList<>();
            }
   
            for (int i = 0; i < list.length; i++) {
                bucket[(list[i] / or) % 10].add(list[i]);
            }
            int k = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != null) {
                    for (int j = 0; j < bucket[i].size(); j++)
                    list[k++] = bucket[i].get(j);
                }
            }
        }
    }
    
    public static void heapSort(int[] list) {
        
        Heap<Integer> heap = new Heap<Integer>();

        for (int i = 0; i < list.length; i++)
        heap.add(list[i]);

        for (int i = list.length - 1; i >= 0; i--){
            list[i] = heap.remove();
        }
    }
    static class Heap<E extends Comparable<E>> {
        private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

        public Heap() {
        }

        public Heap(E[] objects) {
            for (int i = 0; i < objects.length; i++)
            add(objects[i]);
        }

        public void add(E newObject) {
            list.add(newObject); 
            int currentIndex = list.size() - 1;

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                } 
                else{
                    break;
                }
                currentIndex = parentIndex;
            }
        }

        public E remove() {
            if (list.size() == 0)
                return null;

            E removedObject = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentIndex = 0;
            while (currentIndex < list.size()) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                if (leftChildIndex >= list.size()){
                    break;
                }
                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                        maxIndex = rightChildIndex;
                    }
                }

                if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                    E temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex, temp);
                    currentIndex = maxIndex;
                }
                else{
                    break; 
                }
            }

            return removedObject;
        }
        public int getSize() {
            return list.size();
        }
    }
    
    
    
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                currentMin = list[j];
                currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
    
    
    
    
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
    
    
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }
    
    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first]; 
        int low = first + 1; 
        int high = last;

        while (high > low) {
   
            while (low <= high && list[low] <= pivot)
                low++;

            while (low <= high && list[high] > pivot)
                high--;

            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } 
        else {
            return first;
        }
    }
    
    
}
