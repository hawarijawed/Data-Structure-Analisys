package QUEUE;

public class DoubleEndedQueue {

	private int maxSize;
	private int[] deque;
	private int front;
	private int rear;
	private int nItems;
	 
	public DoubleEndedQueue(int s) {
	    maxSize = s;
	    deque = new int[maxSize];
	    front = 0;
	    rear = -1;
	    nItems = 0;
	}
	 
	public void insertFront(int j) {
	    if (isFull()) {
	        System.out.println("Queue is full");
	    } else {
	        if (front == 0) {
	            front = maxSize;
	        }
	        deque[--front] = j;
	        nItems++;
	    }
	}
	 
	public void insertRear(int j) {
	    if (isFull()) {
	        System.out.println("Queue is full");
	    } 
	    else {
	        if (rear == maxSize-1) 
	        {
	            rear = -1;
	        }
	        deque[++rear] = j;
	        nItems++;
	    }
	}
	 
	public int removeFront() {
	    if (isEmpty()) 
	    {
	        System.out.println("Queue is empty");
	        return -1;
	    } else {
	        int temp = deque[front++];
	        if (front == maxSize) {
	            front = 0;
	        }
	        nItems--;
	        return temp;
	    } 
	}
	 
	public int removeRear() {
	    if (isEmpty()) {
	        System.out.println("Queue is empty");
	        return -1;
	    } else {
	        int temp = deque[rear--];
	        if (rear == -1) {
	            rear = maxSize-1;
	        }   
	        nItems--;
	        return temp;
	    }
	}
	 
	public int peekFront() {
	    if (isEmpty()) {
	        System.out.println("Queue is empty");
	        return -1;
	    } else {
	        return deque[front];
	    }
	}
	 
	public int peekRear() {
	    if (isEmpty()) {
	        System.out.println("Queue is empty");
	        return -1;
	    } else {
	        return deque[rear];
	    }
	}
	 
	public boolean isEmpty() {
	    return (nItems == 0);
	}
	 
	public boolean isFull() {
	    return (nItems == maxSize);
	}
	 
	public void display() {
	    if (isEmpty()) {
	        System.out.println("Queue is empty");
	    } else {
	        if (rear >= front) {
	            for (int i=front; i<=rear; i++) {
	                System.out.print(deque[i] + " ");
	            }
	        } else {
	            for (int i=front; i<maxSize; i++) {
	                System.out.print(deque[i] + " ");
	            }
	            for (int i=0; i<=rear; i++) {
	                System.out.print(deque[i] + " ");
	            }
	        }
	        System.out.println();
	    }
	}
	 
	public static void main(String[] args) {
	    DoubleEndedQueue q = new DoubleEndedQueue(5);
	    q.insertFront(1);
	    q.insertRear(2);
	    q.insertFront(3);
	    q.insertRear(4);
	    q.insertFront(5);
	    q.display();
	 
	    q.removeFront();
	    q.removeRear();
	    q.display();
	 
	    q.insertFront(6);
	    q.insertRear(7);
	    q.display();
	 
	    q.insertFront(8);
	    q.insertRear(9);
	 
	    System.out.println(q.removeRear());
	    System.out.println(q.removeFront());
	    System.out.println(q.peekFront());
	    System.out.println(q.peekRear());
	 
	    q.display();
	}
}
