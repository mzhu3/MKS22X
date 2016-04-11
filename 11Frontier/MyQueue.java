import java.util.*;

public class MyQueue<T> extends MyLinkedList<T>{
    private MyLinkedList<T> LinkedQueue;

    public MyQueue(){
	LinkedQueue = new MyLinkedList<T>();
    }
    /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item){
	LinkedQueue.add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue(){
	if(LinkedQueue.size()==0){
	    throw new NoSuchElementException();
	}
	return LinkedQueue.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if(LinkedQueue.size()==0){
	    throw new NoSuchElementException();
	}
	return LinkedQueue.get(0);
    }

    /**
     * Returns the number of items currently in the queue.
     */
    public int size(){
	return LinkedQueue.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty(){
	return LinkedQueue.size()==0;
    }

    public static void main(String[]args){
	MyQueue<String> S = new MyQueue<String>();
	Queue<String> D = new LinkedList<String>();
        try{
	    S.dequeue();
	}
	catch(NoSuchElementException e){
	}
	try{
	    S.peek();
	}
	catch(NoSuchElementException e){
	}
	Random rand = new Random(0);
	for(int i = 0; i < 6000; i ++){
	    S.enqueue(i +"");
	    D.add(i+"");
	}
			
	System.out.println(S.isEmpty());
	System.out.println(D.isEmpty());
	int x1 = rand.nextInt(6000);
	for(int i = 0; i < x1; i ++){
	    if(!S.dequeue().equals(D.remove())){
		System.out.println("Not same match");
		System.exit(1);
	    }
	}
    }
}



