/******************************************************************************

                            Priority Queue Implementation

*******************************************************************************/
import java.util.*;
class Student implements Comparable<Student>{
    String name;
    int marks;
    Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }
    
    //PQ uses this method to compare two objects internally
    @Override
    public boolean equals(Object obj){
        //first verify obj is instance of Student or not 
        if(obj instanceof Student){
            //Perform typecasting
            Student that = (Student) obj;
            if(this.marks == that.marks && (this.name.compareTo(that.name)==0)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "Name: "+this.name+", Marks: "+this.marks;
    }
    @Override
    public int compareTo(Student that){
        //For case: there are two students with same marks and you want to print the 
        //student name lexicographical order then 
        if(this.marks == that.marks){
            return this.name.compareTo(that.name);
        }
        //Ascending order
        return this.marks - that.marks;
        //Descending order
        //return that.marks - this.marks;
    }
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		//By default smallest elements were given Highest Priority
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        //reverseOrder() is used to give highest priority to largest elements
//         PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
// 		queue.offer(1);
// 		queue.offer(10);
// 		queue.offer(2);
// 		queue.offer(4);
// 		queue.offer(71);
// 		queue.offer(90);
// 		System.out.println("Highest Priority element        : "+queue.peek());//get the Highest element
// 		System.out.println("Does 45 exists in queue         : "+queue.contains(45));//to check existence of element
// 		System.out.println("Deleting the Highest element    : "+queue.poll());//delete Highest element
// 		System.out.println("next Highest Priority element   : "+queue.peek());

        //Implemening a student class in Priority queue
        PriorityQueue<Student> minStudent = new PriorityQueue<>();
        minStudent.offer(new Student("Jawed", 99));
        minStudent.offer(new Student("NuiBin", 11));
        minStudent.offer(new Student("Zujeeet", 66));
        minStudent.offer(new Student("Call me Sanju", 1000));
        System.out.println(minStudent.peek());
        //check the existence of an Object
        System.out.println(minStudent.contains(new Student("Tony", 80)));
        System.out.println(minStudent.contains(new Student("Jawed", 99)));
		
	}
}
