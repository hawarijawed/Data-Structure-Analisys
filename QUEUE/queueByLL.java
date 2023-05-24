package QUEUE;

public class queueByLL {
	public static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	public static class Queue
	{
		static Node head = null;
		static Node tail = null;
		
		public static boolean isEmpty()
		{
			return head == null && tail == null;
		}
		
		public static void add(int data)
		{
			Node new_node = new Node(data);
			if(head == null)
			{
				head = tail = new_node;
				return;
			}
			tail.next = new_node;
			tail = new_node;
					
		}
		
		public static int remove()
		{
			if(head == null)
			{
				return -1;
			}
			int front = head.data;
			
			if(head == tail)
			{
				head = tail = null;
			}
			else
				head = head.next;
			return front;
		}
		public static int peek()
		{
			if(head == null)
			{
				return -1;
			}
			int front = head.data;
			
			return front;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.add(7);
		Queue.add(6);
		q.add(5);
		q.add(4);
		while(!q.isEmpty())
		{
			System.out.println(q.remove());
		}
		

	}

}
