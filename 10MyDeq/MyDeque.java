import java.util.*;

public class MyDeque<T>{
    private int size;
    private objects[] data;
    private int start;
    private int end;

    public MyDeque(){
	data = new objects[4];
	size = 0;
    }
    private int size(){
	return size;
    }
    private void grow(){
        objects[]temp = new objects[data.size * 2];
	int counter = 0;
	for(int i = 0; i < size(); i ++){
	    if(start != data.size){
		temp[i] = data[start];
		start ++;
	    }
	    temp[i] = data[counter];
	    counter++;
	}
	data = temp;
    }
}
    
