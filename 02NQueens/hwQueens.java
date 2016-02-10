import java.util.Arrays;
public class hwQueens{
    int[][]board;
    public hwQueens(){
	board = new int[8][8];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j ++){
		board[i][j] = 0;
	    }
	}
    }
    public hwQueens(int size){
	board = new int[size][size];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[j].length; j ++){
		board[i][j] = 0;
	    }
	}
    }
    public boolean Solve(){
	int queens = board[0].length;
	if(queens == 0){
	    printBoard();
	    return true;
	}
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
		result += Integer.toString(board[i][j])+ " ";
	    }
	    result += "\n";
	}
	return result;
    }
    
    public static void main(String[]args){
	hwQueens hq = new hwQueens();
		hq.addQueen(5,2);
	System.out.println(hq.printBoard());
	hq.removeQueen(5,2);
	System.out.println(hq.printBoard());

    }
}
	
	    
	    
	    
	    
    
