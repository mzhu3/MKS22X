public class MyLinkedList{
    private int size;
    private LNode start;
    public MyLinkedList{
	size = 0;
	start = null;
    }

    public boolean add(int value){
	LNode current = start;
	
	while(current < size){
	current = current.getNext();
	}
	current.setNext(value);
    }

	return true;
    }
    private class LNode{
	private int head;
	private LNode next;
	public LNode(){
	    head = next[0];
	    next = null;
	}
	private int getNext(){
	    LNode current = next;
	    int next = current[0];
	    for(int i = 0; i <current - 1; i++){
		current[i] = next[i+1];
	    }
	    LNode next = current;
	    return next;
	}
	private void setNext(int value){
	    next = new LNode(value);
	    
    }
