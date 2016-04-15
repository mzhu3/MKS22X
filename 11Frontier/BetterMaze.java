import java.util.*;
import java.io.*;

public class BetterMaze{
    public class Node{
	private Node prev;
	public int[] id;


	public Node(int posx,int posy, Node prev){
	    id = new int[] {posx,posy};
	    this.prev = prev;
	}
	public Node(int posx,int posy){
	    id = new int[] {posx,posy};
	    prev = null;
	}
	public int getValueX(){
	    return id[0];
	}
	public int getValueY(){
	    return id[1];
	}
	public Node getPrev(){
	    return prev;
	}
	public boolean hasPrev(){
	    return prev !=null;
	}
    }

    private char[][] maze;
    private int[]    solution;
    public int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate; //default to false

    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public int[] solutionCoordinates(){
	//System.out.println(!solveDFS());
	return solution;
    }
    
    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){
        placesToGo = new FrontierQueue<Node>();
	return solve();
    }   


    /**initialize the frontier as a stack and call solve
     */ 
    public boolean solveDFS(){  
	placesToGo = new FrontierStack<Node>();
	return solve();
    }    

    /**Search for the end of the maze using the frontier. 
       Keep going until you find a solution or run out of elements on the frontier.
    **/
    public boolean end(Node id){
	return maze[id.getValueX()][id.getValueY()]=='E';
    }
    public ArrayList<Node> getMoves(Node id){
	ArrayList<Node> moves = new ArrayList<Node>();
	//	System.out.println(maze[id.getValueX()-1][id.getValueY()]==' '||maze[id.getValueX()-1][id.getValueY()]=='E');
	//	System.out.println(maze[id.getValueX()+1][id.getValueY()]==' '||maze[id.getValueX()+1][id.getValueY()]=='E');
	//	System.out.println(maze[id.getValueX()][id.getValueY()-1]==' '||maze[id.getValueX()][id.getValueY()-1]=='E');
	//	System.out.println(maze[id.getValueX()][id.getValueY()+1]==' '||maze[id.getValueX()][id.getValueY()+1]=='E');
	if(maze[id.getValueX()-1][id.getValueY()]==' '||maze[id.getValueX()-1][id.getValueY()]=='E'){
	    moves.add(new Node(id.getValueX()+1,id.getValueY(),id));
	}
        if(maze[id.getValueX()+1][id.getValueY()]==' '||maze[id.getValueX()+1][id.getValueY()]=='E'){
	    moves.add(new Node(id.getValueX()+1,id.getValueY(),id));
	}
	if(maze[id.getValueX()][id.getValueY()-1]==' '||maze[id.getValueX()][id.getValueY()-1]=='E'){
	    moves.add( new Node(id.getValueX(),id.getValueY()-1,id));
	}
	if(maze[id.getValueX()-1][id.getValueY()+1]==' '||maze[id.getValueX()-1][id.getValueY()+1]=='E'){
	   moves.add(new Node(id.getValueX(),id.getValueY()+1,id));
	}
	return moves;
    }
    private void getPath(Node id){
	Stack<Node> ans = new Stack<Node>();
	int counter = 0;
	Node current = id;
	while(current.hasPrev()){
	    ans.push(current);
	    counter++;
	    current = current.getPrev();
	}
	solution = new int[counter * 2];
	int counter2 = 0;
	//	System.out.println(ans.empty());
	while(!ans.empty()){
	    Node temp = ans.pop();
	    solution[counter2] = temp.getValueX();
	    //    System.out.println(solution[counter2]);
	    solution[counter2+1] = temp.getValueY();
	    //    System.out.println(solution[counter2]);
	    counter2+=2;
	}
    }
    private boolean solve(){
	int counter = 0;
	Node s = new Node(startRow,startCol);
	placesToGo.add(s);
	//	System.out.println(placesToGo.hasNext());
	while(placesToGo.hasNext()){
	    Node temp = placesToGo.next();
	    maze[temp.getValueX()][temp.getValueY()] = '.';
	    // System.out.println(getMoves(temp).size());
	    ArrayList<Node> posMoves = getMoves(temp);
	    // System.out.println(posMoves);
	    for(int i = 0; i < posMoves.size();i++){
		if(end(posMoves.get(i))){
		    getPath(posMoves.get(i));
		    return true;
		}
		else{
		    placesToGo.add(posMoves.get(i));
		}
	    }
	    if(animate){
		System.out.println(this);
		wait(20);
	    }
	}
	
	return false;
    }    
    
    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
	animate = b;
	/** IMPLEMENT THIS **/ }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    }
}
