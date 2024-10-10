public class HoliDiscountStrategy extends DiscountStrategy {
    public double applyDiscount(double amt) {
        return amt - amt * 0.3;
    }
}