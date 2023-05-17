public class SimpleQueue <T> implements QueueInterface{

    private int size, capacity,index =-1;

    private Object [] queueArray;

    public SimpleQueue(){

        capacity = 10;

        queueArray = new Object[capacity]; 

    }

    public SimpleQueue(int capacity){

        this.capacity = capacity;

        queueArray = new Object[capacity];

    }

    

    @Override
    public void enqueue(Object data) {

        if(isFull()) { System.err.println("Queue overflow error"); return; }

        index++;

        queueArray[index] = data;

        size++;
 
    }

    @Override
    public void dequeue() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return; }

        for(int i=1; i<size; i++){

            queueArray[i-1] = queueArray[i];

        }

        size--;

        index--;
       
    }

    @Override
    public T getFront() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return null;}

        return (T) queueArray[0];

    }
       

    @Override
    public T getRear() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return null;}

        return (T) queueArray[index];

        
    }

    @Override
    public boolean isFull() {

        return size == capacity;
        
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
        
    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public void print() {
        
        System.out.print("[ ");

        for(int i=0; i< size; i++){

            System.out.print(queueArray[i]+" ");

        }

        System.out.println("]");

    }

    /*
     * This implementation is not efficient because dequeue taked O(N) time Complexity
     */


    public static void main(String[] args) {

        SimpleQueue<Integer> queue = new SimpleQueue<>(5);


        

        queue.enqueue(15);

        queue.enqueue(25);

        queue.enqueue(55);

        queue.enqueue(25);

        queue.enqueue(55);

        queue.dequeue();

        queue.print();

        System.out.println("Front : "+queue.getFront()+" Rear : "+queue.getRear());

        System.out.println("Empty : "+queue.isEmpty()+" Full : "+queue.isFull());

        System.out.println("Size : "+queue.size());

    
        
    }

    

    



}
