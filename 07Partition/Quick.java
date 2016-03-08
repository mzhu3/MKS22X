import java.util.*;
import java.util.Arrays;
public class Quick{
    public static void swap(int[]data,int a, int b){
	if(data[a] !=data[b]){
	    int save = data[a];
	    data[a] = data[b];
	    data[b] = save;
	}
    }
    private static int partition(int[]data, int left, int right){
	Random rand = new Random();
	int index = rand.nextInt((right - left) + 1)+left;
	if(left == right){
	    return left;
	}
	int save = data[index];
	swap(data,index,right);
	right --;
	while(left != right){
	    if(data[left] < save){
		left++;
	    }
	    else{
	    swap(data,left,right);
	    right --;
	    }
	}
	if(data[left] < save){
	    swap(data,right+1,java.util.Arrays.asList(data).indexOf(save));
	}
	else{
	    swap(data,left,java.util.Arrays.asList(data).indexOf(save));
	}
	return java.util.Arrays.asList(data).indexOf(save);
    }
}
	
