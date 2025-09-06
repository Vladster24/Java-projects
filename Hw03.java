/**
 * course: CSC 210
 * project: Hw03
 * date: Feb. 3, 2023
 * author: Vladimir Murray
 * purpose: To display a persons class, name, and status for the student.
 */
import java.util.Date;
public class Hw03 {

    public static void main(String[] args) {
        Date newDate= new Date();
        Person Per = new Person("Alex","a","a","all");
        Student study = new Student(3,"Baily","a","a","a");
        Employee eclipse = new Employee("Chesterfield",1000,newDate,"Charlie","a","a","a");
        Faculty fair = new Faculty("a",5,"a",1000,newDate,"David","a","a","a");
        Staff sir = new Staff("a","a",1000,newDate,"Ethan","a","a","a");
        System.out.println(Per.toString()+study.toString()+eclipse.toString()+fair.toString()+sir.toString());
    }
}
class Person {
    public String name;
    public String address;
    public String phone;
    public String email;
    public Person(){
        name = "";
        address = "";
        phone = "";
        email = "";
    }
    public Person(String n, String a, String p, String e){
        name = n;
        address = a;
        phone = p;
        email = e;
    }
    @Override
    public String toString(){
        return "Person: " + name;
    }
}
class Student extends Person{
    public int status=0;
    public String stat="";
    public Student(){
        super();
        status = 1;
    }
    public Student(int s, String n, String a, String p, String e){
        super(n,a,p,e);
        status = s;
        if(status == 1){
            stat = "Freshman";
        }
        else if(status == 2){
            stat = "Sophomore";
        }
        else if(status == 3){
            stat = "Junior";
        }
        else if(status == 4){
            stat = "Senior";
        }
    }
    @Override
    public String toString(){
        return "\nStudent: " +super.name+" ("+stat+")";
    }
}
class Employee extends Person{
    
    public String office;
    public int salary;
    public Date hired;
    public Employee(){
        super();
        office = "";
        salary = 0;
        hired = new Date();
    }
    public Employee(String o, int s, Date d, String n, String a, String p, String e){
        super(n,a,p,e);
        office = o;
        salary = s;
        hired = d;
    }
    @Override
    public String toString(){
        return "\nEmployee: "+super.name;
    }
}
class Faculty extends Employee{
    public String hours;
    public int rank;
    public Faculty(){
        super();
        hours = "";
        rank = 0;
    }
    public Faculty(String q, int r, String o, int s, Date d, String n, String a, String p, String e){
        super(o,s,d,n,a,p,e);
        hours = q;
        rank = r;
    }
    @Override
    public String toString(){
        return "\nFaculty: "+super.name;
    }
}
class Staff extends Employee{
    public String title;
    public Staff(){
        super();
        title = "";
    }
    public Staff(String t, String o, int s, Date d, String n, String a, String p, String e){
        super(o,s,d,n,a,p,e);
        title = t;
    }
    @Override
    public String toString(){
        return "\nStaff: "+super.name;
    }
}