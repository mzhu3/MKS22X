import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax;

    public MyHeap(){
	size = 0;
        data = (T[])new Comparable[3];
	data[0] = null;
	isMax = true;
	
    }
    public MyHeap(T[] array){
	data = (T[])new Comparable[array.length + 1];
	data[0] = null;
	for(int i = 0; i < array.length; i ++){
	    data[i+1] = array[i];
	}
	size = array.length;
	isMax = true;
	heapify();
    }
    public MyHeap(boolean isMax){
	size = 0;
	data = (T[]) new Comparable[6];
	data[0] = null;
	isMax = isMax;
    }
    public MyHeap(T[] array, boolean isMax){
	data = (T[])new Comparable[array.length + 1];
	data[0] = null;
	for(int i = 0; i < array.length; i ++){
	    data[i+1] = array[i];
	}
	size = array.length;
	heapify();
	isMax = isMax;
    
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
	    if( k < size / 2){
		if(getMax()){
	    
		    if(right < size && data[right].compareTo(data[left])>0){
			biggerValueIndex = right;
		    }
		    if(data[k].compareTo(data[biggerValueIndex])<0){
			swap(data,k,biggerValueIndex);
			pushDown(biggerValueIndex);
		    }
		}
    
		else{
		    if(right < size &&data[right].compareTo(data[left])<0){
			biggerValueIndex = right;
		    }
		    if(data[k].compareTo(data[biggerValueIndex])>0){
			swap(data,biggerValueIndex,k);
			pushDown(biggerValueIndex);
		    }
		}
	    }
    }
    private void pushUp(int k){
	if(k != 1){
	    if(getMax()){
		if(data[k].compareTo(data[k/2])>0){
		    swap(data,k,k/2);
		    pushUp(k/2);
		}
	    }
	    else{
		if(data[k].compareTo(data[k/2])<0){
		    swap(data,k,k/2);
		    pushUp(k/2);
		}
	    }	    
	}
    }
    private void heapify(){
	for(int i = size / 2;i > 0 ;i--){
	    pushDown(i);
	}
    }
		      
    public T delete(){
	T temp = data[1];
	data[1] = data[size];
	size --;
	if(size > 1){
	    pushDown(1);
	}
	return temp;
    }
    public void add(T x) {
	if(size == data.length - 1) {
	    doubleSize();
	}
	size++;
	if(size == 1){
	    data[size] = x;
	}
	else{
	    data[size] = x;
	    pushUp(size);
	}
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
    public boolean getMax(){
	return isMax;
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
	h.delete();
	h1.delete();
	System.out.println(h);
	System.out.println(h1);
	MyHeap<Integer> h2 = new MyHeap<Integer>(obj,false);
	MyHeap<Integer> h3 = new MyHeap<Integer>(false);
	//	System.out.println(h1.getMax());
	h3.add(10);
	h3.add(100);
	h3.add(12);
	h3.add(122);
	System.out.println(h2);
	System.out.println(h3);
	h2.delete();
	h3.delete();
	System.out.println(h2);
	System.out.println(h3);
    }

}

