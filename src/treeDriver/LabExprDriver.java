package treeDriver;
import tree.*;

/**Test the Expression tree classes.
 * 
 * @author (sdb) 
 * @version (Nov 2018)
 */
public class LabExprDriver 
{
  public static void main(String[] args)
  {  
      System.out.println ("\n\nTesting part (a)");
      Expression e1 = new Sum (new Constant(3), new Constant(5));       //  3 + 5      
      Expression e2 = new Sum (new Constant(5), new Constant(3));       //  3 + 5 
      e1 = new Quotient (e1, e2);
      System.out.println ("The quotient is " + e1);                 // (3+5) / (5+3)
      System.out.println ("It simplifies to " + e1.simplify());       // 1
      e1 = new Quotient (e2, e2);
      System.out.println (e1 + " simplifies to " + e1.simplify());
      
      e1 = new Difference (new Constant(3), new Constant(5));       //  3 - 5
      e2 = new Difference (new Constant(5), new Constant (3));      //  5 - 3
      if (e1.equals (e2))
        System.err.println ("Not correct: equals in Difference ");
      
   
      Expression zero = new Constant (0);
      Expression one = new Constant (1);
      e1 = new Sum (new Constant (3), zero);        // 3 + 0
      System.out.println (e1 + " simplifies to " + e1.simplify());           // 3
      
      e1 = new Product (new Constant (4), zero);    // 4 * 0
      System.out.println (e1 + " simplifies to " + e1.simplify());            // 0
      
      e1 = new Product (e2, one);                   //  (5-3) * 1
      System.out.println (e1 + " simplifies to " + e1.simplify());            //  (5 - 3)

      
      //////////  Uncomment the following when ready for part (b)
       System.out.println ("\n\nTesting part (b)");
       boolean ok = false;
         e1 = new Sum (new Variable('x'), new Variable('y'));            //  x + y
         try { e1.eval(); }
         catch (IllegalArgumentException iae)
             {   ok = true; }
         if (!ok)
             System.err.println ("Cannot eval a variable, unless it has a value");
         e1.simplify();
         new Quotient(new Variable('w'), e1).simplify();
         new Difference (e1,e1).simplify();
             
         e2 = new Sum (new Variable('y'), new Variable('x'));            //  y+x
         Expression e3 = new Difference (e1, e2);                                   // (x+y) - (y+x)
         System.out.println (e3 + "Simplifies to " + e3.simplify());          // 0
         System.out.println();
         
         Expression e = new Quotient (new Variable('x'), new Variable('x'));       // x / x
         e = new Product ( new Variable('y'), e);                    //   y * (x/x)
         e = new Difference (e, new Variable('y'));                   //   y * (x/x) - y
         e = new Sum (e, new Constant(1));                             //   (y * (x/x) - y) + 1
         System.out.println (e + "Simplifies to " + e.simplify());        //   1
         
             e1 = new Difference (new Variable ('a'), new Variable ('b'));
             e2 = new Difference (new Variable ('b'), new Variable ('a'));
             if (e1.equals (e2))
                 System.out.println ("Not correct");
             e1 = new Quotient (new Variable ('a'), new Variable ('b'));
             e2 = new Quotient (new Variable ('b'), new Variable ('a'));
             if (e1.equals (e2))
                 System.out.println ("Not correct");


                //////////  Uncomment the following when ready for part (c)
       System.out.println ("\nTesting part (c)");
               
           Expression a = new Variable ('a');
           Expression b = new Variable ('b');
           ok = false;
 
 try {     System.out.println (new Sum(a,b).eval()); }
 catch (IllegalArgumentException iae)
     {     ok = true; }
      if (!ok)
             System.err.println ("Cannot eval a variable, unless it has a value");
      ok = false;
      
      e1 = new Sum (new Assign(a, new Constant(5)),
                             new Assign (b, new Constant (7)));          // e1 = (a=5) + (b=7)                            
 try {     System.out.println (new Sum(a,b).eval()); }
 catch (IllegalArgumentException iae)
     {     ok = true; }
     if (!ok)
             System.err.println ("Cannot eval a variable, unless it has a value");
     
           System.out.println ("The value of " + e1 + " is " + e1.eval());
           
           System.out.println (a + " is " + a.eval());
           System.out.println (b + " is " + b.eval());
           
           (new Assign (b, new Constant(5))).eval();                              // b = 5, discard the result
           if (b.equals(a))
             System.err.println ("Incorrect: a and b are different expressions");
             
           (new Assign (b, a)).eval();                                           // b = a;
           (new Assign (a, new Constant (0))).eval();                            // a = 0;
           if (b.eval() != 5)
             System.err.println ("Incorrect: Variables should store values, not expressions");
             
           e1 = new Assign(a, new Sum (b, new Constant (0)));
           System.out.println (e1 + " simplifies to " + e1.simplify());
  }
  
}