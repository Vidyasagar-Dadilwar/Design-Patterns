import java.util.ArrayList;

public class DishType implements MenuComponent{
    private String name; 
    private ArrayList<MenuComponent> children;

    public DishType(String name){
        this.name = name;
        this.children = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void print(){
        System.out.println("Dish type: " + name);
        for (MenuComponent child : children) {
            child.print();
        }
    }
    public void add(MenuComponent component){
        children.add(component);
        System.out.println("Added: " + component.getName() + " to " + this.name);
    }
    public void remove(MenuComponent component){
        children.remove(component);
        System.out.println("Removed: " + component.getName() + " to " + this.name);
    }
    public MenuComponent getChild(int i){
        return children.get(i);
    }
}
