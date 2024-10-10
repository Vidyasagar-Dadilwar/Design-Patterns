public class RegDiscountStrategy extends DiscountStrategy {
    public double applyDiscount(double amt){
        return amt - amt*0.1;
    }
}
