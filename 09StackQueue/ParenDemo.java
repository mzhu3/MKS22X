import java.util.*;
public class ParenDemo{
    public static boolean isMatching(String s){
	MyStack<String> StringStack = new MyStack<String>();
	if(s.substring(0,1).equals(")")||
	   s.substring(0,1).equals("}")||
	   s.substring(0,1).equals("]")||
	   s.substring(0,1).equals(">")||
	   s.substring(s.length()- 1,s.length()).equals("(")||
	   s.substring(s.length()- 1,s.length()).equals("{")||
	   s.substring(s.length()- 1,s.length()).equals("[")||
	   s.substring(s.length()- 1,s.length()).equals("<")){
	    return false;
	}
        for(int i = 0; i < s.length(); i++){
	    if(s.substring(i,i+1).equals("(")||
	       s.substring(i,i+1).equals("[")||
	       s.substring(i,i+1).equals("{")||
	       s.substring(i,i+1).equals("<")){
		StringStack.push(s.substring(i,i+1));
	    }
	    try{
		if(s.substring(i,i+1).equals(")")){
		    if(!StringStack.pop().equals("(")){
			return false;
		    }
		}
	    }
	    catch(NoSuchElementException e){
		return false;
	    }
	    try{
		if(s.substring(i,i+1).equals("]")){
		    if(!StringStack.pop().equals("[")){
			return false;
		    }
		}
	    }
	    catch(NoSuchElementException e){
		return false;
	    }
	    try{
		if(s.substring(i,i+1).equals("}")){
		    if(!StringStack.pop().equals("{")){
			return false;
		    }
		}
	    }
	    catch(NoSuchElementException e){
		return false;
	    }
	    try{
		if(s.substring(i,i+1).equals(">")){
		    if(!StringStack.pop().equals("<")){
			return false;
		    }
		}
	    }
	    catch(NoSuchElementException e){
		return false;
	    }
	}
	return StringStack.isEmpty();
    }
    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }
}
