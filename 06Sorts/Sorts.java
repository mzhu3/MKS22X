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
		(int)(Math.random()*10);
	}
    }
    public static int[] mergeSort(int[]data) {
	if(data.length ==1){
	    return data;
	}
	else if(data.length %2 ==0){
	    int[]data1 = new int[data.length/2];
	    for(int i = 0; i <data.length/2; i ++){
		data1[i] = data[i];
	    }
	    int[]data2 = new int[data.length/2 ];
	    for(int a = 0;a < data.length/2; a++){
		data2[a] = data[a+(data.length/2)];
	    }
	    return merge(mergeSort(data1),mergeSort(data2));
	}
	else{
	    int counter = 0;
	    int[]data1 = new int[data.length/2];
	    for(int i = 0; i <data.length/2; i ++){
		data1[i] = data[i];
	    }
	    int[]data2 = new int[(data.length/2) +1];
	    for(int a = (data.length/2);a < data.length; a++){
		data2[counter] = data[a];
		counter++;
	    }
	    return merge(mergeSort(data1),mergeSort(data2));
	}
    }



    public static void mergesort(int[]data){
	int[]tempAry = new int[data.length];
	tempAry = mergeSort(data);
        for(int i = 0;i< data.length; i++){
	    data[i]= tempAry[i];
	}
	
	
	
	
    }
	    
  
    public static int[] merge(int[]data,int[]data2) {
	int start1 = 0;
	int start2 = 0;
	int left = 0;
	int[]newAry = new int[data.length+data2.length];
	while(start1 <data.length  && start2 < data2.length){
	    if(data[start1] < data2[start2]){
		newAry[left] = data[start1];
		start1++;
		left++;
		//	printArray(newAry);

	    }
	    else{
		newAry[left] = data2[start2];
		start2++;
		left++;
		//	printArray(newAry);
	    }

	}
	if(start1 <data.length ){
	    for(int i = start1; i <data.length;i++){
		newAry[left] = data[start1];
		left++;
		start1++;
	    }
	    //   printArray(newAry);
	}
	if(start2 <data2.length){
	    for(int j = start2; j < data2.length; j++){
		newAry[left] = data2[start2];
		left++;
		start2++;
	    }
	    //  printArray(newAry);
	}
	//	printArray(data);
	//	printArray(newAry);
	return newAry;
    }
    public static String name(){
	return "6,Zhu,Matthew";
    }
    public static void main(String args[]){
	int[] a1 = new int[3];

	int[] a2 = new int[2];
	int[] a3 = new int[4];
	int[] a4 = new int[5];
	fillRandom(a1);
	mergesort(a1);
		printArray(a1);
	fillRandom(a2);
	mergesort(a2);
		printArray(a2);
	fillRandom(a3);
	mergesort(a3);
		printArray(a3);
	fillRandom(a4);
	mergesort(a4);
		printArray(a4);
    }
	    

}

	    
//help from Billy with optimizing my sort
//Help from Anthony with Merge; the part with merging two arys of varying lengths!
	


		

