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
    public static void mergeSort(int[]data) {
	int [] newAry = mergeHelper(data);
	for (int i = 0; i < data.length; i++) {
	    data[i] = newAry[i];
	}

    }


    public static int[] mergeHelper(int[]data) {
	if (data.length == 1) {
	    return data;
	}
	int start1 = 0;
	int end1 = (data.length/2);
	int start2 = end1;
	int end2 = data.length;
	int counter = 0;
	int[]m1 = new int[end1];
	for(int i = 0; i < m1.length; i ++){
	    m1[i] = data[1];
	}
	int[]m2 = new int[data.length - start2];
	for(int a = start2;a < data.length; a ++){
	    m2[counter]=data[a];
	    counter++;
	}
        int [] newAry= merge(mergeHelper(m1),mergeHelper(m2));;
	
	return newAry;
	
    }

    public static int[] merge(int[]data1,int[]data2) {
	int [] newAry = new int[2 * data1.length];
	int start1 = 0;
	int end1 = data1.length;
	int end2 = data2.length;
	int start2 = 0;
	int maxL = Math.max(data1.length, data2.length);
	int minL = Math.min(data1.length, data2.length);
	int left = 0;
	for (int i = 0; i < newAry.length && start1 < minL && start2 < minL; i++) {
	    if (data1[start1] > data2[start2]) {
		newAry[i] = data2[start2];
		start2++;
		left++;
	    }
	    else {
		newAry[i] = data1[start1];
		start1++;
		left++;
	    }
	}
	int lastI;
	if(start1 < data1.length){
	    lastI = start1;
	    for (int j = lastI; j < data1.length; j++) {
		newAry[left] = data1[j];
		left++;
	    }
	}
	if(start2 <data2.length){
	    lastI = start2;
	    for(int k = lastI;k <data2.length; k++){
		newAry[left] = data2[k];
		left++;
	    }
	}
	return newAry;
    }
}
	    
//help from Billy with optimizing my sort
//Help from Anthony with Merge; the part with merging two arys of varying lengths!
	


		

