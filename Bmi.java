import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("BMI Calculator");
        
        // Input weight in kilograms
        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();
        
        // Input height in meters
        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();
        
        // Calculate BMI
        double bmi = calculateBMI(weight, height);
        
        // Display the result
        System.out.println("Your BMI is: " + bmi);
        
        // Interpret BMI
        interpretBMI(bmi);
        
        scanner.close();
    }
    
    public static double calculateBMI(double weight, double height) {
        // BMI formula: weight (kg) / (height (m) * height (m))
        return weight / (height * height);
    }
    
    public static void interpretBMI(double bmi) {
        System.out.print("Interpretation: ");
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Normal weight");
        } else if (bmi >= 24.9 && bmi < 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
