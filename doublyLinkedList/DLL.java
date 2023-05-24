package doublyLinkedList;

public class DLL {
	
	Node head;
	class Node{
		int data;
		Node prev,next;
		
		public Node(int data)
		{
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public void addF(int data)
	{
		Node nd = new Node(data);
		
		if(head == null)
		{
			head = nd;
			return;
		}
		
		nd.next = head;
		head.prev = nd;
		head = nd;
	}
	
	public void addL(int data)
	{
		Node nd = new Node(data);
		if(head == null)
		{
			head = nd;
			return;
		}
		
		Node temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = nd;
		nd.prev = temp;
		
	}
	
	void addMiddle(Node target,int data)
	{
		// Checking the existence of prev node
		if(target == null)
		{
			System.out.println("Previous node can not be null");
			return;
		}
		Node new_data = new Node(data);
		new_data.next = target.next;
		new_data.next.prev = new_data;
		target.next = new_data;
		new_data.prev = target;
	}
	
	public void deleteL()
	{
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		
		Node temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp = temp.prev;
		temp.next = null;
	}
	
	public void deleteF()
	{
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		
		head = head.next;
		head.prev = null;
	}
	 
	public void deleteMiddle(Node target)
	{
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
		temp.next.prev = temp;
	}
	public void display()
	{
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" <-> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL d = new DLL();
		d.addF(32);
		d.addF(21);
		d.addF(11);
		d.addF(12);
		d.addL(90);
		d.addF(102);
		d.addL(900);
		d.addF(182);
		d.addL(901);
		d.addMiddle(d.head.next.next, 50);
		d.addL(90);
		d.display();
		d.deleteL();
		d.deleteMiddle(d.head.next.next.next);
		d.deleteF();
		d.display();

	}

}
