import java.util.*;

public class MyDeque<T>{
    private int size;
    private Object[] data;
    private int start;
    private int end;
    private int counter;
    private int counter2;
    public MyDeque(){
	data = new Object[10];
	size = 0;
    }
    public MyDeque(int a){
	data = new Object[a];
	size = 0;
    }
    private int size(){
	return size;
    }
    public String toString(){
	String ans = "[";
	for(int i = 0; i <size; i ++){
		ans += data[i] + " ,";

	}
	ans+="]" + "   size:" + size+ "   start:"+start+"   end:" + end;
	return ans;
    }
	
    private void grow(){
        Object[]temp = new Object[data.length * 2];
	int counter = 0;
	int tempSize = size;
	for(int i = 0; i < size; i ++){
	    if(start != size){
		temp[i] = data[start];
		start ++;
	    }
	    temp[i] = data[counter];
	    counter++;
	}
	data = temp;
	start = 0;
	end = tempSize - 1;
    }
    public void addFirst(T value){
	if(size >= data.length){
	    grow();
	}
	if(start == 0){
	    data[start+ counter] = value;
	    counter++;
	    end = counter - 1;
	}
	else{
	    data[start -1] = value;
	}
	size ++;
    }
    public void addLast(T value){
	if(size >= data.length){
	    grow();
	}
	if(end == data.length - 1){
	    end = 0;
	    data[0] = value;
	}
	else{
	    data[end + counter2+1] = value;
	    counter++;
	    end ++;
	}
	size ++;
    }
    public T removeFirst(){
	if((T)(data[start])==null){
	    throw new NoSuchElementException();
	}
	T temp = (T)(data[start]);
	if(start == data.length - 1){
	    start = 0;
	}
	else{
	    start ++;
	}
	size --;
	return temp;
    }
    public T removeLast(){
	if((T)(data[end])==null){
	    throw new NoSuchElementException();
	}
	T temp = (T)(data[end]);
	if(end ==0){
	    end = data.length - 1;
	}
	else{
	    end --;
	}
	size --;
	return temp;
    }
    public T getFirst(){
	if((T)(data[start])==null){
	    throw new NoSuchElementException();
	}
	return (T)(data[start]);
    }
    public T getLast(){
	if((T)(data[end])==null){
	    throw new NoSuchElementException();
	}
	return (T)(data[end]);
    }
    public static void main(String[]args){
	MyDeque<Integer>deq = new MyDeque<Integer>();
		deq.addFirst(10);
		deq.addFirst(11);
		deq.addFirst(12);
		deq.addFirst(14);
			deq.addLast(1);
		deq.addLast(0);
		deq.addLast(100);
	System.out.println(deq);
		deq.removeFirst();
		deq.removeLast();
	System.out.println(deq);
    }
	
	
}
    
