package pizzastore;

public class Pizza {
    protected String name;

    public Pizza(String name) {
        this.name = name;
    }

    public void prepare() {
        System.out.println("Preparing " + name + " pizza");
    }

    public void bake() {
        System.out.println("Baking " + name + " pizza");
    }

    public void cut(){
        System.out.println("Cutting " + name + " pizza");
    }

    public void box() {
        System.out.println("Packing " + name + " pizza");
    }
}