abstract class Beverage {
    String description = "";
    abstract double cost();
    String getDescription() {
        return this.description;
    }
}

class DarkRoast extends Beverage {
    DarkRoast() {
        description = "Dark Roast Coffee";
    }
    double cost() {
        return 300;
    }
}

class Decaf extends Beverage {
    Decaf() {
        description = "Decaf Coffee";
    }    
    double cost() {
        return 200;
    }
}

class Espresso extends Beverage {
    Espresso() {
        description = "Espresso Coffee";
    }    
    double cost() {
        return 400;
    }
}

abstract class CondimentDecorator extends Beverage {
    abstract String getDescription();
}

class Milk extends CondimentDecorator {
    Beverage beverage;
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }
    public double cost() {
        return beverage.cost() + 30;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}

class Mocha extends CondimentDecorator {
    Beverage beverage;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    public double cost() {
        return beverage.cost() + 20;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}

class Whip extends CondimentDecorator {
    Beverage beverage;
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }
    public double cost() {
        return beverage.cost() + 10;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}

public class Main {
    public static void main(String[] args) {
        Beverage darkRoast = new DarkRoast();
        Beverage mocha = new Mocha(darkRoast);
        System.out.println("Cost of your product '" + mocha.getDescription() + "' is " + mocha.cost());

        // Plain espresso
        Beverage beverage = new Espresso();
        System.out.println("Cost of your product '" + beverage.getDescription() + "' is " + beverage.cost());

        // Espresso with Mocha
        Beverage espressoWithMocha = new Mocha(new Espresso());
        System.out.println(
                "Cost of your product '" + espressoWithMocha.getDescription() + "' is " + espressoWithMocha.cost());

        // Double whip with decaf
        Beverage doubleWhip = new Whip(new Whip(new Decaf()));
        System.out.println("Cost of your product '" + doubleWhip.getDescription() + "' is " + doubleWhip.cost());
    }
}