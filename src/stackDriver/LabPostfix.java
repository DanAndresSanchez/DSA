package stackDriver;
import stack.*;
import java.util.Scanner;
/**
 * Evaluate postfix expressions
 * Assume that numbers and operators are separated by one space.
 * Assume that the expressions are well-formed.
 * @author (sdb and Dan Sanchez) 
 * @version (Oct 2018)
 */
public class LabPostfix
{
	public static void main(String[] args) {
		postfixEval();
	}
	
    // read postfix expressions from the keyboard, and evaluate
    public static void postfixEval()
    {   Stack <Integer> stack = new Stack <Integer> ();
        
        // read expression from the keyboard
        Scanner scanner = new Scanner (System.in);
        
        String input;       // store an entire expression
        String [] opInts;   // Each string is an operator or an int.
        int right;           // store right operand
            
        System.out.println ("Enter postfix expressions, or Enter to terminate");
        input = scanner.nextLine();
        while (input.length() > 0)
            {   opInts = input.split (" ");      // An array of Strings, delimiter is space
                char first;
                for (String s : opInts)
                    {   // Is the string s a number or operator?
                        // If the first character in the string is a numeric digit,
                        //    then it must be a number.
                	
                        if(Character.isDigit(s.charAt(0)))
                        	stack.push(Integer.parseInt(s));
                        
                        else {
                        	
                        	switch(s) {
	                        	case("+"): 
	                        		stack.push(stack.pop() + stack.pop());
	                        		break;
	                        		
	                        	case("-"): 
	                        		right = stack.pop();
	                        		stack.push(stack.pop() - right);
	                        		break;
	                        	
	                        	case("*"): 
	                        		stack.push(stack.pop() * stack.pop());
	                        		break;
	                        		
	                        	case("/"): 
	                        		right = stack.pop();
	                        		stack.push(stack.pop() / right);
	                        		break;
	                        		
	                        	case("%"): 
	                        		right = stack.pop();
	                        		stack.push(stack.pop() % right);
	                        		break;
	                        		
	                        	default: 
	                        		System.out.println(s + " is not a recognized operation");
	                        		break;
                        	}
                        	stack.peek();
                        }
                        
                    }
                    if (!stack.isEmpty())
                        System.out.println (stack.peek());
                    stack.clear();
                    
                    input = scanner.nextLine();
                }
            }
                
            
}
