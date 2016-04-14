import java.util.Arrays;
public class Driver{
    public static void main(String[] args){
	BetterMaze m = new BetterMaze("data1.dat");
	m.setAnimate(true);

	//	System.out.println(m.startRow);
	//System.out.println(m.startCol);
	if(args.length < 1){
	    m.clearTerminal();
	    m.solveBFS();
	    m.clearTerminal();
	    System.out.println(m);
	}
	else{
	    m.clearTerminal();
	    m.solveDFS();
	    m.clearTerminal();
	    System.out.println(m);
	}
    }
}
