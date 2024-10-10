public class Whip extends CondimentDecorator {
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
