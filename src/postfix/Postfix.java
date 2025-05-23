package postfix;

import stack.Stack;

public class Postfix {

	public static double evaluate(String expression) {
		Stack<Double> stack = new Stack<>();
		String[] tokens = expression.split(" ");

		for (String token : tokens) {
			if (token.matches("\\d+(\\.\\d+)?")) { // unterstützt auch Kommazahlen
				stack.push(Double.parseDouble(token));
			} else if (token.matches("[+\\-*/^]")) {
				double b = stack.pop();
				double a = stack.pop();
				double result = applyOperator(a, b, token);
				stack.push(result);
			} else {
				throw new IllegalArgumentException("Ungültiges Token: " + token);
			}
		}

		if (stack.isEmpty()) {
			throw new IllegalArgumentException("Leerer Ausdruck");
		}

		double result = stack.pop();

		if (!stack.isEmpty()) {
			throw new IllegalArgumentException("Zu viele Operanden");
		}

		return result;
	}

	private static double applyOperator(double a, double b, String op) {
		return switch (op) {
			case "+" -> a + b;
			case "-" -> a - b;
			case "*" -> a * b;
			case "/" -> a / b;
			case "^" -> Math.pow(a, b); // Exponent-Funktion
			default -> throw new IllegalArgumentException("Unbekannter Operator: " + op);
		};
	}
}
