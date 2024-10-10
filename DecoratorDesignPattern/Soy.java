public class Soy extends CondimentDecorator {
    Beverage beverage;
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
    public double cost() {
        return beverage.cost() + 40;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
