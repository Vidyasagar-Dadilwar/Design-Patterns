interface Line{
    void drawLine();
}

class SolidLine implements Line{
    public void drawLine() {
        System.out.println("Drawing solid line --------");
    }
}

class DottedLine implements Line {
    public void drawLine() {
        System.out.println("Drawing Dotted line .......");
    }
}

interface LineFactory{
    Line createLine();
}

class SolidShape implements LineFactory{
    public Line createLine() {
        Line solidLine = new SolidLine();
        return solidLine;
    }
}

class DottedShape implements LineFactory{
    public Line createLine(){
        Line dottedLine = new DottedLine();
        return dottedLine;
    }
}

class Application{
    Line l;
    public Application(LineFactory factory) {
        this.l = factory.createLine();
    }
    public void print(){
        l.drawLine();
    }
}

public class Main {
    public static void main(String[] args) {
        Application a = new Application(new DottedShape());
        a.print();
    }    
}