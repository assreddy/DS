package LinkedLists;

class Node{

  int data;
  Node next;

  public Node(int data){
    this.data = data;
    this.next = next;
  }
}

class LinkedList{
  Node head;

  public void addNodeLast(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  public void printLinkedList(){
    Node node = head;
    while(node != null){
      System.out.println(node.data +" ");
      node = node.next;
    }
    System.out.println();
  }


}

class MergeSort{

  public Node MergeTwoLinkedLists(Node l1, Node l2){

    Node dummyNode = new Node(0);
    Node tail = dummyNode;

    while(true){
      if(l1 == null){
        tail.next = l2;
        break;
      }
      if(l1 == null){
        tail.next = l1;
        break;
      }

      if(l1.data <= l2.data){
        tail.next = l1;
        l1 = l1.next;
      } else {
        tail.next = l2;
        l2 = l2.next;
      }
      tail = tail.next;
    }
    return dummyNode.next;
  }
}

public class MergeSortedLinkedLists {

  public static void main(String args[]) {

    LinkedList ll1 = new LinkedList();
    ll1.addNodeLast(10);
    ll1.addNodeLast(20);
    ll1.printLinkedList();

    System.out.println("---------------------------------");
    LinkedList ll2 = new LinkedList();
    ll2.addNodeLast(30);
    ll2.addNodeLast(40);
    ll2.printLinkedList();
    MergeSort ms = new MergeSort();
    ll1.head = new MergeSort().MergeTwoLinkedLists(ll1.head, ll2.head);
    System.out.println("---------------------------------");
    ll1.printLinkedList();
  }
}
