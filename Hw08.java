/**
 * course: CSC 210
 * project: Hw08
 * date: March 28, 2023
 * author: Vladimir Murray
 * purpose: To find the result of the expression given by the user
 */
import java.util.*;
public class Hw08 {
  public static void main(String[] args) {
    // Check number of arguments passed
    Scanner in = new Scanner(System.in);
    System.out.print("Enter an expression: ");
    String s = in.nextLine();
    
    

    try {
      System.out.println(s+" = "+evaluateExpression(s));
    }
    catch (Exception ex) {
      System.out.println("Wrong expression: " + s);
    }
  }

  public static int evaluateExpression(String expression) {
    Stack<Integer> operandStack = new Stack<>();
  
    Stack<Character> operatorStack = new Stack<>();
  
    expression = insertBlanks(expression);

    String[] tokens = expression.split(" ");

    // Phase 1: Scan tokens
    for (String token: tokens) {
      if (token.length() == 0) // Blank space
        continue; // Back to the while loop to extract the next token
      else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
        while (!operatorStack.isEmpty() &&
          (operatorStack.peek() == '+' || 
           operatorStack.peek() == '-' ||
           operatorStack.peek() == '*' ||
           operatorStack.peek() == '/' ||
           operatorStack.peek() == '%' ||
           operatorStack.peek() == '^')) {
          processAnOperator(operandStack, operatorStack);
        }

        // Push the + or - operator into the operator stack
        operatorStack.push(token.charAt(0));
      }
      else if (token.charAt(0) == '%' || token.charAt(0) == '*' || token.charAt(0) == '/') {
        // Process all *, / in the top of the operator stack 
        while (!operatorStack.isEmpty() &&
          (operatorStack.peek() == '*' ||
          operatorStack.peek() == '/' ||
          operatorStack.peek() == '%')) {
          processAnOperator(operandStack, operatorStack);
        }

        // Push the * or / operator into the operator stack
        operatorStack.push(token.charAt(0));
      }
      else if(token.charAt(0) == '^'){
        while (!operatorStack.isEmpty() && 
            operatorStack.peek() == '^'){
            processAnOperator(operandStack, operatorStack);
          }
        operatorStack.push(token.charAt(0));
      }
      else if (token.trim().charAt(0) == '(') {
        operatorStack.push('('); // Push '(' to stack
      }
      else if (token.trim().charAt(0) == ')') {
        // Process all the operators in the stack until seeing '('
        while (operatorStack.peek() != '(') {
          processAnOperator(operandStack, operatorStack);
        }
        
        operatorStack.pop(); // Pop the '(' symbol from the stack
      }
      else { // An operand scanned
        // Push an operand to the stack
        operandStack.push(Integer.valueOf(token));
      }
    }

    // Phase 2: process all the remaining operators in the stack 
    while (!operatorStack.isEmpty()) {
      processAnOperator(operandStack, operatorStack);
    }

    // Return the result
    return operandStack.pop();
  }

  /** Process one operator: Take an operator from operatorStack and
   *  apply it on the operands in the operandStack */
  public static void processAnOperator(
      Stack<Integer> operandStack, Stack<Character> operatorStack) {
    char op = operatorStack.pop();
    int op1 = operandStack.pop();
    int op2 = operandStack.pop();
    if (op == '+') 
      operandStack.push(op2 + op1);
    else if (op == '-') 
      operandStack.push(op2 - op1);
    else if (op == '*') 
      operandStack.push(op2 * op1);
    else if (op == '/') 
      operandStack.push(op2 / op1);
    else if (op == '%') 
      operandStack.push(op2 % op1);
    else if (op == '^') 
      operandStack.push((int)Math.pow(op2, op1));
  }
  
  public static String insertBlanks(String s) {
    String result = "";
    
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == ')' || 
          s.charAt(i) == '+' || s.charAt(i) == '-' ||
          s.charAt(i) == '*' || s.charAt(i) == '/' ||
          s.charAt(i) == '%' || s.charAt(i) == '^')
        result += " " + s.charAt(i) + " ";
      else
        result += s.charAt(i);
    }
    
    return result;
  }
}