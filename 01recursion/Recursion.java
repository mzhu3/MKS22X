public class Recursion implements hw01{
    public String name(){
	return "Zhu,Matthew";
    }
    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return helper(n,1);
    }
    public double helper(double actual, double guesss){
	double guess = guesss;
	if(ok(actual,guess)){
	    return guess;
	}
	return helper(actual, (actual/guess + guess)/2);
    }
    public boolean ok(double actual, double guess){
	if(actual == 0.0 && guess == 0.0){
	    return true;
	}
	if(actual == 0.0){
	    return ok(guess,actual);
	}
	return Math.abs((guess*guess)-actual)/actual < 0.000000001;
    }
    public static void main(String[]args){
	Recursion r = new Recursion();
	//  System.out.println(r.sqrt(-1000000));
	System.out.println(r.sqrt(4));
	System.out.println(r.sqrt(0));
	System.out.println(r.sqrt(1000));
	System.out.println(r.sqrt(18));
	System.out.println(r.sqrt(.0000000000000000001));
	
    }
}
