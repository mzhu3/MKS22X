import java.util.Arrays;
public class QueenBoard{
    private int[][]board;
    public QueenBoard(){
	board = new int[8][8];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j ++){
		board[i][j] = 0;
	    }
	}
    }
    public QueenBoard(int a){
	board = new int[a][a];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j ++){
		board[i][j] = 0;
	    }
	}
    }
    /*   public boolean Solve(){

	 }*/
    public boolean SolveH(int a){
        int queens = 0;
	if(queens = board.length - 1){
	    printBoard();
	    return true;
	}
	for(int i = 0; i < board.length; i ++){
	    
	
    public void addQueen(int x, int y){
	board[x][y] = 1;
	int counter = 1;
	int counter2 = 1;
	for(int a = y + 1; a < board.length;a++){
	    board[x][a]= board[x][a] - 1;
	}
	for(int b = x - 1; b >= 0; b --){
	    board[b][y+counter]= board[b][y+counter]-1;
	    counter ++;
	}
	for(int c = x;c <board.length - 1;c++){
	    board[x+counter2][y+counter2]=board[x+counter2][y+counter2] - 1;
	    counter2 ++;
	}
    }
    public void removeQueen(int x, int y){
	board[x][y] = 0;
	int counter = 1;
	int counter2 = 1;
	for(int a = y + 1; a < board.length; a ++){
	    board[x][a]=board[x][a] + 1;
	}
	for(int b = x - 1 ; b >=0;b --){
	    board[b][y + counter] = board[b][y+counter]+1;
	    counter ++;
	}
	for(int c = x; c <board.length - 1; c ++){
	    board[x+counter2][y+counter2]= board[x+counter2][y+counter2] + 1;
	    counter2 ++;
	}
    }
    public String printBoard(){
	String result = "";
	for(int i = 0; i < board.length; i ++){
	    for(int j = 0; j <board[i].length; j++){
		result += Integer.toString(board[i][j])+ "\t";
	    }
	    result += "\n";
	}
	return result;
    }
    
    public static void main(String[]args){
	QueenBoard hq = new QueenBoard(10);
	hq.addQueen(5,2);
	System.out.println(hq.printBoard());
	hq.removeQueen(5,2);
	System.out.println(hq.printBoard());
    }
}
    
	
	    
	    
	    
	    
    
