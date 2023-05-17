import java.util.Arrays;

public class Queue <T> implements QueueInterface {

    private int size, capacity,frontIndex = -1, rearIndex = -1;

    private Object [] queueArray;

    public Queue(){

        size = 0;

        capacity = 10;

        queueArray = new Object[capacity]; 

    }

    public Queue(int capacity){

        this.capacity = capacity;

        queueArray = new Object[capacity];

    }


    public void enqueue(Object data) {

        if(isFull()) { System.err.println("Queue overflow error"); return; }

        rearIndex = (rearIndex + 1 ) % capacity;

        queueArray[rearIndex] = data;

        if(frontIndex == -1) frontIndex = rearIndex;

        size++;

    }

    @Override
    public void dequeue() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return; }

        queueArray[frontIndex] = null;

        frontIndex = (frontIndex+1) % capacity;

        size--;
        
    }

    @Override
    public T getFront() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return null; }

        return  (T) queueArray[frontIndex];
        
    }

    @Override
    public T getRear() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return null; }

        return (T)queueArray[rearIndex];
        
    }

    @Override
    public boolean isFull() {

        return size == capacity;
       
    }

    public boolean isEmpty(){

        return size == 0;
    }

    public void print(){

        System.out.println(Arrays.toString(queueArray));

        
    }

    public int size(){

        return size;

    }

    public static void main(String[] args) {

        Queue <Integer> queue = new Queue<>(5);

        queue.enqueue(2);

        queue.enqueue(5);

        queue.enqueue(15);

        queue.enqueue(0);

        queue.enqueue(1);

        


        queue.dequeue();

        queue.enqueue(81);

        queue.dequeue();

        queue.enqueue(78);

        queue.dequeue();

        queue.dequeue();

        queue.dequeue();

        queue.dequeue();

        queue.dequeue();

        //queue.dequeue();

        //queue.dequeue();

       // queue.dequeue();

        
        queue.print();

       /* System.out.println("Front : "+queue.getFront()+" Rear : "+queue.getRear());

        System.out.println("Empty : "+queue.isEmpty()+" Full : "+queue.isFull());

        System.out.println("Size : "+queue.size());*/
        
    }

    

    
    
}
