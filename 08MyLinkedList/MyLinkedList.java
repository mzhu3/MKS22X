import java.util.*;
import java.lang.*;
import java.util.Iterator;
public class MyLinkedList<T> implements Iterable<T>{
    private int size;
    private LNode start,end;
    
    public MyLinkedList(){
	size = 0;
	start = null;
	end = null;
    }
    public MyLinkedList(T value){
	start = new LNode(value);
	end = start;
	size ++;
    }
    public boolean add(T value){
	if(start ==null){
	    start = new LNode(value);
	    end = start;
	    size++;
	    return true;
	}
	LNode current = new LNode(value);
	end.setNext(current);
	end = current;
	size++;
	return true;
    }
    public boolean add(int index, T value){
	LNode current = start;
	int counter = 0;
	if(index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	if(index == size){
	    this.add(value);
	    return true;
	}
	if(index==0){
	    LNode remainder = current;
	    start = new LNode(value);
	    start.setNext(remainder);
	    size++;
	    return true;
	}
	else{
	    while(counter < index - 1 ){
		current= current.getNext();
		counter++;
	    }
	    LNode remainder = current.getNext();
	    current.setNext(new LNode(value));
	    current.getNext().setNext(remainder);
	    size ++;
	    return true;
	}
    }
    public T get(int index){
	LNode current = start;
	int counter = 0;
	if(index > size -1){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    while(counter != index){
		current = current.getNext();
		counter++;
	    }
	    return current.getHead();
	}
    }
    public T set(int index, T newValue){
	LNode current = start;
	int counter = 0;
	if(index > size -1){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    while(counter  < index){
		current = current.getNext();
		counter ++;
	    }
	    T temp = current.getHead();
	    current.setHead(newValue);
	    return temp;
	}
    }

    public T remove(int index){
	LNode current = start;
	int counter = 0;
	T temp;
	if(index > size - 1 || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	if(index ==0){
	    temp = current.getHead();
	    LNode remainder = current.getNext();
	    start.setNext(remainder);
	    start = remainder;
	    size--;
	    return temp;
	}
	while(counter < index - 1 ){
	    current = current.getNext();
	    counter ++;
	}
	temp = current.getNext().getHead();
	if(index == size-1){
	    end = current;
	}
	LNode remainder = current.getNext().getNext();
	current.setNext(remainder);

	size--;
	return temp;
    } 
    public int indexOf(T value){
	int counter = 0;
	LNode current = start;
	while(counter < size){
	    if(current.getHead().equals(value)){
		return counter;
	    }
	    counter ++;
	}
	return -1;
    
    }
    
    public String toString(){
	String ans = "[";
	LNode p = start;
	while(p != null){
	    ans += p.getHead();
	    if(p.getNext()!= null){
		ans+=", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
    public String toString(boolean a){
	if(a){
	    return this.toString() +"Head: " + getHead() + "\t" + "Tail: " + getTail();
	}
	return this.toString();
    
    }
    public String getHead(){
	return ""+start.getHead();
    }
    public String getTail(){
	return ""+end.getHead();
    }
    public int size(){
	return size;
    }
    
    public class LLIt implements Iterator<T> {
	LNode current;

	public LLIt() {
	    current = start;
	}
	
	public boolean hasNext() {
	    if(current.getNext()!=null){
		return true;
	    }
	    return false;
	}
	public T next() {
	    return current.getHead();
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
    
    public Iterator<T> iterator() {
	return new LLIt();
    }
    
    private class LNode{
	private T head;
	private LNode next;
	public LNode(T value){
	    head=  value;
	}
	private T getHead(){
	    return head;
	}
	private LNode getNext(){
	    return next;
	}
	private void setNext(T value){
	    next = new LNode(value);
	}
	private void setHead(T value){
	    head = value;
	}
	private void setNext(LNode node){
	    next = node;
	}
	    
    }
}
// Billy helped with fixing the remove/add at wrong indexes
