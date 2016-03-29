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
    public static boolean isMatching(String s){
	String copy = s;
	if(s[0].equals(")")||
	   s[0].equals("}")||
	   s[0].equals("]")||
	   s[0].equals(">")||
	   s[s.length()-1].equals("(")||
	   s[s.length()-1].equals("{")||
	   s[s.length()-1].equals("[")||
	   s[s.length()-1].equals("<")){
	    return false;
	}
        for(int i = 0; i < copy.length(); i++){
	    if(copy[i].equals(")")){
		if(!(copy[i-1].equals("("))){
		    return false;
		}
		else{
		    int save = i - 1;
		    copy = copy.replace(copy[i-1]+copy[i],"");
		    i = save;
		}
	    }
	    return true;
	}
    }
    public static void main(String[]args){
	String input = "";
	if(args.length > 0){
	    input = args[0];
	}
	System.out.println(isMatching(input));
    }
}
