//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> lst = new ArrayList<>();
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      if(root == null){
          return lst;
      }
      
      //BFS search
      while(!queue.isEmpty()){
          int size = queue.size();
          for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                
                // If this is the rightmost element of the level, add it to the result
                if (i == 0) {
                    lst.add(node.data);
                }

                // Add children to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
      }
      
      return lst;
    }
}
