public class Product {
    private String title;
    private double price;
    
    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }
    
    public String getTitle() {return title;}
    public double getPrice() {return price;}
    @Override
    public String toString() {return (title + " (" + price + "руб.) ");}
}
