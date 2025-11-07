import java.util.List;
import java.util.Scanner;

public class App {
    private final ProductsManager products = new ProductsManager();
    private final Scanner scanner = new Scanner(System.in);
    
    public void run() {

        boolean run = true;
        
        //  Products (Hardcoded)
        products.addProduct("apples", 100.00);
        products.addProduct("Bananas", 85.00);
        products.addProduct("milk", 70.00);
        products.addProduct("bread", 50.00);
        products.addProduct("cheese", 300.00);

        while (run) {
            printMenu();
            char action = getUserInput("action").charAt(0);
            
            switch (action) {
                case '4' -> {
                    System.out.println("Bye!");
                    run = false;
                }
                
                case '1' -> listProducts("Продукты", products.getProducts());
                
                case '2' -> {
                    try {
                        double min = Double.parseDouble(getUserInput("Min price"));
                        double max = Double.parseDouble(getUserInput("Max price"));
                        listProducts(("Продукты в диапазоне " + min + " - " + max), products.getSortedProducts(min, max));
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                } 
                case '3' -> System.out.println(products.getTheMostExpensiveProduct().toString());
                    
                default -> System.out.println("Enter a valid action!");
                
            }
        }
        
        scanner.close();
    }

    private String getUserInput(String whatToChoose) {
        System.out.print("Enter "  + whatToChoose + ": ");
        return scanner.nextLine();
    }
    
    private void listProducts(String whatToList, List<Product> products) {
        System.out.println(whatToList + ":\n");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ". " + products.get(i).toString());
        }
    }
    
    
    private void printMenu() {
        System.out.println();
        System.out.println("""
            Меню:
        1 - Показать все товары
        2 - Найти товары в заданном ценовом диапазоне
        3 - Найти самый дорогой товар
        4 - Выход
                """);
    }
}
