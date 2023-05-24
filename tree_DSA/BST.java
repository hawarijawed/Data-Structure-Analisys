package tree_DSA;
import java.util.*;
public class BST {

	public static class Node{
		int data;
		Node left,right;
		public Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static Node insert(Node root,int key)
	{
		// Base case
		if(root == null)
		{
			root = new Node(key);
			return root;
		}
		
		if(root.data > key)
		{
			root.left = insert(root.left,key);
		}
		else
		{
			root.right = insert(root.right,key);
		}
		return root;
	}
	//---------------- SEARCH IN BST -----------------------//
	public static boolean search(Node root,int key)// O(H), H = height of bst
	{
		if(root == null)
		{
			return false;
		}
		if(root.data == key)
		{
			return true;
		}
		
		if(root.data > key)
		{
			return search(root.left,key);
		}
		else if (root.data < key)
		{
			return search(root.right,key);
		}
		else
			return false;
		
	}
	//--------------- DELETE A NODE IN BST ----------------//
	public static Node delete(Node root,int key)// deletes only those nodes which are there in BST
	{
		if(root.data>key)
		{
			root.left = delete(root.left,key);
		}
		
		else if(root.data < key)
		{
			root.right = delete(root.right,key);
		}
		
		else
		{
			// case-1 -> Leaf node
			if(root.left == null && root.right == null)
			{
				return null;
			}
			
			// case-2 -> One child node
			if(root.right == null)
			{
				return root.left;
			}
			else if(root.left == null)
			{
				return root.right;
			}
			
			// case-3 -> two children nodes
			else
			{
				Node IS = inOrderSuccessor(root.right);
				root.data = IS.data;
				root.right = delete(root.right,IS.data);
			}
			
		}
		return root;
	}
	
	// --- INORDER SUCCESSOR---//
	public static Node inOrderSuccessor(Node root)
	{
		while(root.left != null)
		{
			root = root.left;
		}
		return root;
	}
	//--------------- PRINT IN RANGE ---------------------//
	public static void printInRange(Node root, int k1, int k2)
	{
		// base case
		if(root ==  null)
		{
			return;
		}
		
		//case 1
		if(root.data>=k1 && root.data<=k2)
		{
			printInRange(root.left,k1,k2);
			System.out.print(root.data+" ");
			printInRange(root.right,k1,k2);
		}
		// case 2
		else if(root.data<k1)
		{
			printInRange(root.left,k1,k2);
		}
		//case 3
		else
			printInRange(root.right,k1,k2);
	}
	//--------------- IN-ORDER TRAVERSAL ------------------//
	public static void inOrder(Node root)
	{
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+"->");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		
		int values[] = {8,5,10,3,6,11,1,4,14};
		Node root = null;
		for(int i =0;i<values.length;i++)
		{
			root = insert(root,values[i]);
		}
		System.out.println("Initial BST");
		inOrder(root);
		System.out.println("null");
		//System.out.println("BST search of 6: "+search(root,6));
//		System.out.println("Deleting element 8");
//		root = delete(root,8);
//		inOrder(root);
		System.out.println("printint nodes in range 4 - 11");
		printInRange(root,5,12);
		
	}

}
