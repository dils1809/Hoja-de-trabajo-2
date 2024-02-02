import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("datos.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Postfix expression: " + line);
                try {
                    System.out.println("Result: " + evaluatePostfix(line));
                } catch (ArithmeticException | IllegalArgumentException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int evaluatePostfix(String expression) throws ArithmeticException, IllegalArgumentException {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Insufficient operands for operator: " + token);
                }
                int operandB = stack.pop();
                int operandA = stack.pop();
                if (token.equals("/") && operandB == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                int result = evaluate(token, operandA, operandB);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression format");
        }
        return stack.pop();
    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static int evaluate(String operator, int operandA, int operandB) {
        switch (operator) {
            case "+":
                return operandA + operandB;
            case "-":
                return operandA - operandB;
            case "*":
                return operandA * operandB;
            case "/":
                return operandA / operandB;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
