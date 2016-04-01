import java.util.*;

public class MyDeque<T>{
    private int size;
    private Object[] data;
    private int start;
    private int end;

    public MyDeque(){
	data = new Object[4];
	size = 0;
    }
    private int size(){
	return size;
    }
    private void grow(){
        Object[]temp = new Object[size() * 2];
	int counter = 0;
	for(int i = 0; i < size(); i ++){
	    if(start != size){
		temp[i] = data[start];
		start ++;
	    }
	    temp[i] = data[counter];
	    counter++;
	}
	data = temp;
    }
    public void addFirst(T value){
	
}
    
