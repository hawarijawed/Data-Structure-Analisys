package tree_DSA;

public class b_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node b = new Node(10);
		b.insertion(12);
		b.insertion(8);
		b.insertion(15);
		b.insertion(13);
		b.insertion(21);
		
		b.Print();
//		System.out.println(b.Present(20));
//		
//		System.out.println(b.Present(12));
		b.preOrder(b);
		System.out.println("****************");
		b.inOrder(b);

	}

}
class Node
{
	Node left,right;
	int data;
	// Constructor
	public Node(int data)
	{
		this.data = data;
		this.left  = null;
		this.right = null;
	}
	
	// Element insertion
	public void insertion(int value)
	{
		if(value <= data)
		{
			if(left == null)
			{
				left = new Node(value);
			}
			else
				left.insertion(value);
		}
		else
			if(value >= data)
			{
				if(right == null)
				{
					right = new Node(value);
				}
				else
					right.insertion(value);
			}
	}
	
	// Checking presence of element in tree
	public boolean Present(int value)
	{
		if(value == data)
		{
			return true;
		}
		else if(value < data)
		{
			if(left == null)
			{
				return false;
			}
			else 
				return left.Present(value);
		}
		else
			if(right == null)
			{
				return false;
			}
			else 
				return right.Present(value);
	}
	
	// Printing the elements of the tree
	public void Print()
	{
		if(left != null)
		{
			left.Print();
		}
		System.out.print("->"+data);
		if(right != null)
		{
			right.Print();
		}	
	}
	public void preOrder(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.println(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(Node root)
	{
		if(root == null)
		{
			return;
		}
		preOrder(root.left);
		System.out.println(root.data+" ");
		
		preOrder(root.right);
	}
}