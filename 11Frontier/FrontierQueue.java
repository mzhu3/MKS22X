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
	return myQueue.peek()!=null;
    }
     public static void main(String[]args){
	FrontierQueue<String> stack = new FrontierQueue<String>();
	stack.add("hi");
	stack.add("bye");
	System.out.println(stack.hasNext());
	System.out.println(stack.next());
	System.out.println(stack.hasNext());
	System.out.println(stack.next());
	System.out.println(stack.hasNext());
    }
}
