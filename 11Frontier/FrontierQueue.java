public class FrontierQueue<T> implements Frontier<T>{
    private MyQueue<T> myQueue;
    
    public FrontierQueue(){
	myQueue = new MyQueue<T>();
    }
    public void add(T element){
	myQueue.enqueue(element);
    }
    public T next(){
	return myQueue.dequeue();
    }
    public boolean hasNext(){
	return myQueue.peek()!=null;
    }
}
