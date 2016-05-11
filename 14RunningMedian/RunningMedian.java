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
	    minHeap.add(x);
	}
	else{
	    if((double)x < median){
		maxHeap.add(x);
		balance();
	    }
	    else{
		minHeap.add(x);
		balance();
	    }
	}
    }
    public void balance(){
	//	System.out.println(minHeap.getSize());
	//	System.out.println(maxHeap.getSize());
	if(minHeap.getSize()-maxHeap.getSize()>1 || maxHeap.getSize()-minHeap.getSize() > 1){
	    if(minHeap.getSize()>maxHeap.getSize()){
		int dif =( minHeap.getSize() - maxHeap.getSize())/2;
		//	System.out.println(dif);
		while(dif >= 1){
		    Integer minValue = minHeap.delete();
		    maxHeap.add(minValue);
		    dif--;
		}
	    }
	    else{
		int dif =( maxHeap.getSize()-minHeap.getSize())/2;
		//	System.out.println(dif);
		while(dif >= 1){
		    Integer maxValue = maxHeap.delete();
		    minHeap.add(maxValue);
		    dif--;
		}
	    }
	}
	//	System.out.println(minHeap.getSize());
	//	System.out.println(maxHeap.getSize());
        int totalNums = maxHeap.getSize() + minHeap.getSize();
	if(totalNums %2 == 0){
	    median =(maxHeap.peek()+minHeap.peek())/2.0;
	}
	else{
	    median = (double)maxHeap.peek();
	}
    }

    public static void main(String[] args){
	RunningMedian rm = new RunningMedian();
	rm.add(100);
	System.out.println(rm.getMedian());
	rm.add(12);
	rm.add(9);
	rm.add(200);
	rm.add(50);
	System.out.println(rm.getMedian());
	rm.add(33);
	rm.add(66);
	rm.add(3);
	System.out.println(rm.getMedian());
    }
}
					 
	    
