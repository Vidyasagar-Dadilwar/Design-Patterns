package pizzastore;

public class NewYorkStyleVeggiePizza extends Pizza{
    public NewYorkStyleVeggiePizza(String name) {
        super(name);
    }
    public void prepare() {
        System.out.println("New Yok Style " + name + " pizza is preparing");
    }

    public void bake() {
        System.out.println("New Yok Style " + name + " pizza is baking");
    }
}