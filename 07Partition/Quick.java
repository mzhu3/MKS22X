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
    private static int[] partition(int[]data, int left, int right){
	Random rand = new Random();
	int index = rand.nextInt((right - left) + 1)+left;
	int counter = 0;
	int[]values = new int[2];
	if(left == right){
	    values[0] = left;
	    values[1] = right;
	    return values ;
	}
	int save = data[index];
	int saveIndex =right-1;
	int saveIndexL = left;
	int pivSpot = 0;
	swap(data,index,right);
	right --;
	while(left <= right){
	    if(data[left] ==save){
	        left++;
		counter++;
	    }
	    if(data[left] < save){
		pivSpot++;
		left++;
	    }
	    else{
		swap(data,left,right);
		right --;
	    }
	}
	int savePivSpot = pivSpot;
	while(counter > 0){
	    data[pivSpot]=save;
	    pivSpot++;
	    saveIndex++;
	    counter--;
	}
	values[0]=savePivSpot+saveIndexL;
	values[1]=saveIndex+saveIndexL;
	return values;
    }
    public static int quickselect(int[]data, int k){
	int upmost = data.length -1;
	return quickselect(data,k,0,upmost);
    }
    private static int quickselect(int[]data, int k, int left, int right){
	int[] index = partition(data,left,right);
	if(left ==right){
	    return data[left];
	}
        if(index[0] < k){
	    return quickselect(data,k,index[0]+1 ,right);
	}
	else{
	    return quickselect(data,k,left,index[1]-1);
	}

    }
    public static String name(){
	return "6,Zhu,Matthew";
    }
    
    public static void quickSort(int[]data){

	quickSort(data,0,data.length-1);
    }
    public static void quickSort(int[]data,int left,int right){
	if(left < right){
	    int[]  index = partition(data,left,right);
	    System.out.println( Arrays.toString(data));
	    quickSort(data,left,index[0]-1);
	    quickSort(data,index[1]+1,right);
	}
    }
    private static int partitionOld(int[]data, int left, int right){
	Random rand = new Random();
	int index = rand.nextInt((right - left) + 1)+left;
	if(left == right){
	    return left;
	}
	int save = data[index];
	int saveIndex =right;
	swap(data,index,right);
	right --;
	while(left < right){
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
    public static int quickselectOld(int[]data, int k){
	int upmost = data.length -1;
	return quickselect(data,k,0,upmost);
    }
    private static int quickselectOld(int[]data, int k, int left, int right){
	int index = partitionOld(data,left,right);
	if(left ==right){
	    return data[index];
	}
        if(index < k){
	    return quickselectOld(data,k,index+1 ,right);
	}
	else{
	    return quickselectOld(data,k,left,index-1);
	}

    }
    public static void main(String[]args){
	int[] ary = {0,1,2,3,4};
	int[]ary2 = {-3,13,4,12,2};
	int[]ary3 = {0,1,2,0,1,2};
	 quickSort(ary3);
		System.out.println(Arrays.toString(ary3));
    }
	
}
	
