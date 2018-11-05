package stacks.problems;

import java.util.NoSuchElementException;

public class StackImpLinkedList {

    public static void main(String args[]){
        System.out.println("Testing");
        linkedStack lStack = new linkedStack();
        lStack.push(10);
        lStack.push(20);
        lStack.push(30);
        System.out.println("PEEK => " +lStack.peek());
        lStack.display();
        System.out.println("SIZE => " +lStack.size());
        System.out.println("POP==> " +lStack.pop());
        lStack.display();
        System.out.println("Is Empty => " +lStack.isEmpty());

    }
}

class Node{

    int data;
    Node next;

    public Node(){
        data = 0;
        next = null;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class linkedStack{
    Node top;
    int size;

    linkedStack(){
        top = null;
        size = 0;
    }

    public void push(int data){
        Node node = new Node(data, null);
        if(top == null){
            top = node;
        }else {
            node.setNext(top);
            top = node;
        }
        size +=1;
    }

    public int pop(){
        if(isEmpty())
            throw new NoSuchElementException("UnderFlow Exception");
        Node node = top;
        top = node.getNext();
        size--;
        return node.getData();

    }

    public int peek(){
        Node node =  top;
        return node.getData();
    }
    public boolean isEmpty(){
        return top == null;
    }
    public int size(){
        return size;
    }
    public void display(){
        Node node =  top;
        while(node != null) {
            System.out.println(node.getData() +" ");
            node = node.getNext();
        }
    }

}
