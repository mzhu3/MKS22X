public class MyLinkedList<T>{
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
	if(index > size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == size){
	    this.add(value);
	    return true;
	}
	else{
	    while(counter < index - 1 ){
		current= current.getNext();
		counter++;
	    }
	    LNode remainder = current.getNext();
	    current.setNext(value);
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
	if(index > size - 1){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    while(counter <index - 1 ){
		current = current.getNext();
		counter ++;
	    }
	    LNode remainder = current.getNext().getNext();
	    temp = current.getNext().getHead();
	    current.setNext(remainder);
	    return temp;
	}
    }
    /*    public int indexOf(int value){
	  int counter = 0;
	  LNode current = start;
	  boolean there = false;
	  while(counter < size){
	  if(current.getHead()==value){
	  return counter;
	  }
	  counter ++;
	  }
	  return -1;
    
	  }
    */
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

    public int size(){
	return size;
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
