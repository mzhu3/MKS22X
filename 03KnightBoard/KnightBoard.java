public class KnightBoard{
    private int[][]board;
    private int position; 
    public KnightBoard(){
	board = new int[12][12];
	position = 0;
	for(int i = 0; i<board.length;i++){
	    int row =i ;
	    for(int j = 0; j <board[i].length;j++){
		int col =j;
		if(row < 2||
		   col < 2||
		   row >board.length - 3||
		   col > board.length - 3){
		    board[i][j]= -1;
		}
		else{
		    board[i][j] = 0;
		}	
	    }
	}
    }
    
    public KnightBoard(int a, int b){
	position = 0;
	board = new int[a+4][b+4];
	for(int i = 0; i<board.length;i++){
	    int row =i ;
	    for(int j = 0; j <board[0].length;j++){
		int col =j;
		if(row < 2||
		   col < 2||
		   row >=board.length - 2||
		   col >= board[0].length - 2){
		    board[i][j]= -1;
		}
		else{
		    board[i][j] = 0;
		}	
	    }
	}
    }
    public KnightBoard(int s){
	position = 0;
	board = new int[s+4][s+4];
	for(int i = 0; i<board.length;i++){
	    int row =i ;
	    for(int j = 0; j <board[i].length;j++){
		int col =j;
		if(row < 2||
		   col < 2||
		   row >board.length - 3||
		   col > board.length - 3){
		    board[i][j]= -1;
		}
		else{
		    board[i][j] = 0;
		}	
	    }
	}
    }
    public boolean solve(){
        for(int i = 2; i < board.length-2; i ++){
	    for(int j = 2; j < board[0].length-2; j++){
		if(solveH(i,j)){
		    return true; 

		}
	    }
	}
	return false;
    }
		    
   
    public boolean solveH(int a,int b){

	if(board[a][b]!=0){
	    return false;
	}

	board[a][b] = ++ position; 

	if(position == (board[0].length-4) *( board[0].length-4)){
	    return true;
	}
	if(solveH(a-2,b-1)){
	    return true;
	}
        if(solveH(a-2,b+1)){
	    return true;
	}
        if(solveH(a-1,b+2)){
	    return true;
	}
        if(solveH(a+1,b+2)){
	    return true;
	}
        if(solveH(a+2,b+1)){
	    return true;
	}
        if(solveH(a+2,b-1)){
	    return true;
	}
        if(solveH(a+1,b-2)){
	    return true;
	}
        if(solveH(a-1,b-2)){
	    return true;
	}
	    board[a][b] = 0;
	    position --;
	return false;
    }
	
	
    public String printBoard(){
	String result = "";
	for(int i = 0; i <board.length; i++){
	    for(int j = 0; j<board[i].length; j ++){
		result+=Integer.toString(board[i][j])+"\t";
	    }
	    result+="\n";
	}
	return result;
    }

    public void printSolution(){
	String ans = "";
	    for(int i =2;i<board.length-2;i++){
		for(int j =2;j<board[0].length-2;j++){
		    if(board[i][j]==0){
			ans += " _ ";
		    }else{
			ans += " "+board[i][j]+" ";
		    }
		}
		ans += "\n";
	    }
	    System.out.println(ans);
	}

    public static void main(String args[]){
	KnightBoard kq = new KnightBoard(6);
	//  kq.solve();
	//	kq.printSolution();
	KnightBoard kk = new KnightBoard(5,6);
	System.out.println(kk.printBoard());
	kk.solve();
	kk.printSolution();
    }
}
	    
	
