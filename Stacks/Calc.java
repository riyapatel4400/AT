package Stacks;
import java.util.Stack;
public class Calc {

	/* A Java program to evaluate a given expression where vals are separated 
	by space.
	Test Cases:
		"10 + 2 * 6"		    ---> 22
		"100 * 2 + 12"		    ---> 212
		"100 * ( 2 + 12 )"	    ---> 1400
		"100 * ( 2 + 12 ) / 14" ---> 100 
	 */

	public static int evaluate(String expression)
	{
		char[] vals = expression.toCharArray();

		Stack<Integer> values = new Stack<Integer>();

		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < vals.length; i++)
		{
			if (vals[i] == ' ')
				continue;

			if (vals[i] >= '0' && vals[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				while (i < vals.length && vals[i] >= '0' && vals[i] <= '9')
					sbuf.append(vals[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}

		
			else if (vals[i] == '+' || vals[i] == '-' ||
					vals[i] == '*' || vals[i] == '/' || vals[i] == '^')
			{
				// While top of 'ops' has same or greater precedence to current
				// token, which is an operator. Apply operator on top of 'ops'
				// to top two elements in values stack
				while (!ops.empty() && hasPrecedence(vals[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				ops.push(vals[i]);
			}
		}

		// apply remaining ops to remaining values
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		// Top of 'values' contains result, return it
		return values.pop();
	}

	// Returns true if 'op2' has higher or same precedence as 'op1'
	public static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '^' )
			return true;
		else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else if ( op1=='^')
			return false;
		
		else
			return true;
	}

	public static int applyOp(char op, int b, int a)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new
				UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		case '^':
			return (int) Math.pow (a, b);
		}
		return 0;
	}

	
	public static void main(String[] args)
	{
		System.out.println(Calc.evaluate("10 + 2 * 6"));
		System.out.println(Calc.evaluate("100 ^ 2 + 12"));
		System.out.println(Calc.evaluate("100 + 2 ^ 12"));
		System.out.println();
		System.out.println(Calc.evaluate("2 - 10 - 3 * 2 - 5"));
		System.out.println(Calc.evaluate("2 ^ 3 - 3 * 2 - 5 + 7"));
	}
}


