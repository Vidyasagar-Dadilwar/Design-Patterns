abstract class CaffineBeverage{
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    void boilWater(){
        System.out.println("Boiling the water ....");
    }
    void pourInCup(){
        System.out.println("Pouring in the cup ....");
    }
    abstract void brew();
    abstract void addCondiments();
}