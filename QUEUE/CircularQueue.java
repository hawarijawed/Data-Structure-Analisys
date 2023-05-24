package QUEUE;
import java.util.*;
public class CircularQueue {
	 int size = 10;
	    int rear = -1;
	    int front = -1;
	    int[] arr = new int[size];
	    public boolean isFull()
	    {
	    	if((rear+1)%size == front)
	    	{
	    		return true;
	    	}
	    	return false;
	    }
	    public boolean isEmpty()
	    {
	    	if(rear == front)
	    	{
	    		return true;
	    	}
	    	return false;
	    }
	    void enqueue(int a)
	    {
	    	if(isFull())
	    	{
	    		System.out.println("!!! QUEUE OVERFLOW !!!");
	    	}
	    	if(front == -1)
	    	{
	    		front = (front+1)%size;
	    	}
	    	rear = (rear+1)%size;
	    	arr[rear] = a;
	    }
	    int dequeue()
	    {
	    	if(isEmpty())
	    	{
	    	   System.out.println("!!! QUEUE UNDERFLOW !!!");
	    	   return -1;
	    	}
	    	int a = arr[front];
	    	front = (front+1)%size;
	    	return a;
	    }
	    void Printlist()
	    {
	    	System.out.println("Printing the elements of the circular queue");
	    	for(int i = front; i<=rear;i++)
	    	{
	    		System.out.println(" "+arr[i]);
	    	}
	    	System.out.println("");
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue Q = new CircularQueue();
		Q.enqueue(5);
		Q.enqueue(23);
		Q.enqueue(53);
		Q.enqueue(51);
		Q.enqueue(21);
		Q.Printlist();	
		System.out.println("Popped element: "+Q.dequeue());
		System.out.println("Popped element: "+Q.dequeue());
		System.out.println("Popped element: "+Q.dequeue());
		Q.Printlist();	
		
	}

}
