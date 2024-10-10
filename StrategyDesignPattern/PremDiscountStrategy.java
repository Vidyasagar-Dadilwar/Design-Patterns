public class PremDiscountStrategy extends DiscountStrategy {
    public double applyDiscount(double amt) {
        return amt - amt * 0.2;
    }
}
