import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isThisMax;

    public MyHeap(){
	size = 0;
        data = (T[])new Comparable[3];
	data[0] = null;
	isThisMax = true;
	
    }
    public MyHeap(T[] array){
	data = (T[])new Comparable[array.length + 1];
	data[0] = null;
	for(int i = 0; i < array.length; i ++){
	    data[i+1] = array[i];
	}
	size = array.length;
	isThisMax = true;
	heapify();
    }
    public MyHeap(boolean isMax){
	size = 0;
	data = (T[]) new Comparable[6];
	data[0] = null;
	isThisMax = isMax;
    }
    public MyHeap(T[] array, boolean isMax){
	data = (T[])new Comparable[array.length + 1];
	data[0] = null;
	for(int i = 0; i < array.length; i ++){
	    data[i+1] = array[i];
	}
	size = array.length;
	isThisMax = isMax;
	heapify();

    
    }
    private void swap(T[] items, int a, int b){
	T temp = items[a];
	items[a] = items[b];
	items[b] = temp;
    }
    private boolean hasLeft(int k){
	return data[k * 2] != null;
    }
    private boolean hasRight(int k ){
	return data[k * 2 + 1] != null;
    }
   private void pushDown(int k){
	T value = data[k];
	int left = k * 2;
	int right = k * 2 + 1;
	int biggerValueIndex = left;
	if( biggerValueIndex < size){
	    if(getThisMax()){
		if(right > size){
		    if(value.compareTo(data[biggerValueIndex])<0){
			swap(data,k,biggerValueIndex);
			pushDown(biggerValueIndex);
		    }
		}
		else{
		    if(data[right].compareTo(data[left])>0){
			biggerValueIndex = right;
		    }
		    if(value.compareTo(data[biggerValueIndex])<=0){
			swap(data,k,biggerValueIndex);
			pushDown(biggerValueIndex);
		    }
		}
	    }
	
	    else{
		if(right > size){
		    if(value.compareTo(data[left])>0){
			swap(data,k,left);
			pushDown(left);
		    }
		}
		else{
		    if(data[right].compareTo(data[left])<0){
			biggerValueIndex = right;
		    }
		    if(value.compareTo(data[biggerValueIndex])>=0){
			swap(data,k,biggerValueIndex);
			pushDown(biggerValueIndex);
		    }
		}
	    }
	}
    }
	public int getSize(){
	return size;
}
    private void pushUp(int k){
	if(k > 1){
	    if(getThisMax()){
		if(data[k].compareTo(data[k/2])>=0){
		    swap(data,k,k/2);
		    pushUp(k/2);
		}
	    }
	    else{
		if(data[k].compareTo(data[k/2])<=0){
		    swap(data,k,k/2);
		    pushUp(k/2);
		}
	    }	    
	}
    }
    private void heapify(){
	for(int i = size;i >size/2 ;i--){
	    pushUp(i);
	    //System.out.println(this);
	}
	add(delete());
    }
    public T peek(){
	if(size ==0){
	    throw new NoSuchElementException();
	}
	return data[1];
    }
    public T delete(){
	if(size ==0){
	    throw new NoSuchElementException();
	}
	T temp = data[1];
	data[1] = data[size];
	size --;
	pushDown(1);
	return temp;
    }
    public void add(T x) {
	if(size == data.length - 1) {
	    doubleSize();
	}
	size++;
	data[size] = x;
	pushUp(size);
    }


       
    private void doubleSize(){
	T[] temp = (T[])new Comparable[data.length * 2];
	T[] old = data;
	temp[0] = null;
        for(int i = 1; i < old.length; i ++){
	    temp[i] = old[i];
	}
	data = temp;
    }
    public String toString(){
	String ans = "";
	for(int i = 1; i <= size; i ++){
	    ans += data[i] + " ";
	}
	return ans;
    }
    public boolean getThisMax(){
	return isThisMax;
    }
    public static void main(String[] args){
	Integer[] obj = new Integer[] {10,100,12,122};
	MyHeap<Integer> h = new MyHeap<Integer>(obj);
	MyHeap<Integer> h1 = new MyHeap<Integer>();
	//	System.out.println(h1.getMax());
			h1.add(10);
	h1.add(100);
	h1.add(12);
	h1.add(122);
	System.out.println(h);
	System.out.println(h1);
		System.out.println(	h.delete());
		System.out.println(h1.delete());
	System.out.println(h);
	System.out.println(h1);
		MyHeap<Integer> h2 = new MyHeap<Integer>(obj,false);
	MyHeap<Integer> h3 = new MyHeap<Integer>(false);
	//	System.out.println(h1.getMax());
	h3.add(10);
	h3.add(100);
	h3.add(12);
	h3.add(122);
	h3.add(10);
	System.out.println(h2);
	System.out.println(h3);
	h2.delete();
	h3.delete();
	System.out.println(h2);
	System.out.println(h3);
    }

}

