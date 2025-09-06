/**
 * course: CSC210
 * project: Hw04
 * date: Feb. 14, 2023
 * author: Vladimir Murray
 * purpose: 
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Hw04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<StudentRecord> grades = new ArrayList<>();
        StudentRecord file = new StudentRecord();
        
        int x = 0;
        boolean q = true;
        while(q == true){
            System.out.println("Enter name: ");
            String n = in.next();
            System.out.println("Enter credit hours: ");
            int ch = in.nextInt();
            System.out.println("Enter quality points: ");
            int qh = in.nextInt();
            file = new StudentRecord(n,ch,qh);
            grades.add(file);
            
            x++;
            System.out.println("Would you like to continue? (true/false) ");
            q = in.nextBoolean();
        }
        Sort four= new Sort();
        StudentRecord[] arr = new StudentRecord[grades.size()];
        arr = grades.toArray(arr);
        four.sortGPA(arr, x);
        System.out.printf("%-10s","Item#");
        System.out.printf("%-15s", "Name");
        System.out.printf("%-15s","CreditHours");
        System.out.printf("%-15s","QualityPoints");
        System.out.printf("%-15s","GPA");
        
        for(int o = 0;o<x;o++){
            System.out.println("");
            System.out.printf("%-10s",o);
            System.out.printf("%-15s", arr[o].getName());
            System.out.printf("%-15s", arr[o].getEarnedCh());
            System.out.printf("%-15s",arr[o].getQualPts());
            System.out.printf("%-15s",arr[o].getGPA());
        }
        
        
        System.out.println("\nWhich GPA do you want to find?");
        double g = in.nextDouble();
        if(four.SearchGPA(arr, x, g)!=-1){
            int l = four.SearchGPA(arr, x, g);
            System.out.println("Found a record:\nName: "+arr[l].getName()+"   Credit Hours: "+arr[l].getEarnedCh()+"   Quality Points: "+arr[l].getQualPts()+"  GPA: "+arr[l].getGPA());
        }
        else {
            System.out.println("No matched record!");
        }
        
    }
}
class StudentRecord{
    private String name;
    private int EarnedCh;
    private int QualPts;
    private double GPA;
    
    public StudentRecord(){
        name = "";
        EarnedCh = 0;
        QualPts = 0;
        GPA = 0;
    }
    public StudentRecord(String nm, int Eh, int QPts){
        name = nm;
        EarnedCh = Eh;
        QualPts = QPts;
        GPA = (double)QPts/Eh;
    }
    public String getName(){
        return name;
    }
    public int getEarnedCh(){
        return EarnedCh;
    }
    public int getQualPts(){
        return QualPts;
    }
    public double getGPA(){
        return GPA;
    }
    public void setName(String nm){
        name = nm;
    }
    public void setEarnedCh(int Eh){
        EarnedCh = Eh;
    }
    public void setQualPts(int QPts){
        QualPts = QPts;
    }
}
interface SortInterface{
    
    
    void sortGPA(StudentRecord v[],int n);
}
class Sort implements SortInterface{
    @Override
    public void sortGPA(StudentRecord v[],int n){
        for(int i = 0;i<n;i++){
            StudentRecord currentmin = v[i];
            int currentminind = i;
            for(int j = i+1;j<n;j++){
                if(currentmin.getGPA()>v[j].getGPA()){
                    currentmin = v[j];
                    currentminind = j;
                }
            }
            if (currentminind!=i){
                v[currentminind] = v[i];
                v[i] = currentmin;
            }
        }
    }
    public int SearchGPA(StudentRecord v[], int n, double gpa){
        int low = 0;
        int high = n;
        while(high>=low){
            int mid= (low+high) / 2;
            if (gpa < v[mid].getGPA()) {
                high = mid-1;
            }
            else if (gpa == v[mid].getGPA()) {
                return mid;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}
