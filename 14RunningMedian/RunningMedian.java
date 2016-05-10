import java.util.*;
public class RunningMedian{
    double median;
    MyHeap<Integer> minHeap;
    MyHeap<Integer> maxHeap;
    
    public RunningMedian(){
	median = 0;
	minHeap = new MyHeap<Integer>(false);
	maxHeap = new MyHeap<Integer>(true);

    }
    public double getMedian(){
	if(minHeap.getSize() == 0 && maxHeap.getSize() == 0){
	    throw new NoSuchElementException();
	}
	return median;
    }
    public void add(Integer x){
	if(minHeap.getSize() == 0 && maxHeap.getSize() == 0){
	    median =(double) x;
	}
	else{
	    if((double)x < median){
		minHeap.add(x);
	    }
	    else{
		maxHeap.add(x);
	    }
	}
	if(minHeap.getSize()-MaxHeap.getSize()>1){
	    
