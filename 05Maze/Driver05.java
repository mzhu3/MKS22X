public class Driver05{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data2.dat",true);//true animates the maze.
        
        //f.clearTerminal();
	// f.solve();
	System.out.println(f.maze[0].length);
	System.out.println(f.maze.length);
	// f.clearTerminal();
	// System.out.println(f);
    }
}

