public class Singleton{
    private Singleton(){}
    private static Singleton instance;
    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void print(){
        System.out.println("Hello, World!");
    }

    public static void main(String args[]){
        Singleton s1 = Singleton.getInstance();
        s1.print();
    }
}