package stacks.problems;
public class StackImplentationByArrays {
    public static void main(String args[]) {
        System.out.println("Stack Implentation using Arrays");
        StackLocal st = new StackLocal();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.show();
        st.push(60);
        st.push(70);
        System.out.println("POP ==> " +st.pop());
        st.show();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.show();
        System.out.println("SIZE =" + st.size());
        System.out.println("IS Empty =" + st.isEmpty());
    }
}

class StackLocal {
    int capacity = 2;
    int StackLocal[] =  new int[capacity];
    int top = 0;

    public void push(int data) {
       /* if (top == StackLocal.length) {
            System.out.println("Stack is Full");
        } else {*/
        if(size() == capacity)
            resizeArray();
        StackLocal[top] = data;
        top += 1;
        /*    }*/
    }

    private void resizeArray(){
        int length = size();
        int[] tempArray = new int[capacity * 2];
        for( int i=0; i< length; i++){
            tempArray[i] = StackLocal[i];
        }
        StackLocal = tempArray;
        capacity *=2;
    }

    private void reduceArray(){
        int length = size();
        if(length<=(capacity/2)/2){
            capacity = capacity/2;
        }
        int[] tempArray = new int[capacity];
        for( int i=0; i< length; i++){
            tempArray[i] = StackLocal[i];
        }
        StackLocal = tempArray;
    }

    public int pop(){
        int data = 0;
        if(top == 0){
            System.out.println("Empty Stack");
        } else {
            top -= 1;
            data = StackLocal[top];
            StackLocal[top] = 0;
            reduceArray();
        }
        return data;
    }

    public int peek(){
        System.out.println(top);
        return StackLocal[top];
    }
    public int size () {
        return top;
    }
    public boolean isEmpty () {

        return top == 0;
    }

    public void show () {
        for (int i = 0; i < StackLocal.length; i++) {
            System.out.print(StackLocal[i] + " ");
        }
        System.out.println();
    }
}
