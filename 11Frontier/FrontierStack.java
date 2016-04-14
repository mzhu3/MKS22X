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
	return myStack.empty();
    }
}
