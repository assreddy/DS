package LinkedLists.LinkedListMethods;

import java.util.HashSet;

class Node{
  int data;
  Node next;

  Node(int d){
    data = d;
    next = null;
  }

  public void setData(int data){
    this.data = data;
  }
  public int getData(){
    return data;
  }

  public Node getNode(){
    return next;
  }
  public void setNode(Node node){
    this.next = node;
  }
}

class LinkedList{
  Node head;

  public void pushAtBegin(int data){
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public void insertAfterPreviousNode(Node previousNode, int data){
    if(previousNode == null){
      System.out.println("Empty");
      return;
    }
    Node newNode = new Node(data);
    newNode.next = previousNode.next;
    previousNode.next = newNode;
  }

  public void insertAtEnd(int data){
    Node newNode = new Node(data);
    if(head == null){
      head = new Node(data);
    }
    newNode.next = null;

    Node lastNode = head;
    while(lastNode.next != null){
      lastNode = lastNode.next;
    }
    lastNode.next = lastNode;
    return;
  }

  public void printList(){
    Node n = head;
    while(n != null){
      System.out.println(n.data + " ");
      n = n.next;
    }
    System.out.println("");
  }

  public void printMiddle(){
    Node firstNode = head;
    Node secondNode = head;
    if(head != null){
      while(secondNode != null && firstNode.next != null){
        firstNode = firstNode.next.next;
        secondNode = secondNode.next;
      }
      System.out.println(secondNode.data);
    }
  }

  public void deleteNode(int key){
    Node temp = head;
    Node prev = null;
    if(temp != null && temp.data == key){
      head = temp.next;
      return;
    }
    while(temp != null && temp.data == key){
      prev = temp;
      temp = temp.next;
    }
    if(temp == null ) {
      return ;
    }
    prev.next = temp.next;
  }

  public void deleteNodePosition(int position){
    if(head == null){
      return;
    }
    Node temp = head;
    if(position == 0){
      head = temp.next;
      return;
    }
    for(int i=0; temp !=null && i<position-1; i++){
      temp = temp.next;
    }
    if(temp == null || temp.next == null){
      return;
    }
    Node next = temp.next.next;
    temp.next = next;
  }

  public void deleteLinkedList(){
    head = null;
  }

/*  public void deleteFromEnd(){
    Node node = head;
    if(node != null){
      head = node.getNode();
      node.set

    }

  }*/

/*  public void deleteFromFront(){
    Node node = head;
    if(node != null){
      head = node.getNode();
      node.set

    }

  }*/

  public int getCount(){
    Node temp = head;
    int count =0;
    while(temp != null){
      count++;
      temp = temp.next;
    }
    return count;
  }

  public boolean findNode(Node head, int x){

    Node current = head;
    while(current != null){
      if(current.data == x){
        return  true;
      }
      current = current.next;
    }
    return  false;
  }

  public int findNthNode(Node head, int position){

    Node current = head;
    int indexNode =0;
    while(current !=null){
      if(indexNode == position){
        return current.data;
      }
      indexNode++;
      current = current.next;
    }

    return 0; // When position is not found.

  }

  public void printNthNodeFromEnd(int n) {
    int len =0;
    Node temp = head;

    while(temp !=null){
      temp = temp.next;
      len++;
    }

    if(len < n){
      return;
    }
    temp = head;

    for(int i =1; i<len-n+1; i++){
      temp = temp.next;
    }
    System.out.println(temp.data);
  }

  public int findElementFoundCount(int key){

    int count =0;

    Node current = head;
    while(current !=null){
      if(current.data == key){
        count++;
        current = current.next;
      }
    }
    return count;
  }

  public int getLoopCountElements(Node list) {

    Node slowLoop = list;
    Node fastLoop = list;

    while (slowLoop != null && fastLoop != null && fastLoop.next != null) {
      slowLoop = slowLoop.next;
      fastLoop = fastLoop.next.next;
      int countNodesLoops = 1;
      Node temp = slowLoop;
      if (slowLoop == fastLoop) {
        while (temp.next != slowLoop) {
          countNodesLoops++;
          temp = temp.next;
        }
        return countNodesLoops;
      }
    }
    return 0;
  }

  public void removeDuplicateInSortedList(){
    Node current = head;
    Node nextNextNode;
    if(head == null){
      return;
    }
    while(current.next != null){

      if(current.data == current.next.data){
        nextNextNode = current.next.next;
        current.next = null;
        current.next= nextNextNode;
      } else{
        current= current.next;
      }
    }
  }

  public void removeDuplicateUnSortedList(){

    Node node1 = null;
    Node node2 = null;
    Node dup = null;

    node1 = head;

    while(node1 != null && node1.next != null){
      node2 = node1;

      while(node2.next != null){
        if(node1.data == node2.next.data){
          dup = node2.next;
          node2.next = node2.next.next;
          System.gc();
        } else {
          node2 = node2.next;
        }
      }
      node1 = node1.next;
    }

  }

  public Node reverseLinkedList(Node node){

    Node prev = null;
    Node current = node;
    Node next = null;

    while(current !=null){
      next = current.next;
      current.next = prev;
      prev= current;
      current = next;
    }
    node = prev;
    return node;


  }



}




public class LinkedListAllBasicMethods {

  public static void main(String args[]){

    System.out.println("Printing Linked List At Middle Element");

    LinkedList ll = new LinkedList();
    ll.pushAtBegin(10);
    ll.pushAtBegin(20);
    ll.pushAtBegin(30);
    ll.pushAtBegin(40);
    ll.pushAtBegin(50);
    ll.printList();
    System.out.println("===================");
    ll.printMiddle();
    System.out.println("===================");
    ll.deleteNode(50);
    ll.printList();
    ll.deleteNodePosition(1);
    ll.printList();
  }
}
