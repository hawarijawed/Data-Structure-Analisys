package circularLinkedList;

public class CLL {
	Node head;
	class Node
	{
		int data;
		Node next;
		public Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	public void insertL(int data)
	{
		Node nd = new Node(data);
		//System.out.println("Hellpl");
		// If it is first node then
		if(head == null)
		{
			head = nd;
			nd.next  = head;
			return;
		}
		// Insertion from last;
		
		Node temp = head.next;
		//Traversing temp node to last node.
		while(temp.next != head)
		{
			temp = temp.next;
		}
		temp.next = nd;
		nd.next = head;
	}
	//
	public void insertF(int data)
	{
		Node nd = new Node(data);
		// If it is first node then
		if(head == null)
		{
			head = nd;
			nd.next  = head;
			return;
		}
		Node temp = head;
		while(temp.next != head)
		{
			temp = temp.next;
		}
		temp.next = nd;
		nd.next = head;
		head = nd;
	}
	//
	void insertM(Node prev,int data)
	{
		// Checking the existence of prev node
		if(prev == null)
		{
			System.out.println("Previous node can not be null");
			return;
		}
		Node new_data = new Node(data);
		new_data.next = prev.next;
		prev.next = new_data;
	}
	
	public void deleteL()
	{
		//Empty list
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		if(head.next == head)
		{
			head = null;
			return;
		}
		Node temp = head.next;
		Node prev = head;
		while(temp.next != head)
		{
			prev = temp;
			temp = temp.next;

		}
		prev.next = head;		
	}
	
	public void deleteF()
	{
		//Empty list
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		// If there is only one elements
		if(head.next == head)
		{
			head = null;
			return;
		}
		Node temp = head;
		while(temp.next != head)
		{
			temp = temp.next;
		}
	    head = head.next;
		temp.next = head;
		//head = mj;
	}
	
	public void deleteM(Node target)
	{
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		if(target == null)
		{
			System.out.println("Target node can not be null");
			return;
		}
		
		Node temp = head;
		while(temp.next != target)
		{
			temp = temp.next;
		}
		temp.next = target.next;
	}
	
	public void search(int data)
	{
		Node temp = head;
		while(temp != null)
		{
			if(temp.data == data)
			{
				System.out.println("element found");
				return;
			}
			temp = temp.next;
		}
	}
	
	public void display()
	{
		//For empty list
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		
		Node temp = head;
		do {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}while(temp != head);
		System.out.println("head");
	}
	public static void main(String[] args)
	{
		//System.out.println("Hellp");
		CLL c = new CLL();
		c.insertF(5);
		c.insertL(45);
		c.insertL(78);
		c.insertL(34);
		c.insertF(12);
		c.display();
		c.deleteF();
		c.deleteM(c.head.next.next);
//		c.deleteF();
//		c.deleteF();
//		c.deleteF();
//		c.deleteF();
		c.display();
		
	}

}
