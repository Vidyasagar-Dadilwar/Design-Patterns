interface Pizza {
    void prepare();
}

abstract class Restaurant {
    public Pizza orderPizza() {
        Pizza Pizza = createPizza();
        Pizza.prepare();
        return Pizza;
    }

    public abstract Pizza createPizza();
}

class BeefPizzaRestaurant extends Restaurant {
    @Override
    public Pizza createPizza() {
        return new BeefPizza();
    }
}

class VeggiePizzaRestaurant extends Restaurant {
    @Override
    public Pizza createPizza() {
        return new VeggiePizza();
    }
}

class BeefPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Beef Pizza");
    }
    public String toString(){
        return ("This is beef pizza");
    }
}

class VeggiePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Veggie Pizza");
    }
    public String toString(){
        return ("This is pizza");
    }
}

public class Main {
    public static void main(String[] args) {
        Restaurant beefRestro = new BeefPizzaRestaurant();
        Pizza beef = beefRestro.orderPizza();
        System.out.println(beef);

        Restaurant veggieRestro = new VeggiePizzaRestaurant();
        Pizza veggie = veggieRestro.orderPizza();
        System.out.println(veggie);
    }
}
