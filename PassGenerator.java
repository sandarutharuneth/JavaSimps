import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PassGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Strong Password Generator");
        
        System.out.print("Enter password length: ");
        int passwordLength = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        System.out.print("Include Uppercase letters? (Y/N): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("Y");
        
        System.out.print("Include Lowercase letters? (Y/N): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("Y");
        
        System.out.print("Include Numbers? (Y/N): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("Y");
        
        System.out.print("Include Symbols? (Y/N): ");
        boolean includeSymbols = scanner.nextLine().equalsIgnoreCase("Y");
        
        String password = generatePassword(passwordLength, includeUppercase, includeLowercase, includeNumbers, includeSymbols);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSymbols) {
        StringBuilder characters = new StringBuilder();
        
        if (includeLowercase) {
            characters.append(LOWERCASE);
        }
        if (includeUppercase) {
            characters.append(UPPERCASE);
        }
        if (includeNumbers) {
            characters.append(DIGITS);
        }
        if (includeSymbols) {
            characters.append(SYMBOLS);
        }
        
        if (characters.length() == 0) {
            throw new IllegalArgumentException("You must select at least one character type.");
        }
        
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        
        return password.toString();
    }
}
