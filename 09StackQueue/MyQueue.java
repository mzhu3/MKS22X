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
}
