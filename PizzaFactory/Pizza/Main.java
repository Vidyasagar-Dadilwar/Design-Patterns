import pizzastore.Pizza;
import pizzastore.PizzaStore;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the style of the pizza [NY/Chicago]");
        String style = scan.nextLine();
        String type;
        if (style.equals("NY")) {
            NyStylePizzaStore pizzaStore = new NyStylePizzaStore();
            System.out.println("Enter type NYCheesePizza / NYVeggiePizza");
            type = scan.nextLine();
            pizzaStore.createPizza(type);

        } else if (style.equals("Chicago")) {
            ChicagoStylePizzaStore pizzaStore = new ChicagoStylePizzaStore();
            System.out.println("Enter type ChicagoCheesePizza / ChicagoVeggiePizza");
            type = scan.nextLine();
            pizzaStore.createPizza(type);
        } else {
            System.out.println("Invalid input ");
        }
    }
}