package postfix;

import scanner.Scanner;
import stack.Stack;

public class Infix {

    public static String toPostfix(String input) {
        Scanner scanner = new Scanner(input);
        StringBuilder output = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();

        for (String token : scanner.getToken()) {
            if (isNumber(token)) {
                output.append(token).append(" ");
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && isOperator(operatorStack.peek()) &&
                        precedence(operatorStack.peek()) >= precedence(token)) {
                    output.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.append(operatorStack.pop()).append(" ");
                }
                if (!operatorStack.isEmpty()) {
                    operatorStack.pop(); // "(" entfernen
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop()).append(" ");
        }

        return output.toString().trim(); // Letztes Leerzeichen entfernen
    }

    private static boolean isNumber(String s) {
        return s.matches("\\d+");
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int precedence(String op) {
        switch (op) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
        }
        return 0;
    }
}
