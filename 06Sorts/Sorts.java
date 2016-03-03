import java.util.Arrays;
public class Sorts{
    public static void printArray(int[]data){
	String ans = "";
	for(int i = 0 ; i < data.length; i ++){
	    ans += data[i] + ", ";
	}
	System.out.println("[" + ans + "]");
       
    }
    public static void insertionSort(int[]data){
	for(int a = 0; a < data.length; a ++){
	    for(int i = 0; i < data.length - 1; i ++){
		int current = i;
		int nextindex = i + 1;
		int position = 0;
		if(data[current] >= data[nextindex] ){
		    int hold = data[current];
		    data[current] = data[nextindex];
		    data[nextindex] = hold;
		}
	    }

	}
    }
    public int min(int[]data){
	int small = data[0];
	for(int i = 0; i < data.length; i ++){
	    if(data[i] <= small){
		small = data[i];
	    }
	}
	return small;
    }
    public static void selectionSort(int[]data){
	int current =0;
	int index = 0;
	int small = data[0];
	int save = 0;
	for( int i =0;i < data.length - 1; i ++){
	    index = i;
	    current = data[index];
	    for(int j = i + 1; j < data.length; j ++){
		if(data[j] < current){
		    index = j;
		    current = data[index];
		}
	    }
	    save = data[index];
	    data[index] = data[i];
	    data[i] = save;
	

	}
    }
    public static void bubbleSort(int[]data){
        boolean sorted = false;
        int[] sortedArray = data.clone();
	Arrays.sort(sortedArray);
	for(int i = 0; i < data.length; i ++){

	    for(int j = 0; j <data.length - 1; j ++){
		if(!sorted && data[j] > data[j+1]){
		    int save = data[j+1];
		    data[j+1] =data[j];
		    data[j] = save;
		}
		if(Arrays.equals(sortedArray, data)){
		    i = data.length;
		    sorted = true;
		}
	    }

	}
	   
    }
    
    public static void swap(int[] ary, int a, int c){
	if(a!=c){
	    int save =ary[c];
	    ary[c] =ary[a];
	    ary[a] = save;
	}
    }
    public static void fillRandom(int[] ary){
	for(int i = 0; i < ary.length; i++){
	    ary[i] = (int)(Math.pow(-1,(int)(Math.random())))*
		(int)(Math.random()*Integer.MAX_VALUE);
	}
    }
 	
}
	    
//help from Billy with optimizing my sort 		    
	    

	


		

