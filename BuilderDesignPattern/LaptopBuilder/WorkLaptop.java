public class WorkLaptop implements LaptopBuilder {
    Laptop laptop;

    WorkLaptop() {
        this.laptop = new Laptop();
    }

    @Override
    public void buildProcessor(String processor) {
        laptop.setProcessor(processor);
        System.out.println("Building Work Laptop Processor");
    }

    @Override
    public void buildRam(String ram) {
        laptop.setRam(ram);
        System.out.println("Building Work Laptop RAM");
    }

    @Override
    public void buildScreen(String screen) {
        laptop.setScreen(screen);
        System.out.println("Building Work Laptop screen");
    }

    @Override
    public void buildTouchPad(String touchpad) {
        laptop.setTouchPad(touchpad);
        System.out.println("Building Work Laptop touchpad");
    }

    @Override
    public Laptop getResult() {
        System.out.println("Getting Work laptop ..... ");
        return this.laptop;
    }
}
