public class MyLinkedList{
    private int size;
    private LNode start;
    public MyLinkedList(){
	size = 0;
	start = null;
    }

    public boolean add(int value){
	LNode current = start;
	if(start == null){
	    start = new LNode(value);
	    size++;
	    return true;
	}
	else{
	    while(current.getNext()!= null){
		current = current.getNext();
	    }
	    current.setNext(value);
	    size++;
	    return true;
	}
				
    }
    public boolean add(int index, int value){
	LNode current = start;
	int counter = 0;
	if(index > size - 1){
	    return false;
	}
	else{
	    while(current.getNext()!=null ){
	    	counter++;
		current= current.getNext();
		if(counter == index - 1){
		    current.setNext(value);
		    current = current.getNext();
		}
		if(counter > index){
		    current.setNext(current.getHead());
		    current = current.getNext();
		    
		}
	      }
	      size++;
	      
	    return true;
	}
    }
    public int get(int index){
	LNode current = start;
	int counter = 0;
	if(index > size -1){
	    return -1;
	}
	else{
	    while(counter != index){
		current = current.getNext();
		counter++;
	    }
	    return current.getHead();
	}
    }
    public Integer set(int index, int newValue){
	LNode current = start;
	int counter = 0;
	if(index > size -1){
	    return null;
	}
	else{
	    while(counter  < index - 1){
		current = current.getNext();
		counter ++;
	    }
	    int temp = current.getNext().getHead();
	    current.setNext(newValue);
	    return temp;
	}
    }
    public int size(){
	return size;
    }
    public Integer remove(int index){
	LNode current = start;
	int counter = 0;
	int temp = 0;
	if(index > size - 1){
	    return null;
	}
	else{
	    while(counter <index - 1){
		current = current.getNext();
		counter ++;
	    }
	    temp = current.getNext().getHead();;
	    while(current.getNext()!= null){
		current.setNext(current.getNext().getNext().getHead());
		current = current.getNext();
	    }
	    size --;
	    return temp;
	}
    }
    public int indexOf(int value){
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
    public String toString(){
	if(size == 0){
	    return "[]";
	}
	else{
	    String ans = "[";
	    LNode current = start;
	    int counter = 0;
	    while(counter < size&& current !=null  ){
		ans += current.getHead()+", ";
		current = current.getNext();
		counter ++;
	    }
	    ans+= "]";
	    return ans;
	}
    }
    private class LNode{
	private int head;
	private LNode next;
	public LNode(int value){
	    head=  value;
	}
	private int getHead(){
	    return head;
	}
	private LNode getNext(){
	    return next;
	}
	private void setNext(int value){
	    next = new LNode(value);
	}
	private void setHead(int value){
	    head = value;
	}
	private void setNext(LNode node){
	    next = node;
	}
	    
    }
}
