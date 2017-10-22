
/**
 * @author Michael Gentile
 * Instructor: Norm Krumpe
 * CSE 274
 * This will take user input for a infix and evaluate it and print a postfix.
 * Code was done by me using examples from the text.
 */
import java.util.Scanner;

public class Expression {
	public static void main(String[] args) {
		String expression;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input an expression");
		expression = scanner.nextLine();
		scanner.close();
		if (checkBalance(expression)) {
			System.out.println(evaluatePostfix(infixToPostfix(expression)));
		} else {
			System.out.println("The equation is unbalanced");
		}
	}

	/**
	 * 
	 * @param infix
	 *            is a balanced String of values that can be turned into a
	 *            postfix. This would usually be an infix equation.
	 * @return a formatted postfix equation.
	 */
	public static String infixToPostfix(String infix) {
		// declare all variables
		assert checkBalance(infix) == true;
		String topOperatorinStack;
		LinkedStack<String> stack = new LinkedStack<String>();
		String postfix = "";
		infix = fixEquation(infix);

		// scan through the whole string for the operators.
		Scanner scan = new Scanner(infix);
		while (scan.hasNext()) {
			String next = scan.next();
			try {
				// if this throws an error it isn't a number
				Integer.parseInt(next);
				postfix = postfix + next + " ";
			} catch (Exception e) {
				// now we can concentrate on the operators.
				// work through order of operations.
				if (next.equals("(") || next.equals("{") || next.equals("[")) {
					stack.push(next);
				} else if (next.equals(")") || next.equals("}") || next.equals("]")) {
					String test = (String) stack.peek();
					while (!test.equals("(") && !stack.isEmpty()) {
						postfix += test + " ";
						stack.pop();
						test = (String) stack.peek();
					}
					stack.pop();
					// now we go through order of operations.
				} else if (next.equals("^")) {
					if (stack.isEmpty()) {
						stack.push("^");
					} else {
						String test = (String) stack.peek();
						while (!(test.equals("(") || stack.isEmpty() || test.equals("^")) || test.equals(")")) {
							test = (String) stack.pop();
							postfix += test + " ";
						}
						stack.push(next);
					}
				} else if (next.equals("+") || next.equals("-")) {
					if (stack.isEmpty()) {
						stack.push(next);
					} else {
						String test = (String) stack.peek();
						while (!(test.equals("(") || stack.isEmpty() || test.equals(")"))) {
							test = (String) stack.pop();
							postfix += test + " ";

						}
						stack.push(next);
					}
				} else if (next.equals("*") || next.equals("/") || next.equals("%")) {
					if (stack.isEmpty()) {
						stack.push(next);
					} else {
						String test = (String) stack.peek();
						while (!test.equals("+") && !test.equals("-") && !stack.isEmpty()) {
							test = (String) stack.pop();
							postfix += test + " ";

						}
						stack.push(next);
					}

				} else {
					// this is an invalid character. i guess we should just
					// ignore it.
					break;
				}
			}

		}
		// empty the stack so that everything is in the equation.
		while (!stack.isEmpty()) {
			topOperatorinStack = (String) stack.pop();
			postfix = postfix + topOperatorinStack + " ";
		}
		// get rid of leading and trailing spaces.
		postfix.trim();
		// print the posffix equation as insinuated by the example of google
		// drive.
		System.out.println(postfix);
		scan.close();
		return postfix;
	}

	/**
	 * 
	 * @param infix
	 *            is a non formatted inix equation
	 * @return properly spaced infix equation.
	 */
	private static String fixEquation(String infix) {
		infix = infix.replace("+", " + ");
		infix = infix.replaceAll("\\*", " * ");
		infix = infix.replaceAll("-", " - ");
		infix = infix.replaceAll("/", " / ");
		infix = infix.replaceAll("%", " % ");
		infix = infix.replaceAll("\\(", " ( ");
		infix = infix.replaceAll("\\)", " ) ");
		infix = infix.replaceAll("\\[", " ( ");
		infix = infix.replaceAll("\\]", " ) ");
		infix = infix.replaceAll("\\{", " ( ");
		infix = infix.replaceAll("\\}", " ) ");
		infix = infix.replace("^", " ^ ");
		return infix;
	}

	/**
	 * 
	 * @param postfix
	 *            is the preformatted string of a postfix equation.
	 * @return the value of a postfix equation.
	 */
	public static int evaluatePostfix(String postfix) {
		int value1, value2;
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		Scanner scan = new Scanner(postfix);
		while (scan.hasNext()) {
			String temp = scan.next();
			try {
				Integer q = Integer.parseInt(temp);
				stack.push(q);
			} catch (Exception e) {
				value1 = (int) stack.pop();
				value2 = (int) stack.pop();
				if (temp.equals("+")) {
					stack.push(value1 + value2);
				} else if (temp.equals("-")) {
					stack.push(value2 - value1);
				} else if (temp.equals("*")) {
					stack.push(value2 * value1);
				} else if (temp.equals("/")) {
					stack.push(value2 / value1);
				} else if (temp.equals("%")) {
					stack.push(value2 % value1);
				} else if (temp.equals("^")) {
					Double tempD = Math.pow(value2, value1);
					tempD.intValue();
					stack.push(tempD.intValue());
				}
			}
		}
		scan.close();
		return (int) stack.pop();
	}

	/**
	 * 
	 * @param expression
	 *            is the expression that you want to check if the parenthesis
	 *            are balanced.
	 * @return true if all parenthesis are properly paired.
	 */
	public static boolean checkBalance(String expression) {
		LinkedStack<Object> stack = new LinkedStack<Object>();
		for (int x = 0; x < expression.length(); x++) {
			char temp = expression.charAt(x);
			if (temp == '(' || temp == '{' || temp == '[') {
				stack.push(temp);
			} else if (temp == ')' || temp == '}' || temp == ']') {
				if (isPaired((char) stack.peek(), temp)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	/**
	 * 
	 * @param open
	 *            the parenthesis type used to open
	 * @param close
	 *            the parenthesis type used to close.
	 * @return true if they match each other in type.
	 */
	public static boolean isPaired(char open, char close) {
		return (open == '(' && close == ')' || open == '[' && close == ']' || open == '{' && close == '}');
	}

}
