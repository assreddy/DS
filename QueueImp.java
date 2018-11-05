public class QueueImpArrays {
    public static void main(String args[]){
        System.out.println("Queue using Arrays");
        Queue q = new Queue(5);
        q.insert(10);
        q.insert(120);
        q.insert(100);
        q.display();
        q.remove();
        q.display();
        System.out.println("Is Empty = " +q.isEmpty());
        System.out.println("Size ==" +q.size());
        System.out.println("Is Full=" +q.isFull());
        System.out.println("PEEK =" +q.peek());


    }
}

class Queue
{
    int front, rear, size, length;
    int QueueArray[];

    public Queue(int n){
        front = -1;
        rear = -1;
        QueueArray = new int[n];
        size = n;
        length = 0;
    }


    public void insert(int data){
        if(rear == -1){
            front =0;
            rear = 0;
            QueueArray[rear] = data;
        }else if(rear+1 >= size) {
            throw new IndexOutOfBoundsException("Full");
        } else if(rear+1 < size){
            QueueArray[++rear] = data;
            length++;
        }
    }

    public int remove(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Queue Empty");
        } else {
            length--;
            int element = QueueArray[front];
            if(front == rear){
                front = -1;
                rear = -1;
            } else
                front++;
            return element;
        }
    }
    public int peek(){
        return QueueArray[front];
    }
    public boolean isEmpty(){
        return front ==-1;
    }

    public int size(){
        return length;
    }

    public boolean isFull(){
        return front == 0 && rear == size +1;
    }

    public void display(){
        for(int i =0; i<length;i++){
            System.out.print(QueueArray[i] +" ");
        }
        System.out.println();

    }

}
