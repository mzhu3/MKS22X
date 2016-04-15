import java.util.Arrays;
public class Driver{
    public static void main(String[] args){
	BetterMaze m = new BetterMaze("data2.dat");
	m.setAnimate(false);

	//	System.out.println(m.startRow);
	//System.out.println(m.startCol);
	if(args.length < 1){
	    // m.clearTerminal();
	    m.solveDFS();
	    m.clearTerminal();
	    //System.out.println(m);
	      System.out.println(m.solutionCoordinates());
	}
	else{
	    //  m.clearTerminal();
	    m.solveDFS();
	    m.clearTerminal();
	    System.out.println(m);
	}
    }
}
