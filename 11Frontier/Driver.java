import java.util.Arrays;
public class Driver{
    public static void main(String[] args){
	BetterMaze m = new BetterMaze("data1.dat");
	m.setAnimate(true);
	System.out.println(m.startRow);
	System.out.println(m.startCol);
	if(args.length < 1){
	    m.solveBFS();
	    
	}
	else{
	    m.solveDFS();
	}
    }
}
