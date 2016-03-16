public class Driver{
    public static void main(String[]args){
	MyLinkedList LL = new MyLinkedList();
	System.out.println(LL);
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
	//	System.out.println(LL.get(2));
	//	System.out.println(LL.set(3,3));
	// 	System.out.println(LL);
	//	System.out.println(LL.set(7,3));
	//	System.out.println(LL);
	//	System.out.println(LL.remove(2));
	//	System.out.println(LL);
	//	System.out.println(LL.add(2,100));
	//	System.out.println(LL.toString());
	System.out.println(LL.indexOf(999));
			   
	
    }
}
