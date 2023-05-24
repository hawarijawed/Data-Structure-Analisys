package QUEUE;
import java.util.*;
public class queue {
    int size = 10;
    int rear = -1;
    int front = -1;
    int[] arr = new int[size];
    public boolean isFull()
    {
    	if(rear == size-1)
    		return true;
    	if(front>rear)
    		return true;
    	return false;
    }
    public boolean isEmpty()
    {
    	if(front == -1)
    		return true;
    	return false;
    }
    public void enqueue(int a)
    {
    	if(isFull())
    	{	System.out.println("Queue is full");
    	    return;
    	}
    	if(front == -1)
    	{
    		front++;
    	}
    	rear = rear+1;
    	
    	arr[rear] = a;
    	System.out.println("****Element inserted******");
    }
    public int dequeue()
    {
    	if(isEmpty()) {
    		System.out.println("!!!!!Queue is in underflow!!!!!");
    		return -1;
    	}
    	
    	int a = arr[front];
    	front = front+1;
    	return a;
    }
    public void Print()
    {
    	System.out.println("Printing the elements of the queue");
    	for(int i = front;i<= rear;i++)
    	{
    		System.out.print(" "+arr[i]);
    	}
    	System.out.println("");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		queue Q = new queue();
		Q.enqueue(5);
		Q.enqueue(6);
		Q.enqueue(89);
		Q.enqueue(69);
		Q.enqueue(90);
		Q.Print();
		System.out.println("Popped element: "+Q.dequeue());
		System.out.println("Popped element: "+Q.dequeue());
		System.out.println("Popped element: "+Q.dequeue());
		Q.Print();
		

	}

}
