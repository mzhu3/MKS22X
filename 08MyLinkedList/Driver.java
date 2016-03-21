import java.util.Arrays;
import java.util.*;
public class Driver{
    public static void main(String[]args){
	MyLinkedList LL = new MyLinkedList();
	MyLinkedList m = new MyLinkedList();
	ArrayList<Integer> n = new ArrayList<Integer>();
	long start,end;
	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	n.add(10);
	end = System.currentTimeMillis();
	System.out.println("Time add: " + (end-start)/1000.0 + " seconds for ArrayList");

	start = System.currentTimeMillis();
        //same code to test here on linked list m
	m.add(10);
	end = System.currentTimeMillis();
	System.out.println("Time add: " + (end-start)/1000.0 + " seconds for MyLinkedList");
	/*	System.out.println(LL);
	LL.add(0);
	System.out.println(LL);
	LL.add(3);
	System.out.println(LL);
	LL.add(4);
	System.out.println(LL);
	LL.add(10);
	System.out.println(LL);
	LL.add(100);
	LL.add(122);
	System.out.println(LL);
	System.out.println("Get: "+LL.get(2));
	System.out.println("set: "+LL.set(3,3));
	System.out.println("Set List: "+LL);
	System.out.println("set: "+LL.set(7,3));
	System.out.println("Set List : "+LL);
	System.out.println("Removed: "+LL.remove(2));
	System.out.println("Removed list: "+LL);
	System.out.println("Add : "+LL.add(2,100));
	System.out.println("Add List : "+ LL);
	System.out.println("IndexOf: "+LL.indexOf(999));*/
			   
	
    }
}
