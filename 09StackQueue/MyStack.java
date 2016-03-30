import java.util.*;
public class MyStack<T> extends MyLinkedList<T>{
    private MyLinkedList<T> LinkedStack;
    /**
     * Adds the given item to the top of the stack.
     */
    public MyStack(){
	LinkedStack = new MyLinkedList<T>();
    }
    public void push(T item){
	LinkedStack.add(0,item);
    }
    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
	if(LinkedStack.size() ==0){
	    throw new NoSuchElementException();
	}
	return LinkedStack.remove(0);
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if(LinkedStack.size()==0){
	    throw new NoSuchElementException();
	}
	return LinkedStack.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size(){
	return LinkedStack.size();
    }
    
    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
	return (LinkedStack.size()==0);	
    }
    public static void main(String[]args){
	

}
