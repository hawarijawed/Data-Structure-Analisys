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
          while(size>0){
              Node temp = queue.pop();
              if(temp.left != null){
                  queue.add(temp.left);
              }
              
              if(temp.right != null){
                  queue.add(temp.right);
              }
              
              if(size == 0){
                  lst.add(temp.data);
              }
          }
      }
      
      return lst;
    }
}
