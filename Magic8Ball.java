import java.util.Random;
import java.util.Scanner;

public class Magic8Ball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Magic 8-Ball");
        System.out.println("Ask a yes/no question, and I'll give you an answer.");
        System.out.print("Ask your question (or type 'exit' to quit): ");
        
        while (true) {
            String question = scanner.nextLine().toLowerCase();
            
            if (question.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            
            String answer = getMagic8BallAnswer();
            System.out.println("Magic 8-Ball says: " + answer);
            
            System.out.print("Ask another question (or type 'exit' to quit): ");
        }
        
        scanner.close();
    }
    
    public static String getMagic8BallAnswer() {
        String[] answers = {
            "It is certain.",
            "It is decidedly so.",
            "Without a doubt.",
            "Yes – definitely.",
            "You may rely on it.",
            "As I see it, yes.",
            "Most likely.",
            "Outlook good.",
            "Yes.",
            "Signs point to yes.",
            "Reply hazy, try again.",
            "Ask again later.",
            "Better not tell you now.",
            "Cannot predict now.",
            "Concentrate and ask again.",
            "Don't count on it.",
            "My reply is no.",
            "My sources say no.",
            "Outlook not so good.",
            "Very doubtful."
        };
        
        Random random = new Random();
        int index = random.nextInt(answers.length);
        
        return answers[index];
    }
}
