package dsimplementations;

class StackFixedSizeArrayImp {

  protected int capacity;
  protected int[] stackRep;

  public static final int CAPACITY = 10;
  protected int top =-1;

  public StackFixedSizeArrayImp(){
    this(CAPACITY);
  }

  public StackFixedSizeArrayImp(int cap){
    capacity = cap;
    stackRep = new int[capacity];
  }

  public int size(){
    return (top +1);
  }

  public boolean isEmpty(){
    return (top<0);
  }

  public void push(int data) throws Exception{
    if(size() == capacity) throw new Exception("Stack is Full");
    stackRep[++top] = data;
  }

  public int peek(){
    return stackRep[top];
  }

  public int top(){
    return stackRep[top];
  }

  public int pop(){
    int data = stackRep[top];
    stackRep[top--] = Integer.MIN_VALUE;
    return data;
  }

  public void dispayStack(){
    for(int i=0; i<stackRep.length;i++){
      System.out.print(stackRep[i] +" ");
    }
  }

  public String toString(){

    String s = "[";
    if(size() > 0){
      s = s+stackRep[0];
    }
    if(size() > 1){
      for(int i=1; i<=size()-1;i++){
        s = s+ ", " +stackRep[i];
      }
      s= s+"]";
    }
    return s;
  }
}

public class StackFixedSizeArray{
  public static void main(String args[]) throws Exception {
    StackFixedSizeArrayImp stackImp = new StackFixedSizeArrayImp();
    System.out.println(stackImp.size());
    stackImp.push(10);
    stackImp.push(20);
    stackImp.push(30);
    System.out.println(stackImp.size());
    System.out.println(stackImp.peek());
    stackImp.dispayStack();
    System.out.println(stackImp.isEmpty());
    System.out.println(stackImp.top());
    stackImp.pop();
    stackImp.dispayStack();
    System.out.println("==============");
    System.out.println(stackImp.toString());
  }
}
