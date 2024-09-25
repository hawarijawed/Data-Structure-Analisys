/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Student implements Comparable<Student>{
    String name;
    int roll;
    int marks;
    Student(String name, int roll, int marks){
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }
    @Override
    public String toString(){
        //System.out.println("Name: "+name+" Roll: "+roll+" Marks: "+marks);
        return "Name: "+name+" Roll: "+roll+" Marks: "+marks;
    }
    
    @Override
    public int compareTo(Student that){
        //Obj1 refers as this, obj2 referes as that 
        int m1 = this.marks;
        int m2 = that.marks;
        
        if(m1 == m2){
            return this.roll - that.roll;
        }
        
        return m1-m2;
    }
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
// 		ArrayList<Integer> arr = new ArrayList<>();
// 		arr.add(10);
// 		arr.add(23);
// 		arr.add(41);
// 		arr.add(55);
// 		arr.add(87);
// 		arr.add(3400);
// 		arr.add(89);

        //ArrayList of Student
        ArrayList<Student> std = new ArrayList<>();
	    std.add(new Student("Priyanshu",165, 500));
	    std.add(new Student("Nui Bin",129, 890));
	    std.add(new Student("Choobodh",199, 880));
	    std.add(new Student("Jawed",73, 990));
	    std.add(new Student("Alok",23, 1001));
	    std.add(new Student("Call Me Sanju",212, 660));
	    std.add(new Student("Zujeeeth",124, 789));
		
		Main c1 = new Main();
		//New Comparator for Student class 
		Comparator<Student> cmp = new Comparator<Student>(){
		    public int compare(Student st1, Student st2){
		        //Extract marks from objects
		        int m1  = st1.marks;
		        int m2  = st2.marks;
		        if(m1 == m2){
		            return st1.roll - st2.roll;
		        }
		        return m1-m2;
		    }
		};
		System.out.println("Before sorting");
		c1.display(std);
        //After implemting Comparator in class, there is no need to write
        //Comparator function separately
		//Collections.sort(std, cmp);
		Collections.sort(std);
		System.out.println("After sorting");
		c1.display(std);
// 		Comparator<Integer> cmp = new Comparator<Integer>(){
// 		    public int compare(Integer obj1, Integer obj2){
// 		        //if 1 then swap 
// 		        //if 0 or -1 then dont swap
// 		        int u1 = obj1%10;
// 		        int u2 = obj2%10;
// 		        if(u1 == u2){
// 		            return obj1-obj2;//sort the list based on unit digit from lower number to higher number 
		            
// 		        }
// 		        return u1-u2;
// 		      //  if(u1<u2){
// 		      //      //Dont swap
// 		      //      return -1;
// 		      //  }
// 		      //  else if(u1 > u2){
// 		      //      //Swap 
// 		      //      return 1;
// 		      //  }
// 		      //  else{
// 		      //      //when both are equal
// 		      //      if(obj1<obj2){
// 		      //          //Dont swap
// 		      //          return -1;
// 		      //      }
// 		      //      else if(obj1 > obj2){
// 		      //          //Swap 
// 		      //          return 1;
// 		      //      }
// 		      //  }
// 		      //  return 0;
// 		    }
// 		};
// 		System.out.println("Before sorting");
// 		c1.display(arr);
// 		Collections.sort(arr, cmp);
// 		System.out.println("After sorting");
// 		c1.display(arr);
	}
	
	public <T> void display(ArrayList<T> lst){
	    for(int i=0; i<lst.size(); i++){
	        System.out.println(lst.get(i)+" ");
	    }
	    System.out.println();
	}
}
