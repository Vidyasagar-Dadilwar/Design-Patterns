class Laptop{
    String ram, processor;
    void getRam(){
        System.out.println("Ram : " + ram);
    }
    void setRam(String ram){
        this.ram = ram;
    }
    void getProcessor() {
        System.out.println("Processor : " + processor);
    }

    void setProcessor(String processor) {
        this.processor = processor;
    }
}


interface LaptopBuilder{
    void buildRam(String ram);
    void buildProcessor(String processor);
    Laptop getResult();
}


class GamingLaptop implements LaptopBuilder{
    Laptop lp = new Laptop();
    GamingLaptop(Laptop lp){
        this.lp = lp;
    }
    public void buildRam(String ram){
        lp.setRam(ram);
    }
    public void buildProcessor(String processor){
        lp.setProcessor(processor);
    }
    public Laptop getResult(){
        return this.lp;
    }
}


class Director{
    LaptopBuilder lb;
    Director(LaptopBuilder lb){
        this.lb = lb;
    }
    void construct(String ram, String processor){
        lb.buildRam(ram);
        lb.buildProcessor(processor);
    }
    Laptop geLaptop(){
        return lb.getResult();
    }
}


public class Main{
    public static void main(String[] args) {
        Director d = new Director(new LaptopBuilder());
    }
}