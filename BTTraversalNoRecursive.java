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

  public ArrayList<Integer> printPostOrderNoRec(BinaryNode BinaryNode){
    ArrayList<Integer> res = new ArrayList<>();
    if(root == null){
      return res;
    }
    Stack<BinaryNode> s = new Stack<>();
    s.push(root);

    BinaryNode pre = null;

    while(!s.isEmpty()){
      BinaryNode curr = s.peek();
      //Traverse from top to bottom and if curr has left child or right child
      // push into the stack : otherwise pop out.
      if(pre == null || pre.left == curr|| pre.right == curr){
        if(curr.left != null){
          s.push(curr.left);
        } else if(curr.right != null){
          s.push(curr.right);
        }
      } else if(curr.left == pre) {
        if (curr.right != null) {
          s.push(curr.right);
        }
      }
      else{
        res.add(curr.data);
        s.pop();
      }

      pre = curr;
    }
    return res;
  }

  public ArrayList<Integer> printInOrderNoRec(BinaryNode node){
    ArrayList<Integer> res = new ArrayList<>();
    if(root == null){
      return res;
    }
    Stack<BinaryNode> s = new Stack<>();
    BinaryNode currentNode = root;
    boolean isDone = false;

    while(!isDone){
      if(currentNode !=null){
        s.push(currentNode);
        currentNode =currentNode.left;
      }else {
        if(s.isEmpty()){
          isDone=true;
        } else {
          currentNode = s.pop();
          res.add(currentNode.data);
          currentNode = currentNode.right;
        }
      }
    }
    return res;
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
    System.out.println(BTNoRec.printPostOrderNoRec(BTNoRec.root).toString());

    System.out.println();
    System.out.print("InOrder ==> " +" ");
    System.out.println(BTNoRec.printInOrderNoRec(BTNoRec.root).toString());
  }
}
