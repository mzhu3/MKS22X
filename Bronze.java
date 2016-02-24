import java.util.*;
import java.io.*;

public class Bronze {
    int[][] area;
    int[][] whereTostomp;
    int E;
    int N;
	
    public Bronze( Scanner in) {
	Scanner firstLine = new Scanner(in.nextLine());
	area = new int[Integer.parseInt(firstLine.next())][Integer.parseInt(firstLine.next())];
	E = Integer.parseInt(firstLine.next());
	N = Integer.parseInt(firstLine.next());
	for (int i = 0; i < area.length; i++) {
	    Scanner rows = new Scanner(in.nextLine());
	    for (int j = 0;j < area[i].length; j++) {
		area[i][j] = Integer.parseInt(rows.next());
	    }
	}
        whereTostomp = new int[N][3];
	for (int i = 0; i < N; i++) {
	    Scanner nextlines = new Scanner(in.nextLine());
	    whereTostomp[i][0] =Integer.parseInt( nextlines.next());
	    whereTostomp[i][1] =Integer.parseInt( nextlines.next());
	    whereTostomp[i][2] =Integer.parseInt( nextlines.next());
	    }
	
    }
	
    public void printArea() {
	for (int row = 0; row < area.length; row++) {
	    for (int col = 0; col < area[0].length; col++) {
		System.out.print(area[row][col] + "\t");
	    }
	    System.out.println();
	}
    }
	
    public int findMaxElevation(int row, int col) {
	int max = 0;
	for (int i = row; i < row+3; i++) {
	    for (int j = col; j < col+3; j++) {
		if (area[i][j] > max) {
		    max = area[i][j];
		}
	    }
	}
	return max;
    }
	
    public void stomp(int row, int col, int depth) {
	int max = findMaxElevation(row,col);
	for (int i = row; i < row+3; i++) {
	    for (int j = col; j < col+3; j++) {
		if (area[i][j] > max - depth) {
		    area[i][j] = max - depth;
		}
	    }
	}
    }

	
    public int solve() {
        for(int i =0; i <N; i++){
	    stomp(whereTostomp[i][0],whereTostomp[i][1], whereTostomp[i][2]);
	}
	int totalDepth = 0;
	for (int i = 0; i < area.length; i++) {
	    for (int j = 0; j < area[0].length; j++) {
		if (E - area[i][j] > 0) {
		    totalDepth += E - area[i][j];
		}
	    }
	}
	return 72 * 72 * totalDepth;
    }

    public static void main(String[] args) {
	try {
	    File f = new File("makelake.in");
	    Scanner in = new Scanner(f);
	    Bronze a = new Bronze(in);
	     System.out.println(a.solve()+"6,Zhu,Matthew");
	}
	catch (FileNotFoundException e) {
	    System.out.println("No such file found");
	}
    }
}
