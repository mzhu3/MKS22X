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
	MyStack<String> S = new MyStack<String>();
	Stack<String> D = new Stack<String>();
        try{
	    S.pop();
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
	    S.push(i +"");
	    D.push(i+"");
	}
			
	System.out.println(S.isEmpty());
	System.out.println(D.isEmpty());
	int x1 = rand.nextInt(6000);
	for(int i = 0; i < x1; i ++){
	    if(!S.pop().equals(D.pop())){
		System.out.println("Not same match");
		System.exit(1);
	    }
	}
    }
}

