public class FrontierStack<T> implements Frontier<T>{
    private MyStack<T> myStack;

    public FrontierStack(){
	myStack = new MyStack<T>();
    }
    public void add(T element){
	myStack.push(element);
    }
    public T next(){
	return myStack.pop();
    }
    public boolean hasNext(){
	return myStack.peek()!=null;
    }
}
