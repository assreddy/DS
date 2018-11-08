package BinaryTrees.ProblemBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryNode{
  int data;
  BinaryNode left, right;

  public BinaryNode(int data){
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

public class BinaryTreeBasicMethodsWithRec {

  BinaryNode root;

/*  BinaryTreeBasicMethodsWithRec(){
    root = null;
  }*/

  public int maxElementInBinaryTree(BinaryNode root){
    int maxValue = Integer.MIN_VALUE;

    if(root != null){
      int leftMax = maxElementInBinaryTree(root.left);
      int rightMax = maxElementInBinaryTree(root.right);
      if(leftMax > rightMax) {
        maxValue = leftMax;
      }else {
        maxValue = rightMax;
      }
      if(root.data > maxValue) {
        maxValue = root.data;
      }
    }
    return maxValue;
  }

  public boolean findInBinaryTree(BinaryNode root, int data){
    if(root == null){
      return false;
    }
    if(root.data == data){
      return true;
    }
    return findInBinaryTree(root.left, data) || findInBinaryTree(root.right, data);
  }

  public int findSize(BinaryNode root){
    int leftCount = 0;
    int righCount = 0;
    if(root == null){
      return 0;
    }
    if(root.left==null && root.right == null){
      return 1;
    }else {
      leftCount = findSize(root.left);
      righCount = findSize(root.right);
    }
    return leftCount+righCount;
  }
  // Delete --> Traverse and then delete
  // Level Order Traversal .. Reverse...
  public BinaryNode insertElement(BinaryNode root, int value){
    if(root == null){
      return new BinaryNode(value);
    }
    if(value < root.data){
      root.left = insertElement(root.left, value);
    }else if(value > root.data){
      root.right = insertElement(root.right, value);
    }else {
      return root;
    }
    return root;
  }

  public BinaryNode deleteElement(BinaryNode node, int findKey){

    if(node == null){
      return root;
    }
    if(findKey < node.data){
      node.left = deleteElement(node.left, findKey);
    } else if(findKey > node.data){
      node.right = deleteElement(node.right, findKey);
    } else {
      if(node.left == null){
        return node.left;
      }else if(node.right == null){
        return node.right;
      }
      node.data = minValue(node.right);
      root.right = deleteElement(node.right, node.data);
    }
    return node;
  }

  int minValue(BinaryNode node)
  {
    int minv = node.data;
    while (root.left != null)
    {
      minv = root.left.data;
      root = root.left;
    }
    return minv;
  }

  // depth or hight of the Tree;;
  public int maxDepth(BinaryNode root){
    if(root == null){
      return 0;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    if(leftDepth > rightDepth){
      return leftDepth+1;
    }else {
      return rightDepth+1;
    }
  }

  public int minDepth(BinaryNode root){
    if(root == null){
      return 0;
    }
    Queue<BinaryNode> q = new LinkedList<>();
    q.offer(root);
    q.offer(null);
    int count = 1;
    while(!q.isEmpty()) {
      BinaryNode currentNode = q.poll();
      if (currentNode != null) {
        if (currentNode.left == null && currentNode.right == null) {
          return count;
        }
        if (currentNode.left != null) {
          q.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          q.offer(currentNode.right);
        }
      } else {
        if(!q.isEmpty()){
          count++;
          q.offer(null);
        }
      }
    }
    return count;
  }

  public int noOfLeaves(BinaryNode root) {
    BinaryNode temp = null;
    if (root == null) {
      return 0;
    }
    Queue<BinaryNode> q = new LinkedList<>();
    q.offer(root);
    int count = 0;
    while (!q.isEmpty()) {
      temp = q.poll();
      if (temp.left == null && temp.right == null) {
        count++;
      }
      if (temp.left != null) {
        q.offer(temp.left);
      }
      if (temp.right != null) {
        q.offer(temp.right);
      }
    }
    return count;
  }

  public BinaryNode deepestNodeOfBinarayTree(BinaryNode root) {
    BinaryNode temp = null;
    if(root == null){
      return null;
    }
    Queue<BinaryNode> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()){
      temp = q.poll();
      if(temp.left !=null){
        q.offer(temp.left);
      }
      if(temp.right !=null){
        q.offer(temp.right);
      }
    }
    return temp;
  }

  public void printPreOrderTraversal(BinaryNode node){
    if(node == null){
      return;
    }
    System.out.print(node.data +" ");
    printPreOrderTraversal(node.left);
    printPreOrderTraversal(node.right);
  }
  public static void main(String args[]) {
    BinaryTreeBasicMethodsWithRec bTree = new BinaryTreeBasicMethodsWithRec();

    bTree.root = new BinaryNode(1);
    bTree.root.left = new BinaryNode(2);
    bTree.root.right = new BinaryNode(3);
    bTree.root.left.left = new BinaryNode(4);
    bTree.root.left.right = new BinaryNode(5);

    System.out.print("PreORDER = ");
    bTree.printPreOrderTraversal(bTree.root);
    System.out.println(bTree.maxElementInBinaryTree(bTree.root));
    System.out.println(bTree.findInBinaryTree(bTree.root, 5));
    System.out.println("Size+" +bTree.findSize(bTree.root));
    System.out.println("Max Depth+" +bTree.maxDepth(bTree.root));
    System.out.println("Deepest Node =" +bTree.deepestNodeOfBinarayTree(bTree.root).data);
    System.out.println("Total No of Leavs =" +bTree.noOfLeaves(bTree.root));
    System.out.println("Min depth  =" +bTree.minDepth(bTree.root));
    System.out.println("Insert Element  =" +bTree.insertElement(bTree.root, 10).data);
    System.out.println(bTree.findInBinaryTree(bTree.root, 10));
    System.out.print("PreORDER = ");
    bTree.printPreOrderTraversal(bTree.root);
    System.out.println("Insert Element  =" +bTree.deleteElement(bTree.root, 10).data);
    System.out.print("PreORDER = ");
    bTree.printPreOrderTraversal(bTree.root);
  }
}
