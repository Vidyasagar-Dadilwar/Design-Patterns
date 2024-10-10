interface Button{
    void paint();
}

interface Checkbox{
    void paint();
}

class WinButton implements Button{
    public void paint(){
        System.out.println("Rendering a button in windows style");
    }
}

class MacButton implements Button{
    public void paint(){
        System.out.println("Rendering a button in MAC OS style");
    }
}

class WinCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a checkbox in windows style");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a checkbox in MAC OS style");
    }
}


// abstract factory
interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory 1
class WinFactory implements GUIFactory{
    public Button createButton(){
        Button button = new WinButton();
        return button;
    }

    public Checkbox createCheckbox() {
        Checkbox checkbox = new WinCheckbox();
        return checkbox;
    }
}


// Concrete Factory 2
class MacFactory implements GUIFactory {
    public Button createButton() {
        Button button = new MacButton();
        return button;
    }

    public Checkbox createCheckbox() {
        Checkbox checkbox = new MacCheckbox();
        return checkbox;
    }
}

class Application{
    Button button;
    Checkbox checkbox;

    public Application(GUIFactory guiFactory){
        this.button = guiFactory.createButton();
        this.checkbox = guiFactory.createCheckbox();
    }

    void paint(){
        this.button.paint();
        this.checkbox.paint();
    }
}

public class Guicomponents {
    public static void main(String[] args) {
        Application mac = new Application(new MacFactory());
        mac.paint();

        Application win = new Application(new WinFactory());
        win.paint();

        String osName = (System.getProperty("os.name"));
        // System.out.println(osName);
        if(osName.toLowerCase().contains("win")){
            Application app1 = new Application(new WinFactory());
            app1.paint();
        }
        else{
            Application app2 = new Application(new MacFactory());
            app2.paint();
        }
    }
}