package pizzastore;

public class ChicagoStylePizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        Pizza pizza = new ChicagoStyleCheesePizza(type);
        return pizza;
    }
}
