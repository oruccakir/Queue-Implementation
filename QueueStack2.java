import java.util.Stack;

/*
 * method 1 by making dequeue operation costly
 */

public class QueueStack2 implements QueueInterface{


    private Stack<Object> stack1, stack2;

    public QueueStack2(){

        stack1 = new Stack<>();

        stack2 = new Stack<>();

    }


    @Override
    public void enqueue(Object data) {
        stack1.push(data);
    }

    @Override
    public void dequeue() {
       
        if(stack2.isEmpty()) while(stack1.isEmpty() == false) stack2.push(stack1.pop());

        stack2.pop();

    }

    @Override
    public Object getFront() {
        return null;
    }

    @Override
    public Object getRear() {
        return null;
    }

    @Override
    public boolean isFull() {
       return false;
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size()+stack2.size();
    }

    @Override
    public void print() {

        System.out.print("[ ");

        Object[] arr2 = stack2.toArray();

        for(int i=0; i<arr2.length; i++) System.out.print(arr2[i]+" ");
        
        Object[] arr = stack1.toArray();

        for(int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");

        System.out.println("]");

    }

    public static void main(String[] args) {

        QueueStack2 q = new QueueStack2();

        q.enqueue(16);
        q.enqueue(89);
        q.dequeue();
        q.dequeue();
        q.enqueue(16);
        q.enqueue(89);
        q.enqueue(16);
        q.enqueue(89);
        q.enqueue(16);
        q.enqueue(89);
        q.enqueue(16);
        q.enqueue(89);

        q.dequeue();
        q.dequeue();
        

        

        q.print();

        System.out.println("Front : "+q.getFront()+" Rear : "+q.getRear());

        System.out.println("Empty : "+q.isEmpty()+" Full : "+q.isFull());

        System.out.println("Size : "+q.size());
        
    }
    
}
