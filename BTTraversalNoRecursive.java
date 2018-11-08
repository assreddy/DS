package BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

class BinaryNode{
  int data;
  BinaryNode left, right;

  public BinaryNode(int data){
    this.data = data;
    this.left = left;
    this.right = right;
  }



}

public class BTTraversalNoRecursive {

  BinaryNode root;

  public BTTraversalNoRecursive(){
    root = null;
  }

  public ArrayList<Integer> printPreOrderNoRec(BinaryNode BinaryNode){
    ArrayList<Integer> res = new ArrayList<>();
    if(root == null){
      return res;
    }
    Stack<BinaryNode> s = new Stack<>();
    s.push(root);

    while(!s.isEmpty()){
      BinaryNode temp = s.pop();
      res.add(temp.data);
      if(temp.right != null){
        s.push(temp.right);
      }
      if(temp.left !=null){
        s.push(temp.left);
      }
    }
    return res;
  }

  public void printPostOrderNoRec(BinaryNode BinaryNode){

  }

  public void printInOrderNoRec(BinaryNode node){

  }

  public static void main(String args[]){
    BTTraversalNoRecursive BTNoRec = new BTTraversalNoRecursive();

    BTNoRec.root  = new BinaryNode(1);
    BTNoRec.root.left  = new BinaryNode(2);
    BTNoRec.root.right  = new BinaryNode(3);
    BTNoRec.root.left.left  = new BinaryNode(4);
    BTNoRec.root.left.right  = new BinaryNode(5);

    System.out.print("Preorder ==> " +" ");
    System.out.println(BTNoRec.printPreOrderNoRec(BTNoRec.root).toString());
    System.out.println();
    System.out.print("PostOrder ==> " +" ");

    System.out.println();
    System.out.print("InOrder ==> " +" ");




  }


}
