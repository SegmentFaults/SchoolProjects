import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author ACHCHUTHAN
 */
public class Test extends Stack {

    public Test(int x) {
        super();
    }

    /**
     *@return postfixString value
     */
   
    public String InToPost(String infixString) {
        String postfixString = " ";
        infixString=infixString.replace(" ", "");
        System.out.println(infixString);
        for (int index = 0; index < infixString.length(); ++index) {
            char chValue = infixString.charAt(index);
            if (chValue == '(') {
                push('(');
            } else if (chValue == ')') {
                Character oper = (Character) peek();
                while (!(oper.equals('(')) && !(isEmpty())) {
                    postfixString += oper.charValue();
                    pop();
                    oper = (Character) peek();
                }
                pop();
            } else if (chValue == '+' || chValue == '-') {
                //Stack is empty
                if (isEmpty()) {
                    push(chValue);
                    //current Stack is not empty
                } else {
                    Character oper = (Character) peek();
                    while (!(isEmpty() || oper.equals(new Character('(')) || oper.equals(new Character(')')))) {
                        pop();
                        postfixString += oper.charValue();
                    }
                    push(chValue);
                }
            } else if (chValue == '*' || chValue == '/') {
                if (isEmpty()) {
                    push(chValue);
                } else {
                    Character oper = (Character) peek();
                    while (!oper.equals(new Character('+')) && !oper.equals(new Character('-')) && !isEmpty()) {
                        pop();
                        postfixString += oper.charValue();
                    }
                    push(chValue);
                }
            } //is a number
            else {
                postfixString += chValue;
            }
        }
        while (!isEmpty()) {
            Character oper = (Character) peek();
            if (!oper.equals(new Character('('))) {
                pop();
                postfixString += oper.charValue();
            }
        }
        return postfixString;
    }

    public static void main(String[] args) {
        Test mystack = new Test(10);
        System.out.println("Type in an expression like (1+2)*(3+4)/(12-5)\n "
                + "with no monadic operators like in-5 or +5 followed by key");
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println("The Expression you have typed in infix form :\n"+str);
        System.out.println("The Equivalent Postfix Expression is :\n"+mystack.InToPost(str));
    }
}