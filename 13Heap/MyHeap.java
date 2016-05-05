import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;

    public MyHeap(){
	
    }
    public MyHeap(T[] array){
    }
    private void swap(T[] items, int a, int b){
	T temp = items[a];
	items[a] = items[b];
	items[b] = items[a];
    }
    private void pushDown(int k){
	T value = data[k];
	if(k > size / 2){
	    throw new Exception("No Children");
	}
	while(k < size / 2){
	if(data[k].compareTo(data[(k*2]) < 0){
		swap(data,k,k*2);
		k = k/2;
	    }
	        
    }
    private void pushUp(int k){}
    private void heapify(){}
    public T delete(){}
    public void add(T x){}
    private void doubleSize(){}
    public String toString(){}

    //do this last
    public MyHeap(boolean isMax){}
    public MyHeap(T[] array, boolean isMax){}

}
