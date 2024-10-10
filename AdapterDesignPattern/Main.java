public class Main {
    // in order to check if the turkey object is used in place of duck object
    static void test(Duck d){
        d.quack();
        d.fly();
    }
    public static void main(String[] args) {
        Turkey t = new WildTurkey();
        Duck d = new TurkeyAdapter(t);
        test(d);
    }
}