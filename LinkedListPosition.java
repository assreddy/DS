public class Node {

  int data;
  Node next;

  public static void main(String args[]){
    System.out.println("Testing");
    LinkedListLocal lList = new LinkedListLocal();
    lList.insert(10);
    lList.insert(20);
    lList.insert(30);
    lList.insert(40);
    lList.insertAtStart(25);
    lList.insertAtPosition(300,0);
    lList.delete(2);
    lList.display();
  }
}


class LinkedListLocal{

  Node head;

  // Insert at the End.
  public void insert(int data){
    Node node = new Node();
    node.data = data;
    node.next = null;

    if(head==null){
      head = node;
    } else {
      Node n = head;
      while(n.next!=null){
        n = n.next;
      }
      n.next= node;
    }
  }

  // Display Method
  public void display(){
    Node node = head;
    while(node.next!=null){
      System.out.println(node.data);
      node = node.next;
    }
    System.out.println(node.data);
  }
  // Insert Element at Start of LinkedList
  public void insertAtStart(int data){
    Node node = new Node();
    node.data = data;
    node.next = null;
    node.next = head;
    head = node;
  }

  // Insert Element in Given Position.
  public void insertAtPosition(int data, int index) {
    Node node = new Node();
    node.data = data;
    node.next = null;
    if (index == 0) {
      insertAtStart(data);
    } else {
      Node n = head;
      for (int i = 0; i < index - 1; i++) {
        n = n.next;
      }
      node.next = n.next;
      n.next = node;
    }
  }

  // Delete Method.
  public void delete(int index){
    Node node = new Node();

    if(index ==0){
      head = head.next;
    } else {
      Node n = head;
      Node temp = null;
      for(int i=0; i<index-1;i++){
        n = n.next;
      }
      temp = n.next;
      n.next = temp.next;
      System.out.println("Temp Value ::" +temp.data);
    }


  }
}
