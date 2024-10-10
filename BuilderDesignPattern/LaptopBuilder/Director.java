public class Director {
    LaptopBuilder lb;
    Director(LaptopBuilder lb){
        this.lb = lb;
    }
    void construct(String ram , String processor , String touchpad  , String screen ){
        lb.buildRam(ram);
        lb.buildProcessor(processor);
        lb.buildTouchPad(touchpad);
        lb.buildScreen(screen);
    }
    Laptop geLaptop(){
        return lb.getResult();
    }
}
