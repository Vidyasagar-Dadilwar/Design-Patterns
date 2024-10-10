package pizzastore;

public class NyStylePizzaStore extends PizzaStore{
    protected Pizza createPizza (String item){
        if (item.equals("cheese")) {
            Pizza pizza = new NewYorkStyleCheesePizza(item);
            pizza.prepare();
            pizza.bake();
            return pizza;
        } 
        else if (item.equals("veggie")) {
            Pizza pizza = new NewYorkStyleVeggiePizza(item);
            pizza.prepare();
            pizza.bake();
            return pizza;
        }  
        else {
            System.out.println("Sorry there is no type of pizza. Choose between ");
            return null;
        }
    }
}
