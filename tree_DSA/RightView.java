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
      ArrayList<Integer> lst = new ArrayList<>();
      // Root points to null
      if(root == null){
          return lst;
      }
      Queueu<Node> queue = new LinkedList<>();
      queue.add(root);
      
      
      //BFS search
      while(!queue.isEmpty()){
          int size = queue.size();
          for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // If this is the rightmost element of the level, add it to the result
                if (i == size - 1) {
                    lst.add(node.val);
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
