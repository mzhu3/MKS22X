import java.util.*;
import java.io.*;

public class Bronze {
    int[][] area;
    int[][] whereTostomp;
    int Elevation;
    int NumberOfStomps;
	
    public Bronze( Scanner in) {
	area = new int[Integer.parseInt(in.next())][Integer.parseInt(in.next())];
	Elevation = Integer.parseInt(in.next());
	NumberOfStomps = Integer.parseInt(in.next());
	for (int i = 0; i < area.length; i++) {
	    for (int j = 0;j < area[i].length; j++) {
		area[i][j] = Integer.parseInt(in.next());
	    }
	}
	whereTostomp = new int[NumberOfStomps][3];
	for (int i = 0; i < NumberOfStomps; i++) {
	    for (int j = 0; j < 3; j++) {
		whereTostomp[i][j] = Integer.parseInt(in.next());
	    }
	}
    }
    /*	
    public void printArea() {
	for (int row = 0; row < area.length; row++) {
	    for (int col = 0; col < area[0].length; col++) {
		System.out.print(area[row][col] + "\t");
	    }
	    System.out.println();
	}
    }
    public void printStomps(){
	for(int i = 0; i <whereTostomp.length; i++){
	    for(int j = 0; j < 3; j ++){
		System.out.print(whereTostomp[i][j] +"\t");
	    }
	    System.out.println();
	}
    }
    */
     public int calcVolume() {
	for(int i =0; i <NumberOfStomps; i++){
	    stomp(whereTostomp[i][0]-1,whereTostomp[i][1]-1, whereTostomp[i][2]);
	}
	int aggregation = 0;
	for (int i = 0; i < area.length; i++) {
	    for (int j = 0; j < area[0].length; j++) {
		if (Elevation - area[i][j] > 0) {
		    aggregation += Elevation - area[i][j];
		}
	    }
	}
	return 72 * 72 * aggregation;
    }
    public void stomp(int row, int col, int depth) {
	int maxElevation = 0;
	for (int i = row; i < row+3; i++) {
	    for (int j = col; j < col+3; j++) {
		if (area[i][j] > maxElevation) {
		    maxElevation = area[i][j];
		}
	    }
	}
	for (int i = row; i < row+3; i++) {
	    for (int j = col; j < col+3; j++) {
		if (area[i][j] > maxElevation - depth) {
		    area[i][j] = maxElevation - depth;
		}
	    }
	}
    }

    public static void main(String[] args) {
	try {
	    File f = new File("makelake.in");
	    Scanner in = new Scanner(f);
	    // System.out.println(Integer.parseInt(in.next())-1);
	     Bronze cows = new Bronze(in);
	     // cows.printArea();
	     //cows.printStomps();
	      System.out.println(cows.calcVolume()+"6,Zhu,Matthew");
	}
	catch (FileNotFoundException e) {
	    System.out.println("No such file found");
	}
    }
}
