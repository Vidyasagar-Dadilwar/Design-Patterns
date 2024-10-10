abstract class Beverage{
    String description;
    
    String getDescription(){
        return this.description;
    };
    abstract double cost();
}