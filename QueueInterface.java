public interface QueueInterface <T>{

    public void enqueue(T data);

    public void dequeue();

    public T getFront();

    public T getRear();

    public boolean isFull();

    public boolean isEmpty();

    public int size();

    public void print();

    
}
