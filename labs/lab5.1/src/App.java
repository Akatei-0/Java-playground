
import java.util.Scanner;

public class App {
    private final RandomNumberGenerator randy = new RandomNumberGenerator();
    private final Scanner scanner = new Scanner(System.in);
    
    public void run() {
        boolean run = true;
        while (run) {
            game();
            run = playAgain(getUserInput("Сыграть еще раз? (да/нет): "));
        }

    }

    private void game() {
        System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

        boolean running = true;
        int answer = randy.getRandomNumber();
        int tryCounter = 0;

        while (running) {
            tryCounter++;
            int guess = getUserNumber(getUserInput("Ваша догадка: "));
            switch (compare(guess, answer)){
                case '=' -> {
                    finishGame(tryCounter);
                    running = false;
                }
                case '>' -> {System.out.println("Загаданное число меньше");}
                
                case '<' -> {System.out.println("Загаданное число больше");}
            }

            
        }
    }
    
    private int getUserNumber(String userInput) {
        int userNumber = 0;
        try {
            userNumber = Integer.parseInt(userInput);
        } 
        catch (NumberFormatException e) {
            System.out.println("Input a valid number!");
        }
        return userNumber;
    }

    private String getUserInput(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    private char compare(int guess, int answer) {
        if (guess == answer) {return '=';}
        else if (guess < answer) {return '<';}
        else {return '>';}
               
    }
    
    private boolean playAgain(String userInput) {
        String userAnswer = userInput.toLowerCase().strip();
        if (userAnswer.equals("да")) {return true;}
        else {return false;}
    }
    
    private void finishGame(int tryCounter) {
        System.out.println("Поздравляю! Вы угадали число за " + tryCounter + " попыток.");
    }
}
