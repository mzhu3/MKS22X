public class LNode{
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
