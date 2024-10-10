public class Main{
    public static void main(String[] args) {
        Beverage darkRoast = new DarkRoast();
        Beverage mocha = new Mocha(darkRoast);
        System.out.println("Cost of your product '" + mocha.getDescription() + "' is " + mocha.cost());


        // Plain espresso
        Beverage beverage = new Espresso();
        System.out.println("Cost of your product '" + beverage.getDescription() + "' is " + beverage.cost());

        // Espresso with Mocha
        Beverage espressoWithMocha = new Mocha(new Espresso());
        System.out.println("Cost of your product '" + espressoWithMocha.getDescription() + "' is " +  espressoWithMocha.cost());


        // Double whip with decaf
        Beverage doubleWhip = new Whip(new Whip(new Decaf()));
        System.out.println("Cost of your product '" + doubleWhip.getDescription() + "' is " + doubleWhip.cost());
    }
}