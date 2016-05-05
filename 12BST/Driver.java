public class Driver{
    public static void main(String[]args){
	BSTree<Integer> tree = new BSTree<Integer>();
	System.out.println(tree);
	tree.add(0);
	System.out.println(tree);
	tree.add(10);
	System.out.println(tree);
	tree.add(4);
	System.out.println(tree);
	tree.add(-2);
	System.out.println(tree);
	tree.add(-99);
	tree.add(0);
	tree.add(100);
	System.out.println(tree);
	System.out.println(tree.contains(7));
	System.out.println(tree.contains(100));
	System.out.println(tree.contains(-99));
	System.out.println(tree);
    }
}
