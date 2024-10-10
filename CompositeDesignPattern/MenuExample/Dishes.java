public class Dishes implements MenuComponent {
    private String name; 
    Dishes(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void print(){
        System.out.println("Dish: " + this.name);
    }
}
