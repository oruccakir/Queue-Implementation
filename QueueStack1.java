import java.util.Stack;

/*
 * method 1 by making enqueue operation costly
 */

public class QueueStack1 implements QueueInterface{


    private Stack<Object> stack1, stack2;

    public QueueStack1(){

        stack1 = new Stack<>();

        stack2 = new Stack<>();

    }


    @Override
    public void enqueue(Object data) {

        while(stack1.isEmpty() == false) stack2.push(stack1.pop());

        stack1.push(data);

        while(stack2.isEmpty() == false) stack1.push(stack2.pop());
        
    }

    @Override
    public void dequeue() {
       stack1.pop();
    }

    @Override
    public Object getFront() {
        return stack1.peek();
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
        return stack1.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size();
    }

    @Override
    public void print() {
        
        Object[] arr = stack1.toArray();

        System.out.print("[ ");

        for(int i=arr.length-1; i>=0; i--) System.out.print(arr[i]+" ");

        System.out.println("]");

    }

    public static void main(String[] args) {

        QueueStack1 q = new QueueStack1();

        q.enqueue(16);
        q.enqueue(89);
        q.dequeue();

        

        q.print();

        System.out.println("Front : "+q.getFront()+" Rear : "+q.getRear());

        System.out.println("Empty : "+q.isEmpty()+" Full : "+q.isFull());

        System.out.println("Size : "+q.size());
        
    }
    
}
