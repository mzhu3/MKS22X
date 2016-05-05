public class BSTree<T extends Comparable<T>>{
    private class Node{
	Node left,right;
	T value;
	public Node(Node L, Node R, T element){
	    left = L;
	    right = R;
	    value = element;
	}
	public Node(T element){
	    left = null;
	    right = null;
	    value = element;
	}
	public Node(){
	    left = null;
	    right = null;
	    value = null;
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
	private boolean hasChildren(){
	    return (right !=null || left !=null);
	}
	private int height(){
	    int height = 1;
	    if(hasChildren()){
		int heightR = 0;
		int heightL = 0;
	        if(getRight() != null){
		    heightR = getRight().height() + 1;
		}
		if(getLeft() != null){
		    heightL = getLeft().height() + 1;
		}
		height += Math.max(heightR, heightL);
	    }
	    return height;
	}
	  public boolean contains(T value){
	if(getValue().compareTo(value) == 0){
	    return true;
	}
	if(getValue().compareTo(value) < 0 &&getRight()!=null){
	    return getRight().contains(value);
	}
	if(getValue().compareTo(value) > 0 &&getLeft()!=null){
	    return getLeft().contains(value);
	}
										
	return false;
    }
	public String toString(){
	    String ans = "";
	    if(getValue() != null){
		if(getLeft()!= null &&getRight() != null){
		    ans += getValue() +" " + getLeft().toString()+ " " + getRight().toString();
		    return ans;
		}
		else if( getLeft()!= null){
		    ans += getValue() + " " + getLeft().toString() + " _";
		    return ans;
		}
		else if(getRight() != null){
		    ans+= getValue() + " _ " + getRight().toString();
		    return ans;
		}
		else{
		    ans += getValue()+ " _ _";
		    return ans;
		}
	    }
	    else{
		ans += "_";
		return ans;
	    }
	}

	public void add(T value){
	    if(getValue() == null){
		setValue(value);
	    }
	    else{
		if(getValue().compareTo(value) < 0){
		    if(getRight() != null){
			getRight().add(value);
		    }
		    else{
			setRight(new Node( value));
		    }
		}
		else{
		    if(getLeft() != null){
			getLeft().add(value);
		    }
		    else{
			setLeft(new Node(value));
		    }
		}
	    }
	}
    }

    private Node root;
    public BSTree(){
	root = new Node();
    }
    public BSTree(T element){
	root = (new Node(element));
    }
    public BSTree(Node top){
	root = top;
    }
    public int getHeight(){
	return root.height();
    }
    public void add(T value){
	root.add(value);
    }
    public boolean contains(T value){
	return root.contains(value);
    }
    public String toString(){
	String ans = "";
	ans += root.toString();
	return ans;
	
    }
}

// Thanks Alvin (Pd 6) for explaining why my toString returned an address and why my add did not work as intended
