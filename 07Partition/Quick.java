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
    public static int getArrayIndex(int[] data,int value) {
        int k=0;
        for(int i=0;i<data.length;i++){
            if(data[i]==value){
                k=i;
            }
        }
    return k;
}
    private static int partition(int[]data, int left, int right){
	Random rand = new Random();
	int index = rand.nextInt((right - left) + 1)+left;
	if(left == right){
	    return left;
	}
	int save = data[index];
	int saveIndex =right;
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
	    swap(data,right+1,saveIndex);
	}
	else{
	    swap(data,left,saveIndex);
	}
	return getArrayIndex(data,save);
    }
    public static int quickselect(int[]data, int k){
	int upmost = data.length -1;
	return quickselect(data,k,0,upmost);
    }
    private static int quickselect(int[]data, int k, int left, int right){
	int index = partition(data,left,right);
	if(left ==right){
	    return data[index];
	}
        if(index < k){
	    return quickselect(data,k,index+1 ,right);
	}
	else{
	    return quickselect(data,k,left,index-1);
	}

    }
    public static String name(){
	return "6,Zhu,Matthew";
    }
	
    public static void main(String[]args){
	int[] ary = {0,1,2,3,4};
	int[]ary2 = {-3,13,4,12,2};
	System.out.println(quickselect(ary2,2));
	System.out.println(quickselect(ary2,4));
    }
	
}
	
