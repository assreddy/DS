package BinaryTrees;

class Node{
  int data;
  Node left, right;

  public Node(int data){
    this.data = data;
    this.left = this.right = null;
  }
}

public class BTTraversalUsingRecursive {
  Node root;

  public BTTraversalUsingRecursive(){
    root = null;
  }

  public void printPreOrder(Node node){
    if(node == null)
      return;
    System.out.print(node.data +" ");
    printPreOrder(node.left);
    printPreOrder(node.right);

  }

  public void printPostOrder(Node node){
    if(node == null)
      return;
    printPostOrder(node.left);
    printPostOrder(node.right);
    System.out.print(node.data +" ");
  }

  public void printInOrder(Node node){
    if(node == null)
      return;
    printInOrder(node.left);
    System.out.print(node.data +" ");
    printInOrder(node.right);
  }

  public static void main(String args[]){

    BTTraversalUsingRecursive treeTrav = new BTTraversalUsingRecursive();
    treeTrav.root  = new Node(1);
    treeTrav.root.left  = new Node(2);
    treeTrav.root.right  = new Node(3);
    treeTrav.root.left.left  = new Node(4);
    treeTrav.root.left.right  = new Node(5);

    System.out.print("Preorder ==> " +" ");
    treeTrav.printPreOrder(treeTrav.root);
    System.out.println();
    System.out.print("PostOrder ==> " +" ");
    treeTrav.printPostOrder(treeTrav.root);
    System.out.println();
    System.out.print("InOrder ==> " +" ");
    treeTrav.printInOrder(treeTrav.root);


  }
}
