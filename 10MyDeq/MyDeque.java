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
	start = 0;
	end = data.length - 1;
	size = 0;
    }
    public MyDeque(int a){
	data = new Object[a];
	start = 0;
	end = data.length - 1;
	size = 0;
    }
    public int size(){
	return size;
    }
    public String toString(){
	int counter = start;
	int counter2 = end;
	String ans = Arrays.toString(data);
	String ans2 = "[";
	ans+= "   size:" + size+ "   start:"+start+"   end:" + end;
	/*	while(counter <= end && counter < data.length){
		if(counter==end){
		ans2+=""+data[counter];
		}
		else{
		ans2+=""+data[counter]+" ,";
		}
		counter++;
		}
		if(end < start){
		while(counter2 < start){
		if(counter2==end){
		ans2+=""+data[counter2];
		}
		else{
		ans2+=""+data[counter2]+" ,";
		}
		counter2++;
		}
		}
		ans2+= "]" +"  size:" + size+ "   start:"+start+"   end:" + end;*/
	String finalAns = ans+"\n"+ans2;
	return finalAns;
    }

    private void grow(){
	Object[]temp = new Object[data.length * 2];
	int counter = start;
	int tempSize = size;
	int counter2 = end;
        int arrayCounter = 0;
	while(counter <= end && counter <data.length){
	    temp[arrayCounter] = data[counter];
	    counter++;
	    arrayCounter++;
	}
	if(end<start){
	    while(counter2<start){
		if(counter2 ==end){
		    temp[arrayCounter] = data[counter2];
		}
		counter++;
		arrayCounter++;
	    }
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
	    data[end+1] = value;
	    counter++;
	    end ++;
	}
	size ++;
    }
    public T removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	T temp = (T)(data[start]);
	if(start == data.length - 1 ){
	    start = 0;
	}
	else{
	    start++;
	}
	size --;
	return temp;
    }
    public T removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	T temp = (T)(data[end]);
	if(end ==0){
	    end = data.length - 1;
	}
	else{
	    end--;
	}
	size --;
	return temp;
    }
    public T getFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return (T)(data[start]);
    }
    public T getLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return (T)(data[end]);
    }
    public static void main(String[]args){
	MyDeque<Integer>deq = new MyDeque<Integer>();
	deq.addFirst(10);
	deq.addLast(11);
	deq.addFirst(12);
	deq.addFirst(14);
	deq.addLast(1);
	deq.addLast(0);
	deq.addLast(100);
	System.out.println(deq);
	System.out.println("removed front: "+ deq.removeFirst());
	System.out.println("removed back: "+deq.removeLast());
	System.out.println(deq);
	System.out.println("Front element: "+deq.getFirst());
    }
	
}
       
