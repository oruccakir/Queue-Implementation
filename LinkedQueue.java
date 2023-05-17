import javax.xml.crypto.Data;

public class LinkedQueue <T> implements QueueInterface {

    public int size;

    private Node head, tail;

    public LinkedQueue(){

        size = 0;

        head = tail = null;

    }

    

    @Override
    public void enqueue(Object data) {

        Node newNode = new Node(data);

        if(head == null){

            head = tail = newNode;

        }
        else{

            tail.next = newNode;

            tail = newNode;

        }

        size++;


        
    }

    @Override
    public void dequeue() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return; }

        head = head.next;

        if(head == null) tail = null;

        size--;
        
    }

    @Override
    public Object getFront() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return null; }

        return head.data;

    }

    @Override
    public Object getRear() {

        if(isEmpty()) { System.err.println("Queue underflow error"); return null; }

        return tail.data;
        
    }

    @Override
    public boolean isFull() {

        return false;
        
    }

    @Override
    public boolean isEmpty() {

        return head == null;

    }

    @Override
    public int size() {

        return size;
        
    }

    @Override
    public void print() {

        Node temp = head;

        System.out.print("[ ");

        while(temp != null){

            System.out.print(temp.data+" ");

            temp = temp.next;

        }

        System.out.println("]");
        
    }

    private class Node{

        private Node next;

        private Object data;

        public Node(Object data){

            this.data = data;

            this.next = null;

        }

    }

    public static void main(String[] args) {
        
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(15);

        queue.enqueue(28);

        queue.enqueue(51);

        queue.dequeue();

        queue.dequeue();

        queue.dequeue();

        queue.print();

        

        System.out.println("Front : "+queue.getFront()+" Rear : "+queue.getRear());

        System.out.println("Empty : "+queue.isEmpty()+" Full : "+queue.isFull());

        System.out.println("Size : "+queue.size());

    }
    
}
