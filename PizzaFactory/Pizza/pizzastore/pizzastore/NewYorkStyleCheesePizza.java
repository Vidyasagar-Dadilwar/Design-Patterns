package pizzastore;

public class NewYorkStyleCheesePizza extends Pizza{
    public NewYorkStyleCheesePizza(String name) {
        super(name);
    }
    public void prepare(){
        System.out.println("New Yok Style "+name+" pizza is preparing");
    }
    public void bake() {
        System.out.println("New Yok Style " + name + " pizza is baking");
    }
}
