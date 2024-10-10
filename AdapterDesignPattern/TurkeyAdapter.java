// adapter implement target interface
// Adapter is composed of apadtee

public class TurkeyAdapter implements Duck {
    private Turkey turkey;
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    public void fly(){
        // duck flies for larger distance so we can loop over smaller turkey flies
        for(int i=0; i<5; i++)
            turkey.fly();
    }
    public void quack(){
        turkey.gobble();
    }
}