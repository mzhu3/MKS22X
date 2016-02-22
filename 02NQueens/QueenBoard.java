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
    public boolean solve(){
	if( solveH(0)){
	    System.out.println( printSolution());
	    return true;
	}
	System.out.println(printSolution());
	return false;
    }

    private boolean solveH(int col){
	if(col>=board.length){
	    printBoard();
	    return true;
	}
	int a = 0;
	while(a < board.length){
	    if (addQueen(a,col)){
		if (solveH(col+1)){
		    printBoard();
		    return true;
		}else{
		    removeQueen(a,col);
		}
	    }
	    a ++;
	}
	return false;
    }
	    
	
    public boolean addQueen(int x, int y){
	if(board[x][y] !=0){
	    return false;
	}
	board[x][y] = 1;
	int counter = 1;
	int counter2 = 1;
	for(int a = y + 1; a < board[x].length;a++){
	    board[x][a]= board[x][a] - 1;
	}
        while(y+counter < board.length){
	    if(x-counter >=0){
		board[x-counter][y+counter]= board[x-counter][y+counter]-1;
	    }
	    counter ++;

	}
	while(y+counter2 <board.length){
	    if(x+counter2 < board.length){
		board[x+counter2][y+counter2]=board[x+counter2][y+counter2] - 1;
	    }
	    counter2++;
	}
	return true;
    }
    public boolean removeQueen(int x, int y){
	if(board[x][y]!=1){
	    return false;
	}
	board[x][y] = 0;
	int counter = 1;
	int counter2 =1;
	for(int a = y + 1; a < board[x].length; a ++){
	    board[x][a]=board[x][a] + 1;
	}
	while(y+counter < board.length){
	    if(x-counter >=0){
		board[x-counter][y+counter]= board[x-counter][y+counter]-1;
	    }
	    counter ++;

	}

    
	while(y+counter2 <board.length){
	    if(x + counter2 < board.length)
		board[x+counter2][y+counter2]= board[x+counter2][y+counter2] + 1;
	    counter2++;
	}

    
	return true;
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
    public void printSolution(){
	String result ="";
	for(int i =0;i<board.length; i++){
	    for(int j = 0; j<board[i].length; j++){
		if(board[i][j] == 1){
		    result+="Q" +"\t";
		}
		else{
		    result+="_"+"\t";
		}
	    }
	    result+="\n";
	}
	System.out.println(result);
    }
    public static void main(String[]args){
	QueenBoard hq = new QueenBoard(5);
	System.out.println(hq.solve());
    }
}

    
	
	    
	    
	    
	    
    
