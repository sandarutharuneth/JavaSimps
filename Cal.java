import java.util.Scanner;

public class Cal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Simple Calculator");
        System.out.println("Available operations: +, -, *, /");
        
        while (true) {
            System.out.print("Enter an expression (e.g., 2 + 3): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Calculator exiting. Goodbye!");
                break;
            }
            
            try {
                String[] tokens = input.split(" ");
                
                if (tokens.length != 3) {
                    throw new IllegalArgumentException("Invalid input format.");
                }
                
                double num1 = Double.parseDouble(tokens[0]);
                char operator = tokens[1].charAt(0);
                double num2 = Double.parseDouble(tokens[2]);
                
                double result = calculate(num1, operator, num2);
                
                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter valid numbers.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        scanner.close();
    }
    
    public static double calculate(double num1, char operator, double num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator. Supported operators: +, -, *, /");
        }
    }
}
