import java.util.Arrays;
import java.util.*;
public class Driver{
    public static void main(String[]args){
        MyLinkedList<String> m = new MyLinkedList<String>();
	ArrayList<String>    n = new ArrayList<String>();
	System.out.println(m);
	m.add("0");
	System.out.println(m);
	m.add("2311");
	System.out.println(m);
	m.add("23");
	System.out.println(m);
	m.set(2,"33");
	System.out.println(m);
	m.set(1,"122");
	System.out.println(m);
	m.add("231");
	System.out.println(m);
	m.add("41");
	System.out.println(m);
	m.add("13");
	System.out.println(m);
	m.add("2");
	System.out.println(m);
	m.remove(2);
	System.out.println(m+" Removed");
	m.get(1);
	
    }
}
	/*test speed of add in front and at end.
	long start,end;
	System.out.println("Add 100k to front");

	start = System.currentTimeMillis();
	for(int i = 0; i < 100000; i++)
	n.add(0,""+i);
	end = System.currentTimeMillis();
	System.out.println( "ArrayList "+(end-start)/1000.0 );

	start = System.currentTimeMillis();
	for(int i = 0; i < 100000; i++)
	m.add(0,""+i);
	end = System.currentTimeMillis();
	System.out.println( "LinkedList "+(end-start)/1000.0 );


	System.out.println("Add 1m to end");

	start = System.currentTimeMillis();
	for(int i = 0; i < 1000000; i++)
	n.add(""+i);
	end = System.currentTimeMillis();
	System.out.println( "ArrayList "+(end-start)/1000.0 );

	start = System.currentTimeMillis();
	for(int i = 0; i < 1000000; i++)
	m.add(""+i);
	end = System.currentTimeMillis();
	System.out.println( "LinkedList "+(end-start)/1000.0 );
	*/

