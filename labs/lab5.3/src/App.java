
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final ShapeMaker maker = new ShapeMaker();
    
    public void run() {
        
        boolean run = true;
        
        while(run){
            printMenu();
            char action = getUserInput("> ").charAt(0);
            switch (action) {
                case '4' -> {
                    System.out.println("Bye!");
                    run = false;
                }
                case '1' -> {
                    int width = getUserNumber(getUserInput("Введите ширину: "));
                    int height = getUserNumber(getUserInput("Введите высоту: "));
                    shapeAssembler(maker.makeRectangle(width, height));
                }
                case '2' -> {
                    int height = getUserNumber(getUserInput("Введите высоту: "));
                    shapeAssembler(maker.makeRightTriangle(height));
                }
                case '3' -> {
                    int height = getUserNumber(getUserInput("Введите половину длины вертикальной диагонали: "));
                    shapeAssembler(maker.makeDiamond(height));
                }
                default -> System.out.println("Введите валидное действие!");
            }
        }
        scanner.close();
    }
    
    private String getUserInput(String text) {
        System.out.print(text);
        return scanner.nextLine();
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
    
    private void shapeAssembler(List<String> rows) {
        for (int i = 0; i< rows.size(); i++) {
            System.out.println(rows.get(i));
        }
    }
    
    private void printMenu() {
        System.out.println();
        System.out.println("""
            Выберите фигуру:
            1 - Прямоугольник
            2 - Треугольник
            3 - Ромб
            4 - Выход
                """);
    }
}
