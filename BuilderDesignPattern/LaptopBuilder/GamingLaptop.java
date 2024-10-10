public class GamingLaptop implements LaptopBuilder{
    Laptop laptop;

    GamingLaptop(){
        this.laptop = new Laptop();
    }

    @Override
    public void buildProcessor(String processor) {
        laptop.setProcessor(processor);
        System.out.println("Building Gaming Laptop Processor");
    }

    @Override
    public void buildRam(String ram) {
        laptop.setRam(ram);
        System.out.println("Building Gaming Laptop RAM");
    }

    @Override
    public void buildScreen(String screen) {
        laptop.setScreen(screen);
        System.out.println("Building Gaming Laptop screen");
    }

    @Override
    public void buildTouchPad(String touchpad) {
        laptop.setTouchPad(touchpad);
        System.out.println("Building Gaming Laptop touchpad");
    }

    @Override
    public Laptop getResult() {
        System.out.println("Getting gaming laptop ..... ");
        return laptop;
    }
}
