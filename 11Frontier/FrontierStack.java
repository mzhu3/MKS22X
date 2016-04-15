import java.util.*;
public class FrontierStack<T> implements Frontier<T>{
    private Stack<T> myStack;

    public FrontierStack(){
	myStack = new Stack<T>();
    }
    public void add(T element){
	myStack.push(element);
    }
    public T next(){
	return myStack.pop();
    }
    public boolean hasNext(){
	try{
	    return myStack.peek()!=null;
	}
	catch(EmptyStackException e){
	    return false;
	}

    }
    public static void main(String[]args){
	FrontierStack<String> stack = new FrontierStack<String>();
	stack.add("hi");
	stack.add("bye");
	System.out.println(stack.hasNext());
	System.out.println(stack.next());
	System.out.println(stack.next());
	System.out.println(stack.hasNext());
	stack.add("hi");
	System.out.println(stack.hasNext());
    }
}
			  
		  
