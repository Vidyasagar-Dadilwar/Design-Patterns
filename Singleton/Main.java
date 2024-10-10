class Singleton1{
    private static Singleton1 s1 = null;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        if(s1 == null){
            synchronized(Singleton1.class){
                if(s1 == null){
                    s1 = new Singleton1();
                }
            }
        }
        return s1;
    }
    void display(){
        System.out.println("Singleton1");
    }
}

public class Main{
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getInstance();
        System.out.println(s1);

        Singleton1 s2 = Singleton1.getInstance();
        System.out.println(s2);
    }
}