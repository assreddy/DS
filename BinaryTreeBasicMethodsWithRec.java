package BinaryTrees.ProblemBinaryTree;

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

  public BinaryNode insertElement(BinaryNode root, int data){


    return root;
  }

  public int deleteElement(BinaryNode root, int data){
    return 0;
  }

  public int highestDepth(BinaryNode root, int data){
    return 0;
  }

  public int minDepth(BinaryNode root, int data) {
    return 0;
  }

  public int deepestNodeOfBinarayTree(BinaryNode root, int data) {
    return 0;
  }
    public static void main(String args[]) {
    BinaryTreeBasicMethodsWithRec bTree = new BinaryTreeBasicMethodsWithRec();

    bTree.root = new BinaryNode(1);
    bTree.root.left = new BinaryNode(2);
    bTree.root.right = new BinaryNode(3);
    bTree.root.left.left = new BinaryNode(4);
    bTree.root.left.right = new BinaryNode(5);

    System.out.println(bTree.maxElementInBinaryTree(bTree.root));
      System.out.println(bTree.findInBinaryTree(bTree.root, 5));
      System.out.println("Size+" +bTree.findSize(bTree.root));
  }


}
