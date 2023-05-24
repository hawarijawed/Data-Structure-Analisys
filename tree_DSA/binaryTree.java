package tree_DSA;
import java.util.*;
public class binaryTree {
	static class Node{
		int data;
		Node left,right;
		Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BinaryTree{
		static int idx = -1;
		public Node buildTree(int nodes[])
		{
			idx++;
			if(nodes[idx] == -1)
			{
				return null;
			}
			
			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			return newNode;
		}
		// Preorder traversal: root->left->right
		public void preOrder(Node root)
		{
			if(root == null)
			{
				//System.out.print("-1 ");
				return;
			}
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
			
		}
		public void inOrder(Node root)
		{
			if(root == null)
			{
				
				return;
			}
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
		public void postorder(Node root)
		{
			if(root == null)
			{
				return;
			}
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
			
		}
		
		//---------- LEVEL ORDER ------------//
		public void levelOrder(Node root)
		{
			if(root == null)
			{
				return;
			}
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			while(!q.isEmpty())
			{
				Node curr = q.remove();
				if(curr == null)
				{
					System.out.println();
					// checking if queue is empty or not
					if(q.isEmpty())
					{
						// come out of the loop
						break;
					}
					else
					{
						// add another null value to queue
						q.add(null);
					}
				}
				else
				{
					System.out.print(curr.data+" ");
					if(curr.left != null)
					{
						q.add(curr.left);
					}
					if(curr.right != null)
					{
						q.add(curr.right);
					}
				}
					
			}
		}
		
		public int height(Node root)
		{
			if(root == null)
			{
				return 0;
			}
			
			int lh = height(root.left);
			int rh = height(root.right);
			
			int H = Math.max(lh, rh)+1;
			return H;
		}
		// ----------- NODES COUNT----------------//
		public int countNodes(Node root)
		{
			if(root == null)
			{
				return 0;
			}
			
			int left_count = countNodes(root.left);
			int right_count = countNodes(root.right);
			int total = left_count+right_count+1;
			return total;
		}
		
		//------------- SUM OF NODES --------------------//
		public int sumCount(Node root)
		{
			if(root == null)
			{
				return 0;
			}
			
			int l_sum = sumCount(root.left);
			int r_sum = sumCount(root.right);
			return l_sum + r_sum + root.data;
		}
		
		//------------- DIAMETER OF BINARY TREE --------------------//	
		//---------------------APPROACH 1 -----------------//
		public int diameter(Node root)
		{
			if(root == null)
			{
				return 0;
			}
			
			int ldim = diameter(root.left);
			int rdim = diameter(root.right);
			
			int lh = height(root.left);
			int rh = height(root.right);
			int self_dim = lh+rh+1;
			return Math.max(Math.max(ldim,rdim),self_dim);
		}
		
		//------------- DIAMETER OF BINARY TREE --------------------//	
		//---------------------APPROACH 2 -----------------//
		//First create an Information class that stores height and diameter of the nodes
		
		public class Info{
			int d;
			int ht;
			public Info(int d ,int h)
			{
				this.d = d;
				this.ht = h;
			}
		}
		
		public Info diameter1(Node root)
		{
			// Base case
			if(root == null)
			{
				return new Info(0,0);
			}
			
			Info leftInfo = diameter1(root.left);
			Info rightInfo = diameter1(root.right);
			
			int diam = Math.max(Math.max(leftInfo.d, rightInfo.d),leftInfo.ht+rightInfo.ht+1);
			int ht  = Math.max(leftInfo.ht, rightInfo.ht)+1;
			
			return new Info(diam,ht);
			
		}//
		
	
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		//System.out.println("Root data: "+root.data);
		tree.preOrder(root);
		System.out.println();
		
//		System.out.println("****INORDER TRAVERSAL****");
//		tree.inOrder(root);
//		System.out.println("*******LEVEL ORDER TRAVERSAL********");
//		tree.levelOrder(root);
		System.out.println("Height of the tree  : "+tree.height(root));
		System.out.println("No. of nodes in tree: "+tree.countNodes(root));
		System.out.println("Sum of the nodes of the tree : "+tree.sumCount(root));
		//System.out.println("Diameter of the tree         : "+tree.diameter(root));
		System.out.println("Diameter of the tree         : "+tree.diameter1(root).d);
	}

}
