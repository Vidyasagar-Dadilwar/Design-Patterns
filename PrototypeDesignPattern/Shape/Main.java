import java.util.HashMap;

interface Shape extends Cloneable {
    void display();
    Shape clone();
    void setPosition(int x, int y); 
    void setSize(int size);
}

class Circle implements Shape {
    private int x, y, size;

    Circle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void display() {
        System.out.println("This is a circle having center: x = " + this.x + " y = " + this.y
                + ". The area of circle is " + this.size);
    }

    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Rectangle implements Shape {
    private int x, y, size;

    Rectangle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void display() {
        System.out.println("This is a rectangle located at : x = " + this.x + " y = " + this.y
                + ". The area of rectangle is " + this.size);
    }

    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Triangle implements Shape {
    private int x, y, size;

    Triangle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void display() {
        System.out.println("This is a triangle having location coords: x = " + this.x + " y = " + this.y
                + ". The area of triangle is " + this.size);
    }

    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class ShapeRegistry {
    private static HashMap<String, Shape> map = new HashMap<>();

    void registerShape(String type, Shape s) {
        map.put(type, s);
    }

    Shape createShape(String type) {
        Shape s = map.get(type);
        if (s != null) {
            return s.clone();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeRegistry registry = new ShapeRegistry();
        Shape circle = new Circle(0, 0, 10);
        Shape rectangle = new Rectangle(5, 5, 100);
        Shape triangle = new Triangle(1, 1, 20);

        registry.registerShape("Circle", circle);
        registry.registerShape("Rectangle", rectangle);
        registry.registerShape("Triangle", triangle);

        Shape c1 = registry.createShape("Circle");
        if (c1 != null) {
            c1.setPosition(10, 10);
            c1.setSize(100);
            c1.display();
        } else {
            System.out.println("Failed to create Circle");
        }

        Shape r1 = registry.createShape("Rectangle");
        if (r1 != null) {
            r1.display();
        } else {
            System.out.println("Failed to create Rectangle");
        }

        Shape t1 = registry.createShape("Triangle");
        if (t1 != null) {
            t1.display();
        } else {
            System.out.println("Failed to create Triangle");
        }
    }
}
