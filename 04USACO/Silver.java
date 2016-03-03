import java.util.*;
import java.io.*;

public class Silver{
    private int[][]board;
    private int[][]boardC;
    private int lengthMoves,startx,starty,endx,endy;
    public Silver(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    int row = in.nextInt();
	    int col = in.nextInt();
	    lengthMoves = in.nextInt();
	    board = new int[row][col];
	    boardC = new int[row][col];
	    for(int i = 0; i < row; i++){
		String elementLine = in.next();
		for(int j = 0; j < col; j++){
		    if(elementLine.charAt(j)=='.'){
			board[i][j] = 0;
		    }
		    else{
			board[i][j] = -1;
		    }
		}
	    }
	    startx = in.nextInt()- 1;
	    starty = in.nextInt()- 1;
	    endx = in.nextInt()- 1;
	    endy = in.nextInt()- 1;
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
    }
    public String toString(){
	String ans = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		ans += board[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    public int Solve(){
	board[startx][starty] = 1;
	for(int c = 0; c < lengthMoves; c++){
	    for(int j = 0; j < board.length; j ++){
		for(int k = 0; k < board[j].length; k++){
		    if(board[j][k] != -1){
			int PMoves = 0;
			if(j-1 >=0 && board[j-1][k]!=-1){
			    // board[j-1][k]+=board[j][k];
			    PMoves += board[j-1][k];
			}
			if(j+1 < board.length && board[j+1][k]!=-1){
			    //  board[j+1][k] +=board[j][k];
			    PMoves += board[j+1][k];
			}
			if(k-1 >= 0 && board[j][k-1]!=-1){
			    // board[j][k-1]+=board[j][k];
			    PMoves += board[j][k-1];
			}
			if(k+1 < board[j].length && board[j][k+1]!= -1){
			    //  board[j][k+1] += board[j][k];
			      PMoves += board[j][k+1];
			}
			boardC[j][k] = PMoves;
		    }
		    else{
			boardC[j][k] = -1;
		    }
		}
	    }
	    
	    convert();
	}
	   
	return boardC[endx][endy];
    }

    public void convert(){
	for(int a = 0; a < board.length; a ++){
	    for(int b = 0; b < board[a].length; b++){
		board[a][b] = boardC[a][b];
	    }
	}
    }
  
    public static void main(String[]args){
	Silver s = new Silver("ctravel.in");
	System.out.println(s.Solve()+",6,Zhu,Matthew");
    }
}
	
			
			    
//Help from Alvin Zhu with Solve method *
//Help from Kevin Zhange with the Solve method as well for creating a 2nd board and using a variable to keep track of the number of moves **
