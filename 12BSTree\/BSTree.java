public class BSTree<T extends Comparable<T>>{
    private class Node{
	Node left,right;
	T value;
	int height;
	public Node(Node L, Node R, T element){
	    left = L;
	    right = R;
	    value = element;
	    height = 1;
	}
	public Node(T element){
	    value = element;
	    height = 1;
	}
	private Node getLeft(){
	    return left;
	}
	private Node getRight(){
	    return right;
	}
	private T getValue(){
	    return value;
	}
	private void setLeft(Node newLeft){
	    left = newLeft;
	}
	private void setRight(Node newRight){
	    right = newRight;
	}
	private void setValue(T element){
	    value = element;
	}
	public height(){
	    return height;
	}
    }
    Node root;
    public BSTree(T element){
	root = (new Node(element));
    }
    public BSTree(Node leftRight){
	root = leftRight;
    }
    public add(T value){
	Node current = root;
	while(current.getHeigh
	if(current.getValue().compareTo(value)< 0){
	    current = current.getLeft();
	}
	else if(current.getValue().compareTo(value)>0){
	    current = current.getRight();
	}
	else{
	    
