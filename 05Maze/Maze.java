import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private int startx,starty;
    private boolean animate;

    public Maze(String filename, boolean ani){
        //COMPLETE CONSTRUCTOR
	try{
	    File map = new File(filename);
	    Scanner inr = new Scanner(map);
	    String SingleMap = "";
	    int row = 0;
	    int col = 0;
	    int mazex = 0;
	    int mazey = 0;
	    while(inr.hasNextLine()){
		row ++;
		String firstLine = inr.nextLine();
		col = firstLine.length();
		SingleMap += firstLine;
	    }
	    maze = new char[row][col];
	    mazex = row;
	    mazey = col;
	    int x = 0;
	    int y = 0;
	    for(int i = 0; i < mazex * mazey; i ++){
		if(i % col == 0 && i != 0){
		    x ++;
		    y = 0;
		}
		maze[x][y] = SingleMap.charAt(i);
	    }
	    for(int a = 0;a <maze.length;a ++){
		for(int b = 0; b <maze[a].length; b ++){
		    if(maze[a][b] == 'S'){
			startx = a;
			starty = b;
		    }
		}
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
    }


    /*Main Solve Function

      Things to note:
      When no S is contained in maze, print an error and return false.
    */
    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'

    */
    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            wait(20);
        }
	if(maze[x][y] == 'E'){
	    return true;
	}
	if(maze[x][y] == ' '){
	    maze[x][y] = '@';
	    if ( x == 0){
		if(solve(x, y + 1)||
		   solve(x , y - 1)||
		   solve(x + 1, y)){
		    return true;
		}
	    }
	    if(y == 0){
		if(solve(x, y + 1)||
		   solve(x+1, y)||
		   solve(x-1, y)){
		    return true;
		}
	    }
	    if(x == maze.length){
		if(solve(x, y + 1)||
		   solve(x, y - 1)||
		   solve(x-1,y)){
		    return true;
		}
	    }
	
	    if(y == maze[0].length){
		if(solve(x, y - 1)||
		   solve(x+1,y)||
		   solve(x-1,y)){
		    return true;
		}
	    }
	    if(solve(x+1,y)||
	       solve(x,y+1)||
	       solve(x-1,y)||
	       solve(x,y-1)){
		return true;
	    }
	
	    else{
		maze[x][y] = '.';
		return false;
	    }
	}

	//COMPLETE SOLVE

	return false; //so it compiles
    }
    



    //FREE STUFF!!! *you should be aware of this*


    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }


    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";
	if(animate){

            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";

        }
        for(int i = 0; i < maxx * maxy; i++){
            if(i % maxx == 0 && i != 0){
                ans += "\n";
            }
            char c =  maze[i % maxx][i / maxx];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(32,40)+c;
            }
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }


    //MORE FREE STUFF!!! *you can ignore all of this*

    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }


    

    //END FREE STUFF



}
