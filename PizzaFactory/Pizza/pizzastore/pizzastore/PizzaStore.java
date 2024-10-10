package pizzastore;

public abstract class PizzaStore {
    private SimplePizzaFactory factory;

    public PizzaStore() {
        this.factory = new SimplePizzaFactory();
    }

    // this is factory method
    protected abstract Pizza createPizza(String type);
    
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
