public class ShoppingCart {
    DiscountStrategy ds = null;
    ShoppingCart(DiscountStrategy ds){
        this.ds = ds;
    }
    void setDiscountStrategy(DiscountStrategy ds){
        this.ds = ds;
    }    
    double calculateTotal(double amt){
        return ds.applyDiscount(amt);
    }
}
