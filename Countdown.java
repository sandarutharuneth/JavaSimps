import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    private static Timer timer;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Countdown Timer");
        System.out.print("Enter the countdown time in seconds: ");
        int countdownTime = scanner.nextInt();
        
        startCountdown(countdownTime);
    }
    
    public static void startCountdown(int seconds) {
        timer = new Timer();
        
        TimerTask task = new TimerTask() {
            int remainingTime = seconds;
            
            @Override
            public void run() {
                if (remainingTime > 0) {
                    System.out.println("Time remaining: " + remainingTime + " seconds");
                    remainingTime--;
                } else {
                    System.out.println("Countdown completed!");
                    timer.cancel();
                }
            }
        };
        
        timer.scheduleAtFixedRate(task, 0, 1000); // Update every 1 second
    }
}
