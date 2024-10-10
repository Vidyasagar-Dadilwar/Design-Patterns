public interface LaptopBuilder {
    void buildRam(String ram);
    void buildProcessor(String processor);
    void buildTouchPad(String touchpad);
    void buildScreen(String screen);

    Laptop getResult();
}