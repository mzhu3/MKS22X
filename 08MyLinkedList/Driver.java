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
		System.out.println("Get: "+LL.get(2));
		System.out.println("set: "+LL.set(3,3));
	 	System.out.println("Set List: "+LL);
		System.out.println("set: "+LL.set(7,3));
		System.out.println("Set List : "+LL);
		System.out.println("Removed: "+LL.remove(2));
		System.out.println("Removed list: "+LL);
		System.out.println("Add : "+LL.add(2,100));
		System.out.println("Add List : "+ LL);
		System.out.println("IndexOf: "+LL.indexOf(999));
			   
	
    }
}
