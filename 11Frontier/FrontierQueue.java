import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private Queue<T> myQueue;
    public FrontierQueue(){
	myQueue = new LinkedList<T>();
    }
    public void add(T element){
	myQueue.add(element);
    }
    public T next(){
	return myQueue.remove();
    }
    public boolean hasNext(){
	return myQueue.isEmpty();
    }
}
